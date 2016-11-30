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

	static HashMap<String, BigDecimal> Class1 = new HashMap<String, BigDecimal>(); // acc
	static HashMap<String, BigDecimal> Class2 = new HashMap<String, BigDecimal>(); // unacc
	static HashMap<String, BigDecimal> Class3 = new HashMap<String, BigDecimal>(); // vgood
	static HashMap<String, BigDecimal> Class4 = new HashMap<String, BigDecimal>(); // good
	static BigDecimal allnumber = new BigDecimal("0");
	static BigDecimal number1 = new BigDecimal("0");
	static BigDecimal number2 = new BigDecimal("0");
	static BigDecimal number3 = new BigDecimal("0");
	static BigDecimal number4 = new BigDecimal("0");
	static BigDecimal form = new BigDecimal("1");

	public static void main(String[] args) throws IOException {

		String s;
		BigDecimal resultacc = form;
		BigDecimal resultunacc = form;
		BigDecimal resultvgood = form;
		BigDecimal resultgood = form;

		try {
			BufferedReader br = new BufferedReader(new FileReader("C://Users/Poweruser/Downloads/car_test.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C://Users/Poweruser/Downloads/out.txt"));

			trainingdata(out); // start training!

			BigDecimal allnumbertemp = allnumber;
			BigDecimal number1temp = number1;
			BigDecimal number2temp = number2;
			BigDecimal number3temp = number3;
			BigDecimal number4temp = number4;

			while ((s = br.readLine()) != null) {
				String[] arr = s.split(","); // ',' is delimiter

				for (int i = 0; i < arr.length; i++) {
					String valuess1 = arr[i] + "(" + i + ")" + "|" + "acc"; // Object|Class

					if (!Class1.containsKey(valuess1)) {
						newsetting("acc", valuess1);
					}
					resultacc = resultacc.multiply(Class1.get(valuess1).divide(number1, 3, BigDecimal.ROUND_CEILING));
				}

				for (int i = 0; i < arr.length; i++) {
					String valuess2 = arr[i] + "(" + i + ")" + "|" + "unacc"; // Object|Class

					if (!Class2.containsKey(valuess2)) {
						newsetting("unacc", valuess2);
					}
					resultunacc = resultunacc
							.multiply(Class2.get(valuess2).divide(number2, 3, BigDecimal.ROUND_CEILING));
				}

				for (int i = 0; i < arr.length; i++) {
					String valuess3 = arr[i] + "(" + i + ")" + "|" + "vgood"; // Object|Class

					if (!Class3.containsKey(valuess3)) {
						newsetting("vgood", valuess3);
					}
					resultvgood = resultvgood
							.multiply(Class3.get(valuess3).divide(number3, 3, BigDecimal.ROUND_CEILING));
				}

				for (int i = 0; i < arr.length; i++) {
					String valuess4 = arr[i] + "(" + i + ")" + "|" + "good"; // Object|Class

					if (!Class4.containsKey(valuess4)) {
						newsetting("good", valuess4);
					}
					resultgood = resultgood.multiply(Class4.get(valuess4).divide(number4, 3, BigDecimal.ROUND_CEILING));
				}

				resultacc = resultacc.multiply(Class1.get("acc").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultacc);
				resultunacc = resultunacc.multiply(Class2.get("unacc").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultunacc);
				resultvgood = resultvgood.multiply(Class3.get("vgood").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultvgood);
				resultgood = resultgood.multiply(Class4.get("good").divide(allnumber, 3, BigDecimal.ROUND_CEILING));
				System.out.println(resultgood);
				System.out.println("zz");

				if (resultacc.compareTo(resultunacc) == 1 && resultacc.compareTo(resultvgood) == 1
						&& resultacc.compareTo(resultgood) == 1) {
					String u = s + "의 결과는" + resultacc + "로 acc입니다.";
					out.write(u);
					out.newLine();
				} else if (resultunacc.compareTo(resultacc) == 1 && resultunacc.compareTo(resultvgood) == 1
						&& resultunacc.compareTo(resultgood) == 1) {
					String u = s + "의 결과는" + resultunacc + "로 unacc입니다.";
					out.write(u);
					out.newLine();
				} else if (resultvgood.compareTo(resultacc) == 1 && resultvgood.compareTo(resultunacc) == 1
						&& resultvgood.compareTo(resultgood) == 1) {
					String u = s + "의 결과는" + resultvgood + "로 vgood입니다.";
					out.write(u);
					out.newLine();
				} else {
					String u = s + "의 결과는" + resultgood + "로 good입니다.";
					out.write(u);
					out.newLine();
				}

				allnumber = allnumbertemp;
				number1 = number1temp;
				number2 = number2temp;
				number3 = number3temp;
				number4 = number4temp;
				Class1.replace("acc", number1);
				Class2.replace("unacc", number2);
				Class3.replace("vgood", number3);
				Class4.replace("good", number4);
				resultacc = form;
				resultunacc = form;
				resultvgood = form;
				resultgood = form;
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
			BufferedReader br = new BufferedReader(new FileReader("C://Users/Poweruser/Downloads/car_train.txt"));
			while ((s = br.readLine()) != null) {
				allnumber = allnumber.add(form);
				String[] arr = s.split(","); // ',' is delimiter

				String classname = arr[6];

				if (classname.equals("acc")) {
					number1 = number1.add(form); // # of Class1
				} else if (classname.equals("unacc")) {
					number2 = number2.add(form); // # of Class2
				} else if (classname.equals("vgood")) {
					number3 = number3.add(form); // # of Class3
				} else {
					number4 = number4.add(form); // # of Class4
				}

				for (int i = 0; i < arr.length - 1; i++) {
					if (classname.equals("acc")) {
						String valuess1 = arr[i] + "(" + i + ")" + "|" + classname; // Object|Class

						if (Class1.containsKey(valuess1)) {
							BigDecimal temp = Class1.get(valuess1);
							Class1.replace(valuess1, temp.add(form));
						} else {
							Class1.put(valuess1, form);
						}

					} else if (classname.equals("unacc")) { // if unacc
						String valuess2 = arr[i] + "(" + i + ")" + "|" + classname; // Object|Class

						if (Class2.containsKey(valuess2)) {
							BigDecimal temp = Class2.get(valuess2);
							Class2.replace(valuess2, temp.add(form));
						} else {
							Class2.put(valuess2, form);
						}
					} else if (classname.equals("vgood")) { // if vgood
						String valuess3 = arr[i] + "(" + i + ")" + "|" + classname; // Object|Class

						if (Class3.containsKey(valuess3)) {
							BigDecimal temp = Class3.get(valuess3);
							Class3.replace(valuess3, temp.add(form));
						} else {
							Class3.put(valuess3, form);
						}
					} else { // if good
						String valuess4 = arr[i] + "(" + i + ")" + "|" + classname; // Object|Class

						if (Class4.containsKey(valuess4)) {
							BigDecimal temp = Class4.get(valuess4);
							Class4.replace(valuess4, temp.add(form));
						} else {
							Class4.put(valuess4, form);
						}
					}
				}
			}

			Class1.put("acc", number1);
			Class2.put("unacc", number2);
			Class3.put("vgood", number3);
			Class4.put("good", number4);

			String sts = "★training result★";
			out.write(sts);
			out.newLine();

			Set<String> keys1 = Class1.keySet();
			Iterator<String> itr1 = keys1.iterator();

			while (itr1.hasNext()) {
				String keyss1 = itr1.next();
				BigDecimal valuess1 = Class1.get(keyss1);
				String st;

				if (!keyss1.equals("acc")) {
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

				if (!keyss2.equals("unacc")) {
					st = "P(" + keyss2 + ") = " + valuess2.divide(number2, 3, BigDecimal.ROUND_CEILING);
				} else {
					st = "P(" + keyss2 + ") = " + valuess2.divide(allnumber, 3, BigDecimal.ROUND_CEILING);
				}
				out.write(st);
				out.newLine();

			}

			Set<String> keys3 = Class3.keySet();
			Iterator<String> itr3 = keys3.iterator();

			while (itr3.hasNext()) {
				String keyss3 = itr3.next();
				BigDecimal valuess3 = Class3.get(keyss3);
				String st;

				if (!keyss3.equals("vgood")) {
					st = "P(" + keyss3 + ") = " + valuess3.divide(number3, 3, BigDecimal.ROUND_CEILING);
				} else {
					st = "P(" + keyss3 + ") = " + valuess3.divide(allnumber, 3, BigDecimal.ROUND_CEILING);
				}
				out.write(st);
				out.newLine();

			}

			Set<String> keys4 = Class4.keySet();
			Iterator<String> itr4 = keys4.iterator();

			while (itr4.hasNext()) {
				String keyss4 = itr4.next();
				BigDecimal valuess4 = Class4.get(keyss4);
				String st;

				if (!keyss4.equals("good")) {
					st = "P(" + keyss4 + ") = " + valuess4.divide(number4, 3, BigDecimal.ROUND_CEILING);
				} else {
					st = "P(" + keyss4 + ") = " + valuess4.divide(allnumber, 3, BigDecimal.ROUND_CEILING);
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
		if (classname.equals("acc")) {
			number1 = number1.add(form);
			Class1.put(Objects, form);
		} else if (classname.equals("unacc")) {
			number2 = number2.add(form);
			Class2.put(Objects, form);
		} else if (classname.equals("vgood")) {
			number3 = number3.add(form);
			Class3.put(Objects, form);
		} else {
			number4 = number4.add(form);
			Class4.put(Objects, form);
		}

		Class1.replace("acc", number1);
		Class2.replace("unacc", number2);
		Class3.replace("vgood", number3);
		Class4.replace("good", number4);
	}
}
