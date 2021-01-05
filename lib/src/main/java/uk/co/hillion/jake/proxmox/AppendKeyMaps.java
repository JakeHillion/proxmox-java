package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AppendKeyMaps {
  @JsonAnyGetter
  default Map<String, Object> getProperties() throws JsonProcessingException {
    Map<String, Object> out = new HashMap<>();

    Properties p = Properties.of(this.getClass());
    for (Field field : p.getFields()) {
      // TODO: Use the Jackson logic to get the name
      String fieldName = field.getName();

      try {
        Map fieldVal = (Map) field.get(this);
        for (Object obj : fieldVal.entrySet()) {
          Map.Entry entry = (Map.Entry) obj;
          out.put(String.format("%s%s", fieldName, entry.getKey()), entry.getValue());
        }
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }

    return out;
  }

  @JsonAnySetter
  default void setProperty(String key, String value) {
    Properties p = Properties.of(this.getClass());
    Map.Entry<Field, String> match = p.getFieldMatch(key);
    if (match != null) {
      Field field = match.getKey();

      Type genericFieldType = field.getGenericType();
      ParameterizedType fieldType = (ParameterizedType) genericFieldType;
      Type[] fieldArgTypes = fieldType.getActualTypeArguments();

      Object mapKey = match.getValue();
      if (fieldArgTypes[0] == Integer.class) {
        mapKey = Integer.parseInt(match.getValue());
      }

      try {
        Map map = (Map) field.get(this);
        if (map == null) {
          map = new HashMap();
          field.set(this, map);
        }
        map.put(mapKey, value);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  @JacksonAnnotationsInside
  @JsonIgnore
  @interface AppendKeyMap {}

  class Properties {
    private final Map<Field, Pattern> patternFieldMap;

    private Properties(Map<Field, Pattern> patternFieldMap) {
      this.patternFieldMap = Map.copyOf(patternFieldMap);
    }

    private static <T> Properties of(Class<T> clazz) {
      Map<Field, Pattern> map = new HashMap<>();

      for (Field field : clazz.getFields()) {
        if (field.isAnnotationPresent(AppendKeyMap.class)) {
          // TODO: Use the Jackson logic to get the name
          String fieldName = field.getName();

          if (!field.getType().isAssignableFrom(Map.class)) {
            throw new RuntimeException("field not a map");
          }

          Type genericFieldType = field.getGenericType();
          ParameterizedType fieldType = (ParameterizedType) genericFieldType;
          Type[] fieldArgTypes = fieldType.getActualTypeArguments();

          Pattern pattern;
          if (fieldArgTypes[0] == Integer.class) {
            pattern = Pattern.compile(String.format("%s(\\d+)", fieldName));
          } else {
            pattern = Pattern.compile(String.format("%s(.+)", fieldName));
          }

          map.put(field, pattern);
        }
      }

      return new Properties(map);
    }

    private Map.Entry<Field, String> getFieldMatch(String key) {
      for (Map.Entry<Field, Pattern> entry : patternFieldMap.entrySet()) {
        Matcher result = entry.getValue().matcher(key);
        if (result.find()) {
          return Map.entry(entry.getKey(), result.group(1));
        }
      }
      return null;
    }

    private Collection<Field> getFields() {
      return patternFieldMap.keySet();
    }
  }
}
