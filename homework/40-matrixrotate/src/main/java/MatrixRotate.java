import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixRotate {
    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        int numbers = 0;
        int[][] chart = new int[1005][1005];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String temp = br.readLine();
            String [] strTemp = temp.split(" ");
            m = Integer.parseInt(strTemp[0]);
            n = Integer.parseInt(strTemp[1]);
            for (int i = 0; i < m; i++) {
                temp = br.readLine();
                String [] str = temp.split(" ");
                for (int j = 0; j < n; j++) {
                    chart[i][j] = Integer.parseInt(str[j]);
                }
            }
            temp = br.readLine();
            numbers = Integer.parseInt(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        numbers = numbers / 90;
        numbers = numbers % 4;
        if (numbers == 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(chart[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } else if (numbers == 1) {
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    System.out.print(chart[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } else if (numbers == 2) {
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(chart[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } else {
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < m; i++) {
                    System.out.print(chart[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
