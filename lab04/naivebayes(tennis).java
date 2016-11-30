package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class naivebayes {

	static HashMap<String, BigDecimal> Class1 = new HashMap<String, BigDecimal>(); // Yes
	static HashMap<String, BigDecimal> Class2 = new HashMap<String, BigDecimal>(); // No
	static BigDecimal allnumber = new BigDecimal("0");
	static BigDecimal number1 = new BigDecimal("0");
	static BigDecimal number2 = new BigDecimal("0");
	static BigDecimal form = new BigDecimal("1");

	public static void main(String[] args) throws IOException {

		String s;
		BigDecimal resultyes = form;
		BigDecimal resultno = form;

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C://Users/Poweruser/Downloads/play-tennis_test.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C://Users/Poweruser/Downloads/out.txt"));

			trainingdata(out); // start training!

			BigDecimal allnumbertemp = allnumber;
			BigDecimal number1temp = number1;
			BigDecimal number2temp = number2;

			while ((s = br.readLine()) != null) {
				String[] arr = s.split(","); // ',' is delimiter

				for (int i = 0; i < arr.length; i++) {
					String valuess1 = arr[i] + "|" + "Yes"; // Object|Class

					System.out.println(resultyes);
					if (!Class1.containsKey(valuess1)) {
						newsetting("Yes", valuess1);
					}
					System.out.println(Class1.get(valuess1).divide(number1, 3, BigDecimal.ROUND_CEILING));
					resultyes = resultyes.multiply(Class1.get(valuess1).divide(number1, 3, BigDecimal.ROUND_CEILING));
					System.out.println(resultyes + "z");
				}

				for (int i = 0; i < arr.length; i++) {
					String valuess2 = arr[i] + "|" + "No"; // Object|Class

					if (!Class2.containsKey(valuess2)) {
						System.out.println(valuess2);
						newsetting("No", valuess2);
					}
					System.out.println(Class2.get(valuess2));
					resultno = resultno.multiply(Class2.get(valuess2).divide(number2, 3, BigDecimal.ROUND_CEILING));
					System.out.println(resultno + "zz");
				}

				resultyes = resultyes.multiply(Class1.get("Yes").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultyes);
				resultno = resultno.multiply(Class2.get("No").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultno);

				if (resultyes.compareTo(resultno) == 1) {
					String u = s + "의 결과는" + resultyes + "로 yes입니다.";
					out.write(u);
					out.newLine();
				} else {
					String u = s + "의 결과는" + resultno + "로 no입니다.";
					out.write(u);
					out.newLine();
				}

				allnumber = allnumbertemp;
				number1 = number1temp;
				number2 = number2temp;
				Class1.replace("Yes", number1);
				Class2.replace("No", number2);
				resultyes = form;
				resultno = form;
			}

			out.close();
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void trainingdata(BufferedWriter out) {
		String s;

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C://Users/Poweruser/Downloads/play-tennis_train.txt"));
			while ((s = br.readLine()) != null) {
				allnumber = allnumber.add(form);
				String[] arr = s.split(","); // ',' is delimiter

				String classname = arr[4];

				if (classname.equals("Yes")) {
					number1 = number1.add(form); // # of Class1
				} else {
					number2 = number2.add(form); // # of Class2
				}

				for (int i = 0; i < arr.length - 1; i++) { // Outlook,
															// Temperature,
															// Humidity, Wind
					if (classname.equals("Yes")) {
						String valuess1 = arr[i] + "|" + classname; // Object|Class

						if (Class1.containsKey(valuess1)) {
							BigDecimal temp = Class1.get(valuess1);
							Class1.replace(valuess1, temp.add(form));
						} else {
							Class1.put(valuess1, form);
						}

					} else { // if No
						String valuess2 = arr[i] + "|" + classname; // Object|Class

						if (Class2.containsKey(valuess2)) {
							BigDecimal temp = Class2.get(valuess2);
							Class2.replace(valuess2, temp.add(form));
						} else {
							Class2.put(valuess2, form);
						}
					}
				}
			}

			Class1.put("Yes", number1);
			Class2.put("No", number2);

			String sts = "training 결과";
			out.write(sts);
			out.newLine();

			Set<String> keys1 = Class1.keySet();
			Iterator<String> itr1 = keys1.iterator();

			while (itr1.hasNext()) {
				String keyss1 = itr1.next();
				BigDecimal valuess1 = Class1.get(keyss1);
				String st;

				if (!keyss1.equals("Yes")) {
					st = "P(" + keyss1 + ") = " + valuess1.divide(number1, 3, BigDecimal.ROUND_CEILING);
				} else {
					st = "P(" + keyss1 + ") = " + valuess1.divide(allnumber, 3, BigDecimal.ROUND_CEILING);
				}
				out.write(st);
				out.newLine();
			}

			Set<String> keys2 = Class2.keySet();
			Iterator<String> itr2 = keys2.iterator();

			while (itr2.hasNext()) {
				String keyss2 = itr2.next();
				BigDecimal valuess2 = Class2.get(keyss2);
				String st;

				if (!keyss2.equals("No")) {
					st = "P(" + keyss2 + ") = " + valuess2.divide(number2, 3, BigDecimal.ROUND_CEILING);
				} else {
					st = "P(" + keyss2 + ") = " + valuess2.divide(allnumber, 3, BigDecimal.ROUND_CEILING);
				}
				out.write(st);
				out.newLine();
				
			}

			br.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	public static void newsetting(String classname, String Objects) {
		allnumber = allnumber.add(form);
		if (classname.equals("Yes")) {
			number1 = number1.add(form);
			Class1.put(Objects, form);
		} else {
			number2 = number2.add(form);
			Class2.put(Objects, form);
		}

		Class1.replace("Yes", number1);
		Class2.replace("No", number2);
	}
}
