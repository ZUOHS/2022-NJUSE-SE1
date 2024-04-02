import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZTransformation {
    public static void main(String[] args) {
        String message = null;
        int n = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            message = br.readLine();
            String here = null;
            here = br.readLine();
            n = Integer.parseInt(here);
        } catch (IOException e){
            e.printStackTrace();
        }
        assert message != null;
        int len = message.length();
        if (n == 1) {
            char temp;
            for (int i = 0; i < len - 1; i++) {
                temp = message.charAt(i);
                System.out.print(temp);
                System.out.print(" ");
            }
            temp = message.charAt(len - 1);
            System.out.println(temp);
            return;
        }
        int wide = (len / 2) + 1;
        char [][] array = new char[n + 1][len + n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len + n; j++) {
                array[i][j] = ' ';
            }
        }
        int position_x = 0;
        int position_y = 0;
LOOP1:        for (int i = 0; i < len / (2 * n - 2) + 1; i++) {
                  for (int j = 0; j < n - 1; j++) {
                      array[position_y][position_x] = message.charAt(i * (2 * n - 2) + j);
                      if (i * (2 * n - 2) + j == len - 1) {
                          break LOOP1;
                      }
                      position_y += 1;
                  }
                  for (int j = n - 1; j < 2 * n - 2; j++) {
                      array[position_y][position_x] = message.charAt(i * (2 * n - 2) + j);
                      if (i * (2 * n - 2) + j == len - 1) {
                          break LOOP1;
                      }
                      position_x += 1;
                      position_y -= 1;
                  }
              }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < wide + 1; j++) {
                if (j == 0 && array[i][j] == ' ') {
                    System.out.println();
                    j = wide + 1;
                } else if (array[i][j] == ' ') {
                    System.out.print(' ');
                    System.out.print(' ');
                } else {
                    for (int k = 1; k < n; k++) {
                        if (array[i][j + k] != ' ') {
                            System.out.print(array[i][j]);
                            System.out.print(' ');
                            break;
                        } else if (k == n - 1) {
                            System.out.println(array[i][j]);
                            j = wide + 1;
                        }
                    }
                }
            }
        }
    }
}