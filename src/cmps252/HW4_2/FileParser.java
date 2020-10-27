package cmps252.HW4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	private static final String DELIMITER = "\",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)\"";
	public static List<Customer> getCustomers(String file) throws FileNotFoundException {
		List<Customer> Customers = new ArrayList<Customer>();
		try (Scanner scanner = new Scanner(new File(file));) {
			int lineNumber = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (lineNumber++ == 0)
					continue;
				
				String[] fields = line.split(DELIMITER);
				if (fields == null || fields.length==0) {
					continue;
				}
				Customer s = new Customer(fields[0].substring(1), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11].substring(0,fields[11].length()-1));
				Customers.add(s);
			}
		}
		return Customers;
	}
}
