package vjvm.utils;

import lombok.SneakyThrows;
import lombok.var;

/*
 * Re-implement reading int, long and char to avoid attaching a scanner to stdin
 */
public class InputUtils {

  @SneakyThrows
  public static int readInt() {
    return (int) readLong();
  }

  @SneakyThrows
  public static long readLong() {
    var in = System.in;
    long i = 0;
    boolean negative = false;
    int c = in.read();

    while (Character.isWhitespace(c)) {
      c = in.read();
    }

    if (c == '-') {
      negative = true;
      c = '0';
    }

    while (Character.isDigit(c)) {
      i *= 10;
      i += c - '0';
      c = in.read();
    }
    return negative ? -i : i;
  }

  @SneakyThrows
  public static char readChar() {
    int c = System.in.read();
    while (Character.isWhitespace(c)) {
      c = System.in.read();
    }
    return (char) c;
  }
}
