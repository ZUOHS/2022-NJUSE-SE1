import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class testCSVFile {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String [] order = br.readLine().split(" ");
            if (Objects.equals(order[1], "*")) {
                order[1] = "Last_name,First_name,Salary,Department,Employee_id";
            }
            String [] first = order[1].split(",");
            String by = null;
            int limit = 0;
            for (int i = 0; i < order.length - 1; i++) {
                if (Objects.equals(order[i], "by")) {
                    by = order[i + 1];
                } else if (Objects.equals(order[i], "limit")) {
                    limit = Integer.parseInt(order[i + 1]);
                }
            }

            File myFile = new File(args[0]);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            String [][] array = new String[1003][first.length];
            int count = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < first.length; i++) {
                    switch (first[i]) {
                        case "Last_name":
                            array[count][i] = line.split(",")[0];
                            break;
                        case "First_name":
                            array[count][i] = line.split(",")[1];
                            break;
                        case "Salary":
                            array[count][i] = line.split(",")[2];
                            break;
                        case "Department":
                            array[count][i] = line.split(",")[3];
                            break;
                        case "Employee_id":
                            array[count][i] = line.split(",")[4];
                            break;
                    }
                }
                count++;
            }
            if (limit == 0) {
                limit = count;
            }
            int key = 100;
            for (int i = 0; i < first.length; i++) {
                if (Objects.equals(by, first[i])) {
                    key = i;
                }
            }
            if (by != null) {
                for (int i = 0; i < count - 1; i++) {
                    for (int j = 0; j < count - 1; j++) {
                        if (Integer.parseInt(array[j][key]) < Integer.parseInt(array[j + 1][key])) {
                            for (int k = 0; k < first.length; k++) {
                                String temp = array[j][k];
                                array[j][k] = array[j + 1][k];
                                array[j + 1][k] = temp;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < first.length; i++) {
                System.out.print(first[i]);
                if (i != first.length - 1) {
                    System.out.print("    ");
                } else {
                    System.out.println();
                }
            }
            for (int i = 0; i < limit; i++) {
                for (int j = 0; j < first.length; j++) {
                    System.out.print(array[i][j]);
                    if (j != first.length - 1) {
                        System.out.print("    ");
                    }
                }
                if (i != limit - 1) {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}