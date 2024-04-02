import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurrencyCalculation {

	public static void main(String[] args) {
		double euros = 0;
		double rate = 0;
		double dollar = 0;
		String temp = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("How many euros are you exchanging?");
			temp = br.readLine();
			euros = Double.parseDouble(temp);
			System.out.println("What is the exchange rate?");
			temp = br.readLine();
			rate = Double.parseDouble(temp);
			dollar = euros * rate / 100;
			System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euros, rate, dollar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
