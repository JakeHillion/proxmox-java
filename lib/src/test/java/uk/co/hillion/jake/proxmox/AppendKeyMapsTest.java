package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppendKeyMapsTest {
  @Test
  void testAppendKeyMapExtension_SingleKey_MarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    TestClass test = new TestClass();
    test.data = Map.of(4, "hello world");

    // ACT
    String marshalled = new ObjectMapper().writeValueAsString(test);

    // ASSERT
    assertThat(marshalled).isEqualTo(new ObjectMapper().writeValueAsString(Map.of("data4", "hello world")));
  }

  @Test
  void testAppendKeyMapExtension_SingleKey_UnmarshalsCorrectly() throws JsonProcessingException {
    // ASSIGN
    String json = new ObjectMapper().writeValueAsString(Map.of("data4", "hello world"));

    // ACT
    TestClass unmarshalled = new ObjectMapper().readValue(json, TestClass.class);

    // ASSERT
    assertThat(unmarshalled.data).isNotNull().hasSize(1).containsKey(4).containsEntry(4, "hello world");
  }

  public static class TestClass implements AppendKeyMaps {
    @AppendKeyMap
    public Map<Integer, String> data;
  }
}
