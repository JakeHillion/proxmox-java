package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class AppendKeyMapsTest {
  static Condition<String> jsonEquals(Object expected) {
    JsonNode expectedTree = new ObjectMapper().valueToTree(expected);

    Predicate<String> pred =
        actual -> {
          try {
            return expectedTree.equals(new ObjectMapper().readTree(actual));
          } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
          }
        };

    return new Condition<>(pred, "json equals");
  }

  @Test
  void testAppendKeyMaps_SingleKey_MarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    TestClassOnlyMap test = new TestClassOnlyMap();
    test.data = Map.of(4, "hello world");

    // ACT
    String marshalled = new ObjectMapper().writeValueAsString(test);

    // ASSERT
    assertThat(marshalled).is(jsonEquals(Map.of("data4", "hello world")));
  }

  @Test
  void testAppendKeyMaps_SingleKey_UnmarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    String json = new ObjectMapper().writeValueAsString(Map.of("data4", "hello world"));

    // ACT
    TestClassOnlyMap unmarshalled = new ObjectMapper().readValue(json, TestClassOnlyMap.class);

    // ASSERT
    assertThat(unmarshalled.data)
        .isNotNull()
        .hasSize(1)
        .containsKey(4)
        .containsEntry(4, "hello world");
  }

  @Test
  void testAppendKeyMaps_MultipleKeys_MarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    TestClassOnlyMap test = new TestClassOnlyMap();
    test.data = Map.of(1, "value1", 2, "value2");

    // ACT
    String marshalled = new ObjectMapper().writeValueAsString(test);

    // ASSERT
    assertThat(marshalled).is(jsonEquals(Map.of("data1", "value1", "data2", "value2")));
  }

  @Test
  void testAppendKeyMaps_MultipleKeys_UnmarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    String json =
        new ObjectMapper().writeValueAsString(Map.of("data1", "value1", "data2", "value2"));

    // ACT
    TestClassOnlyMap unmarshalled = new ObjectMapper().readValue(json, TestClassOnlyMap.class);

    // ASSERT
    assertThat(unmarshalled.data)
        .isNotNull()
        .hasSize(2)
        .containsKey(1)
        .containsEntry(1, "value1")
        .containsKey(2)
        .containsEntry(2, "value2");
  }

  @Test
  void testAppendKeyMaps_SimpleNameCollision_MarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    TestClassDefaultNamesCollideSimpleAnnotation test =
        new TestClassDefaultNamesCollideSimpleAnnotation();
    test.dataField = "value";
    test.data = Map.of(1, "value1");

    // ACT
    String marshalled = new ObjectMapper().writeValueAsString(test);

    // ASSERT
    assertThat(marshalled).is(jsonEquals(Map.of("data", "value", "data1", "value1")));
  }

  @Test
  void testAppendKeyMaps_SimpleNameCollision_UnmarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    String json = new ObjectMapper().writeValueAsString(Map.of("data", "value", "data1", "value1"));

    // ACT
    TestClassDefaultNamesCollideSimpleAnnotation unmarshalled =
        new ObjectMapper().readValue(json, TestClassDefaultNamesCollideSimpleAnnotation.class);

    // ASSERT
    assertThat(unmarshalled.dataField).isNotNull().isEqualTo("value");
    assertThat(unmarshalled.data).isNotNull().hasSize(1).containsKey(1).containsEntry(1, "value1");
  }

  @Test
  void testAppendKeyMaps_ComplexNameCollision_MarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    TestClassDefaultNamesCollideComplexAnnotation test =
        new TestClassDefaultNamesCollideComplexAnnotation();
    test.data = "value";
    test.dataMap = Map.of(1, "value1");

    // ACT
    String marshalled = new ObjectMapper().writeValueAsString(test);

    // ASSERT
    assertThat(marshalled).is(jsonEquals(Map.of("data", "value", "data1", "value1")));
  }

  @Test
  void testAppendKeyMaps_ComplexNameCollision_UnmarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    String json = new ObjectMapper().writeValueAsString(Map.of("data", "value", "data1", "value1"));

    // ACT
    TestClassDefaultNamesCollideComplexAnnotation unmarshalled =
        new ObjectMapper().readValue(json, TestClassDefaultNamesCollideComplexAnnotation.class);

    // ASSERT
    assertThat(unmarshalled.data).isNotNull().isEqualTo("value");
    assertThat(unmarshalled.dataMap)
        .isNotNull()
        .hasSize(1)
        .containsKey(1)
        .containsEntry(1, "value1");
  }

  public static class TestClassOnlyMap implements AppendKeyMaps {
    @AppendKeyMap public Map<Integer, String> data;
  }

  public static class TestClassDefaultNamesCollideSimpleAnnotation implements AppendKeyMaps {
    @JsonProperty("data")
    public String dataField;

    @AppendKeyMap public Map<Integer, String> data;
  }

  public static class TestClassDefaultNamesCollideComplexAnnotation implements AppendKeyMaps {
    public String data;

    @AppendKeyMap
    @JsonProperty("data")
    public Map<Integer, String> dataMap;
  }
}
