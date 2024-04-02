import java.io.*;

public class FileReader {
    public String readFile(String filePath) throws IOException {
        byte [] result = new byte[2000];
        int count = 0;
        int read = 0;
        try {
            File myFile = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(myFile);
            while ((read = fileInputStream.read()) >= 0) {
                result [count] = (byte)read;
                count += 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(result, 0, count);
    }
}