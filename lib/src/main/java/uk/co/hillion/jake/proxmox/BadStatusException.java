package uk.co.hillion.jake.proxmox;

import java.io.IOException;

public class BadStatusException extends IOException {
  BadStatusException(int code) {
    super(String.format("bad status (%d)", code));
  }
}
