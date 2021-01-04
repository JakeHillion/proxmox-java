package uk.co.hillion.jake.proxmox;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;

public class ConcatenatedIntMap<T> extends HashMap<Integer, T> {}

class ConcatenatedIntMapAdapter<T> extends TypeAdapter<ConcatenatedIntMap<T>> {

  @Override
  public ConcatenatedIntMap<T> read(JsonReader in) throws IOException {
    return null;
  }

  @Override
  public void write(JsonWriter out, ConcatenatedIntMap<T> value) throws IOException {

  }
}
