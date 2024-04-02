package vjvm.classloader.searchpath;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DirSearchPath extends ClassSearchPath{
  public final Path SearchPath;

  public DirSearchPath(String searchPath) {
    SearchPath = FileSystems.getDefault().getPath(searchPath);
  }

  @Override
  public InputStream findClass(String name) {
    File target = SearchPath.resolve(name + ".class").toFile();
    try {
      return new FileInputStream(target);
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  @Override
  public void close() throws IOException {
  }
}
