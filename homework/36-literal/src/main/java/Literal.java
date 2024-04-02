import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Literal {

    public static void main(String[] args) {
        String value = null;
        int mark = 0;
        //1 is int
        //2 for long
        //3 is float
        //4 stands for double
        //5 for char
        //6 represents boolean
        int len = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            value = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert value != null;
        len = value.length();

        for (int i = 0; i < len; i++) {
            String temp = value.substring(i, i + 1);
            int ch = value.charAt(i);
            if (temp.equals(".")) {
                mark = 4;
                break;
            } else if (ch < 48 || ch > 57) {
                break;
            } else if (i == len - 1) {
                mark = 1;
            }
        }

        if (value.equals("true") || value.equals("false")) {
            mark = 6;
        } else if (len > 1) {
            String test = value.substring(len - 1);
            String judge = value.substring(len - 2, len - 1);
            int ch = value.charAt(len - 2);
            if (judge.equals("l") && test.equals("f")) {
                mark = 4;
            } else if (ch >= 48 && ch <= 57) {
                if (test.equals("d")) {
                    mark = 1;
                } else if (test.equals("L")) {
                    mark = 2;
                } else if (test.equals("f")) {
                    mark = 3;
                } else if (test.equals("s")) {
                    mark = 5;
                }
            }
        }
        if (mark == 0) {
            mark = 5;
        }

        if (mark == 1) {
            System.out.println("integer");
        } else if (mark == 2) {
            System.out.println("long");
        } else if (mark == 3) {
            System.out.println("float");
        } else if (mark == 4) {
            System.out.println("double");
        } else if (mark == 5) {
            System.out.println("char");
        } else if (mark == 6) {
            System.out.println("boolean");
        }
    }
}
