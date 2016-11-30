package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Numerical {
	static Node tree1;
	static Node tree2;
	static Node tree3;
	static Node tree4;
	static Node tree5;
	static Node tree6;
	static Node tree7;
	static Node tree8;
	static Node tree9;
	static Node tree10;

	public static void main(String[] args) throws IOException {
		String s;
		int count1 = 0; // 전체 데이터의 갯수
		int count2 = 0; // 전체 데이터의 갯수
		int count3 = 0; // 전체 데이터의 갯수
		int count4 = 0; // 전체 데이터의 갯수
		int count5 = 0; // 전체 데이터의 갯수
		int count6 = 0; // 전체 데이터의 갯수
		int count7 = 0; // 전체 데이터의 갯수
		int count8 = 0; // 전체 데이터의 갯수
		int count9 = 0; // 전체 데이터의 갯수
		int count10 = 0; // 전체 데이터의 갯수

		int countt1 = 0; // 전체 데이터의 갯수
		int countt2 = 0; // 전체 데이터의 갯수
		int countt3 = 0; // 전체 데이터의 갯수
		int countt4 = 0; // 전체 데이터의 갯수
		int countt5 = 0; // 전체 데이터의 갯수
		int countt6 = 0; // 전체 데이터의 갯수
		int countt7 = 0; // 전체 데이터의 갯수
		int countt8 = 0; // 전체 데이터의 갯수
		int countt9 = 0; // 전체 데이터의 갯수
		int countt10 = 0; // 전체 데이터의 갯수

		String[] dataarray1 = new String[90];
		String[] testarray1 = new String[10];
		String[] dataarray2 = new String[90];
		String[] testarray2 = new String[10];
		String[] dataarray3 = new String[90];
		String[] testarray3 = new String[10];
		String[] dataarray4 = new String[90];
		String[] testarray4 = new String[10];
		String[] dataarray5 = new String[90];
		String[] testarray5 = new String[10];
		String[] dataarray6 = new String[90];
		String[] testarray6 = new String[10];
		String[] dataarray7 = new String[90];
		String[] testarray7 = new String[10];
		String[] dataarray8 = new String[90];
		String[] testarray8 = new String[10];
		String[] dataarray9 = new String[90];
		String[] testarray9 = new String[10];
		String[] dataarray10 = new String[90];
		String[] testarray10 = new String[10];

		HashMap<String, Integer> datasum1 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum2 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum3 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum4 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum5 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum6 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum7 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum8 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum9 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum10 = new HashMap<String, Integer>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("C://Users/Poweruser/Downloads/train_rev2.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C://Users/Poweruser/Downloads/out.txt"));
			int scount = 0;
			while ((s = br.readLine()) != null) {
				String[] arr = s.split(","); // ',' is delimiter

				if (!(0 <= scount && scount <= 9)) {
					dataarray1[count1] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray1[count1] += arr[i] + "|";

					}

					count1 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum1.containsKey(classout)) {
							datasum1.put(classout, 1);
						} else {
							int tempvalue = datasum1.get(classout);
							datasum1.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray1[countt1] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray1[countt1] += arr[i] + "|";

					}

					countt1 += 1;
				}

				if (!(10 <= scount && scount <= 19)) {

					dataarray2[count2] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray2[count2] += arr[i] + "|";

					}

					count2 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum2.containsKey(classout)) {
							datasum2.put(classout, 1);
						} else {
							int tempvalue = datasum2.get(classout);
							datasum2.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray2[countt2] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray2[countt2] += arr[i] + "|";

					}

					countt2 += 1;
				}

				if (!(20 <= scount && scount <= 29)) {

					dataarray3[count3] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray3[count3] += arr[i] + "|";

					}

					count3 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum3.containsKey(classout)) {
							datasum3.put(classout, 1);
						} else {
							int tempvalue = datasum3.get(classout);
							datasum3.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray3[countt3] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray3[countt3] += arr[i] + "|";

					}

					countt3 += 1;
				}

				if (!(30 <= scount && scount <= 39)) {

					dataarray4[count4] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray4[count4] += arr[i] + "|";

					}

					count4 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum4.containsKey(classout)) {
							datasum4.put(classout, 1);
						} else {
							int tempvalue = datasum4.get(classout);
							datasum4.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray4[countt4] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray4[countt4] += arr[i] + "|";

					}

					countt4 += 1;
				}

				if (!(40 <= scount && scount <= 49)) {

					dataarray5[count5] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray5[count5] += arr[i] + "|";

					}

					count5 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum5.containsKey(classout)) {
							datasum5.put(classout, 1);
						} else {
							int tempvalue = datasum5.get(classout);
							datasum5.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray5[countt5] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray5[countt5] += arr[i] + "|";

					}

					countt5 += 1;
				}

				if (!(50 <= scount && scount <= 59)) {

					dataarray6[count6] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray6[count6] += arr[i] + "|";

					}

					count6 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum6.containsKey(classout)) {
							datasum6.put(classout, 1);
						} else {
							int tempvalue = datasum6.get(classout);
							datasum6.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray6[countt6] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray6[countt6] += arr[i] + "|";

					}

					countt6 += 1;
				}

				if (!(60 <= scount && scount <= 69)) {

					dataarray7[count7] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray7[count7] += arr[i] + "|";

					}

					count7 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum7.containsKey(classout)) {
							datasum7.put(classout, 1);
						} else {
							int tempvalue = datasum7.get(classout);
							datasum7.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray7[countt7] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray7[countt7] += arr[i] + "|";

					}

					countt7 += 1;
				}

				if (!(70 <= scount && scount <= 79)) {

					dataarray8[count8] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray8[count8] += arr[i] + "|";

					}

					count8 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum8.containsKey(classout)) {
							datasum8.put(classout, 1);
						} else {
							int tempvalue = datasum8.get(classout);
							datasum8.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray8[countt8] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray8[countt8] += arr[i] + "|";

					}

					countt8 += 1;
				}

				if (!(80 <= scount && scount <= 89)) {

					dataarray9[count9] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray9[count9] += arr[i] + "|";

					}

					count9 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum9.containsKey(classout)) {
							datasum9.put(classout, 1);
						} else {
							int tempvalue = datasum9.get(classout);
							datasum9.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray9[countt9] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray9[countt9] += arr[i] + "|";

					}

					countt9 += 1;
				}

				if (!(90 <= scount && scount <= 99)) {

					dataarray10[count10] = "";

					for (int i = 0; i < arr.length; i++) {

						dataarray10[count10] += arr[i] + "|";

					}

					count10 += 1;

					for (int i = 0; i < arr.length; i++) {
						String classout;

						classout = arr[i] + "|" + arr[26] + "|kind" + Integer.toString(i + 1);

						if (!datasum10.containsKey(classout)) {
							datasum10.put(classout, 1);
						} else {
							int tempvalue = datasum10.get(classout);
							datasum10.replace(classout, tempvalue + 1);
						}
					}
				} else {

					testarray10[countt10] = "";

					for (int i = 0; i < arr.length; i++) {

						testarray10[countt10] += arr[i] + "|";

					}

					countt10 += 1;
				}

				scount += 1;
			}

			tree1 = Findbestsplit1(tree1, datasum1, 26, "root", "", dataarray1);
			int answer1 = testing(tree1, testarray1);
			out.write("prediction1 (1~10번째 줄까지 테스트 데이터) : "+(double) answer1 / 10);
			out.newLine();
			tree2 = Findbestsplit1(tree2, datasum2, 26, "root", "", dataarray2);
			int answer2 = testing(tree2, testarray2);
			out.write("prediction2 (11~20번째 줄까지 테스트 데이터) : "+(double) answer2 / 10);
			out.newLine();
			tree3 = Findbestsplit1(tree3, datasum3, 26, "root", "", dataarray3);
			int answer3 = testing(tree3, testarray3);
			out.write("prediction3 (21~30번째 줄까지 테스트 데이터) : "+(double) answer3 / 10);
			out.newLine();
			tree4 = Findbestsplit1(tree4, datasum4, 26, "root", "", dataarray4);
			int answer4 = testing(tree4, testarray4);
			out.write("prediction4 (31~40번째 줄까지 테스트 데이터) : "+(double) answer4 / 10);
			out.newLine();
			tree5 = Findbestsplit1(tree5, datasum5, 26, "root", "", dataarray5);
			int answer5 = testing(tree5, testarray5);
			out.write("prediction5 (41~50번째 줄까지 테스트 데이터) : "+(double) answer5 / 10);
			out.newLine();
			tree6 = Findbestsplit1(tree6, datasum6, 26, "root", "", dataarray6);
			int answer6 = testing(tree6, testarray6);
			out.write("prediction6 (51~60번째 줄까지 테스트 데이터) : "+(double) answer6 / 10);
			out.newLine();
			tree7 = Findbestsplit1(tree7, datasum7, 26, "root", "", dataarray7);
			int answer7 = testing(tree7, testarray7);
			out.write("prediction7 (61~70번째 줄까지 테스트 데이터) : "+(double) answer7 / 10);
			out.newLine();
			tree8 = Findbestsplit1(tree8, datasum8, 26, "root", "", dataarray8);
			int answer8 = testing(tree8, testarray8);
			out.write("prediction8 (71~80번째 줄까지 테스트 데이터) : "+(double) answer8 / 10);
			out.newLine();
			tree9 = Findbestsplit1(tree9, datasum9, 26, "root", "", dataarray9);
			int answer9 = testing(tree9, testarray9);
			out.write("prediction9 (81~90번째 줄까지 테스트 데이터) : "+(double) answer9 / 10);
			out.newLine();
			tree10 = Findbestsplit1(tree10, datasum10, 26, "root", "", dataarray10);
			int answer10 = testing(tree10, testarray10);
			out.write("prediction10 (91~100번째 줄까지 테스트 데이터) : "+(double) answer10 / 10);
			out.newLine();
			out.write("총 prediction : "+(double) (answer1 + answer2 + answer3 + answer4 + answer5 + answer6 + answer7 + answer8 + answer9 + answer10) / 100);
			out.newLine();

			out.close();
			br.close();
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String PreFindbestsplit(HashMap<String, Integer> data, String resultpredic) {
		HashMap<String, Integer> tempclassyes = new HashMap<String, Integer>();
		HashMap<String, Integer> tempclassno = new HashMap<String, Integer>();
		HashMap<String, Integer> tempclass = new HashMap<String, Integer>();
		int allnumber = 0;
		int signnumber = 0;

		Set<String> keys = data.keySet(); // 들어온 데이터셋을 정리한다
		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) {
			String keyss = itr.next();

			if (keyss != null) {
				String[] arr = keyss.split("\\|");
				signnumber = arr.length;

				int valuess = data.get(keyss);

				if (!arr[1].equals("kind27")) {
					if (Integer.parseInt(arr[1]) < Integer.parseInt(resultpredic)) {
						if (!tempclassyes.containsKey(arr[0])) {
							tempclassyes.put(arr[0], valuess);
						} else {
							int tempvalue = tempclassyes.get(arr[0]);
							tempclassyes.replace(arr[0], valuess + tempvalue);
						}
					} else { // no
						if (!tempclassno.containsKey(arr[0])) {
							tempclassno.put(arr[0], valuess);
						} else {
							int tempvalue = tempclassno.get(arr[0]);
							tempclassno.replace(arr[0], valuess + tempvalue);
						}
					}
				}

				if (!tempclass.containsKey(arr[0])) {
					tempclass.put(arr[0], valuess);
				} else {
					int tempvalue = tempclass.get(arr[0]);
					tempclass.replace(arr[0], valuess + tempvalue);
				}

				allnumber += valuess;
			}
		}

		BigDecimal bestvalue = new BigDecimal("0");
		String bestnode = null;
		int tempcount1 = 0;
		int tempcount2 = 0;

		Set<String> key = tempclass.keySet();
		Iterator<String> it = key.iterator();

		BigDecimal temp = new BigDecimal("0");

		while (it.hasNext()) {
			String keyss = it.next(); // 첫번째 스트링부터 먼저 계산해둔다.
			int valuesyesleft = 0;
			int valuesnoleft = 0;
			int valuesyesright = 0;
			int valuesnoright = 0;
			int tempall = 0;

			if ((tempclassyes.size() == 0 && tempclassno.size() == 0) || signnumber == 3) { // numerical
				int valuesyest = 0;
				int valuesnot = 0;
				int thissign = 0;

				Set<String> key1 = tempclass.keySet();
				Iterator<String> it1 = key1.iterator();

				while (it1.hasNext()) {
					String t = it1.next();

					if (!t.equals(keyss)) {
						thissign = 1;
						BigDecimal tvalue = new BigDecimal(t);
						BigDecimal keyssvalue = new BigDecimal(keyss);

						if (tvalue.compareTo(keyssvalue) == -1) { // keyss보다 작은
																	// 수들
																	// (yes)
							if (signnumber == 3) {
								if (tempclassyes.get(t) != null) {
									valuesyesleft += tempclassyes.get(t); // #
																			// of
																			// yes
								}

								if (tempclassno.get(t) != null) {
									valuesyesright += tempclassno.get(t); // #
																			// of
																			// yes
								}
							} else {
								valuesyesleft += tempclass.get(t); // # of yes
							}
							valuesyest += 1;
						} else { // keyss보다 큰 수들 (no)
							if (signnumber == 3) {
								if (tempclassyes.get(t) != null) {
									valuesnoleft += tempclassyes.get(t); // # of
																			// no
								}

								if (tempclassno.get(t) != null) {
									valuesnoright += tempclassno.get(t); // # of
																			// no
								}
							} else {
								valuesnoleft += tempclass.get(t); // # of no
							}
							valuesnot += 1;
						}
					} else {
						thissign = 0;
					}
				}

				if (thissign == 1 && !(valuesyesleft + valuesnoleft == 0)) {
					if (signnumber == 3) { // numerical data일 때
						tempall = valuesyesleft + valuesnoleft;
						temp = Bigcalculate(valuesyesleft, valuesnoleft, tempall, allnumber);

						if (!(valuesyesright + valuesnoright == 0)) {
							tempall = valuesyesright + valuesnoright;
							BigDecimal tempremain = Bigcalculate(valuesyesright, valuesnoright, tempall, allnumber);
							temp = temp.add(tempremain); // 해당 스트링의 information
															// gain
						}

					} else { // temp27일 때
						int tempallnumber = 0;
						tempall = valuesyesleft + valuesnoleft;

						if (!(valuesyesleft == 1 && valuesnoleft == 1)) {
							temp = Bigcalculate(valuesyesleft, valuesnoleft, tempall, tempallnumber);
						}
					}

					if (valuesyest >= 2 && valuesnot >= 2) {
						if (tempcount1 == 0) { // 첫번째 단계면 일단 best에 부여
							bestnode = keyss;
							bestvalue = temp;
						} else {
							if (temp.compareTo(bestvalue) == 1) { // temp값이
																	// bestvalue보다
																	// 크면
								bestnode = keyss;
								bestvalue = temp;
							}
						}
						tempcount1 += 1;
					}
				}
			}

			else {
				if (tempclassyes.containsKey(keyss)) {
					valuesyesleft = tempclassyes.get(keyss); // # of yes
				}

				if (tempclassno.containsKey(keyss)) {
					valuesnoleft = tempclassno.get(keyss); // # of no
				}

				tempall = tempclass.get(keyss); // 해당 스트링의 총 갯수!

				temp = Bigcalculate(valuesyesleft, valuesnoleft, tempall, allnumber); // 해당
				// 스트링의
				// 엔트로피
				Set<String> key1 = tempclass.keySet(); // 해당 스트링을 제외한 값들의 합을 구하기
														// 위함
				Iterator<String> it1 = key1.iterator();
				int valuesyes1 = 0; // # of yes
				int valuesno1 = 0; // # of no
				int tempall1 = 0; // 나머지 스트링의 총 갯수!
				int endsign = 0;

				while (it1.hasNext()) {
					String keyss1 = it1.next();
					if (!keyss1.equals(keyss)) {
						endsign = 1;
						if (tempclassyes.containsKey(keyss1)) {
							valuesyes1 += tempclassyes.get(keyss1);
						}

						if (tempclassno.containsKey(keyss1)) {
							valuesno1 += tempclassno.get(keyss1);
						}
						tempall1 += tempclass.get(keyss1);
					}
				}

				BigDecimal tempremain = new BigDecimal("0");

				if (endsign == 1) { // 나머지 스트링들이 있을 경우에만 엔트로피 구해줌
					tempremain = Bigcalculate(valuesyes1, valuesno1, tempall1, allnumber);
				}

				temp = temp.add(tempremain); // 해당 스트링의 information gain

				if (tempcount2 == 0) { // 첫번째 단계면 일단 best에 부여
					bestnode = keyss;
					bestvalue = temp;
				} else {
					if (temp.compareTo(bestvalue) == 1) { // temp값이 bestvalue보다
															// 크면
						bestnode = keyss;
						bestvalue = temp;
					}
				}

				tempcount2 += 1;
			}

		}

		return bestvalue + "|" + bestnode;
	}

	public static Node Findbestsplit1(Node tree, HashMap<String, Integer> datasum, int remaincount, String side,
			String remain, String[] dataarray) {
		HashMap<String, Integer> tempclass1 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass2 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass3 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass4 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass5 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass6 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass7 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass8 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass9 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass10 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass11 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass12 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass13 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass14 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass15 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass16 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass17 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass18 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass19 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass20 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass21 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass22 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass23 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass24 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass25 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass26 = new HashMap<String, Integer>(); //
		HashMap<String, Integer> tempclass27 = new HashMap<String, Integer>(); // 이게
																				// 결과값!

		Set<String> keys = datasum.keySet();
		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) {
			String keyss = itr.next();
			String[] arr = keyss.split("\\|");
			int valuess = datasum.get(keyss);
			String[] remains = arr[2].split("kind");
			int remainss = Integer.parseInt(remains[1]);
			remainss -= 1;

			if (arr[2].equals("kind1") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass1.containsKey(keyss)) {
					tempclass1.put(keyss, valuess);
				} else {
					int tempvalue = tempclass1.get(keyss);
					tempclass1.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind2") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass2.containsKey(keyss)) {
					tempclass2.put(keyss, valuess);
				} else {
					int tempvalue = tempclass2.get(keyss);
					tempclass2.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind3") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass3.containsKey(keyss)) {
					tempclass3.put(keyss, valuess);
				} else {
					int tempvalue = tempclass3.get(keyss);
					tempclass3.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind4") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass4.containsKey(keyss)) {
					tempclass4.put(keyss, valuess);
				} else {
					int tempvalue = tempclass4.get(keyss);
					tempclass4.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind5") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass5.containsKey(keyss)) {
					tempclass5.put(keyss, valuess);
				} else {
					int tempvalue = tempclass5.get(keyss);
					tempclass5.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind6") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass6.containsKey(arr[0] + "|" + arr[1])) {
					tempclass6.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass6.get(arr[0] + "|" + arr[1]);
					tempclass6.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind7") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass7.containsKey(arr[0] + "|" + arr[1])) {
					tempclass7.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass7.get(arr[0] + "|" + arr[1]);
					tempclass7.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind8") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass8.containsKey(arr[0] + "|" + arr[1])) {
					tempclass8.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass8.get(arr[0] + "|" + arr[1]);
					tempclass8.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind9") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass9.containsKey(arr[0] + "|" + arr[1])) {
					tempclass9.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass9.get(arr[0] + "|" + arr[1]);
					tempclass9.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind10") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass10.containsKey(arr[0] + "|" + arr[1])) {
					tempclass10.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass10.get(arr[0] + "|" + arr[1]);
					tempclass10.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind11") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass11.containsKey(arr[0] + "|" + arr[1])) {
					tempclass11.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass11.get(arr[0] + "|" + arr[1]);
					tempclass11.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind12") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass12.containsKey(arr[0] + "|" + arr[1])) {
					tempclass12.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass12.get(arr[0] + "|" + arr[1]);
					tempclass12.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind13") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass13.containsKey(arr[0] + "|" + arr[1])) {
					tempclass13.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass13.get(arr[0] + "|" + arr[1]);
					tempclass13.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind14") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass14.containsKey(arr[0] + "|" + arr[1])) {
					tempclass14.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass14.get(arr[0] + "|" + arr[1]);
					tempclass14.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind15") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass15.containsKey(arr[0] + "|" + arr[1])) {
					tempclass15.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass15.get(arr[0] + "|" + arr[1]);
					tempclass15.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind16") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass16.containsKey(arr[0] + "|" + arr[1])) {
					tempclass16.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass16.get(arr[0] + "|" + arr[1]);
					tempclass16.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind17") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass17.containsKey(keyss)) {
					tempclass17.put(keyss, valuess);
				} else {
					int tempvalue = tempclass17.get(keyss);
					tempclass17.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind18") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass18.containsKey(keyss)) {
					tempclass18.put(keyss, valuess);
				} else {
					int tempvalue = tempclass18.get(keyss);
					tempclass18.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind19") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass19.containsKey(arr[0] + "|" + arr[1])) {
					tempclass19.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass19.get(arr[0] + "|" + arr[1]);
					tempclass19.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind20") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass20.containsKey(keyss)) {
					tempclass20.put(keyss, valuess);
				} else {
					int tempvalue = tempclass20.get(keyss);
					tempclass20.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind21") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass21.containsKey(keyss)) {
					tempclass21.put(keyss, valuess);
				} else {
					int tempvalue = tempclass21.get(keyss);
					tempclass21.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind22") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass22.containsKey(keyss)) {
					tempclass22.put(keyss, valuess);
				} else {
					int tempvalue = tempclass22.get(keyss);
					tempclass22.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind23") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass23.containsKey(keyss)) {
					tempclass23.put(keyss, valuess);
				} else {
					int tempvalue = tempclass23.get(keyss);
					tempclass23.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind24") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass24.containsKey(keyss)) {
					tempclass24.put(keyss, valuess);
				} else {
					int tempvalue = tempclass24.get(keyss);
					tempclass24.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind25") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass25.containsKey(keyss)) {
					tempclass25.put(keyss, valuess);
				} else {
					int tempvalue = tempclass25.get(keyss);
					tempclass25.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind26") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass26.containsKey(keyss)) {
					tempclass26.put(keyss, valuess);
				} else {
					int tempvalue = tempclass26.get(keyss);
					tempclass26.replace(keyss, tempvalue + valuess);
				}

			} else if (arr[2].equals("kind27") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass27.containsKey(arr[0] + "|" + arr[2])) {
					tempclass27.put(arr[0] + "|" + arr[2], valuess);
				} else {
					int tempvalue = tempclass27.get(arr[0] + "|" + arr[2]);
					tempclass27.replace(arr[0] + "|" + arr[2], tempvalue + valuess);
				}

			}

		}

		// 순서 정하기!
		HashMap<String, String> newarr = new HashMap<String, String>();
		String[] newarray = new String[remaincount];

		int sum = 0;

		String temp27 = PreFindbestsplit(tempclass27, "");
		String[] arr27 = temp27.split("\\|");
		String resultpredic = arr27[1];
		int tempvalue = 0;

		if (temp27.contains("null")) {
			Set<String> keyss = tempclass27.keySet();
			Iterator<String> itrr = keyss.iterator();

			while (itrr.hasNext()) {
				String key = itrr.next();
				int valuess = tempclass27.get(key);

				tempvalue += valuess;
			}

			Set<String> keyss2 = tempclass27.keySet();
			Iterator<String> itrr2 = keyss2.iterator();
			int count = 0;
			double bestv = 0;
			String bestn = null;

			while (itrr2.hasNext()) {
				String key = itrr2.next();
				String[] arr = key.split("\\|");
				int valuess = tempclass27.get(key);

				if (count == 0) {
					bestv = (double) valuess / tempvalue;
					bestn = arr[0];
				} else {
					if (bestv < (double) valuess / tempvalue) {
						bestv = (double) valuess / tempvalue;
						bestn = arr[0];
					}
				}
				count += 1;
			}


			if (side.equals("root")) {
				tree = new Node(bestn);
			} else if (side.equals("left")) {
				Node children = new Node(bestn);
				tree.setLeft(children);
			} else if (side.equals("right")) {
				Node children = new Node(bestn);
				tree.setRight(children);
			}
		} else {
			if (tempclass1.size() != 0) {
				String temp1 = PreFindbestsplit(tempclass1, resultpredic);
				String[] arr1 = temp1.split("\\|");
				newarray[sum] = arr1[0];
				sum += 1;
				newarr.put(arr1[0], arr1[1] + ",kind1,0");
			}

			if (tempclass2.size() != 0) {
				String temp2 = PreFindbestsplit(tempclass2, resultpredic);
				String[] arr2 = temp2.split("\\|");
				newarray[sum] = arr2[0];
				sum += 1;
				newarr.put(arr2[0], arr2[1] + ",kind2,1");
			}

			if (tempclass3.size() != 0) {
				String temp3 = PreFindbestsplit(tempclass3, resultpredic);
				String[] arr3 = temp3.split("\\|");
				newarray[sum] = arr3[0];
				sum += 1;
				newarr.put(arr3[0], arr3[1] + ",kind3,2");
			}

			if (tempclass4.size() != 0) {
				String temp4 = PreFindbestsplit(tempclass4, resultpredic);
				String[] arr4 = temp4.split("\\|");
				newarray[sum] = arr4[0];
				sum += 1;
				newarr.put(arr4[0], arr4[1] + ",kind4,3");
			}

			if (tempclass5.size() != 0) {
				String temp5 = PreFindbestsplit(tempclass5, resultpredic);
				String[] arr5 = temp5.split("\\|");
				newarray[sum] = arr5[0];
				sum += 1;
				newarr.put(arr5[0], arr5[1] + ",kind5,4");
			}

			if (tempclass6.size() != 0) {
				String temp6 = PreFindbestsplit(tempclass6, resultpredic);
				String[] arr6 = temp6.split("\\|");
				newarray[sum] = arr6[0];
				sum += 1;
				newarr.put(arr6[0], arr6[1] + ",kind6,5");
			}

			if (tempclass7.size() != 0) {
				String temp7 = PreFindbestsplit(tempclass7, resultpredic);
				String[] arr7 = temp7.split("\\|");
				newarray[sum] = arr7[0];
				sum += 1;
				newarr.put(arr7[0], arr7[1] + ",kind7,6");
			}

			if (tempclass8.size() != 0) {
				String temp8 = PreFindbestsplit(tempclass8, resultpredic);
				String[] arr8 = temp8.split("\\|");
				newarray[sum] = arr8[0];
				sum += 1;
				newarr.put(arr8[0], arr8[1] + ",kind8,7");
			}

			if (tempclass9.size() != 0) {
				String temp9 = PreFindbestsplit(tempclass9, resultpredic);
				String[] arr9 = temp9.split("\\|");
				newarray[sum] = arr9[0];
				sum += 1;
				newarr.put(arr9[0], arr9[1] + ",kind9,8");
			}

			if (tempclass10.size() != 0) {
				String temp10 = PreFindbestsplit(tempclass10, resultpredic);
				String[] arr10 = temp10.split("\\|");
				newarray[sum] = arr10[0];
				sum += 1;
				newarr.put(arr10[0], arr10[1] + ",kind10,9");
			}

			if (tempclass11.size() != 0) {
				String temp11 = PreFindbestsplit(tempclass11, resultpredic);
				String[] arr11 = temp11.split("\\|");
				newarray[sum] = arr11[0];
				sum += 1;
				newarr.put(arr11[0], arr11[1] + ",kind11,10");
			}

			if (tempclass12.size() != 0) {
				String temp12 = PreFindbestsplit(tempclass12, resultpredic);
				String[] arr12 = temp12.split("\\|");
				newarray[sum] = arr12[0];
				sum += 1;
				newarr.put(arr12[0], arr12[1] + ",kind12,11");
			}

			if (tempclass13.size() != 0) {
				String temp13 = PreFindbestsplit(tempclass13, resultpredic);
				String[] arr13 = temp13.split("\\|");
				newarray[sum] = arr13[0];
				sum += 1;
				newarr.put(arr13[0], arr13[1] + ",kind13,12");
			}

			if (tempclass14.size() != 0) {
				String temp14 = PreFindbestsplit(tempclass14, resultpredic);
				String[] arr14 = temp14.split("\\|");
				newarray[sum] = arr14[0];
				sum += 1;
				newarr.put(arr14[0], arr14[1] + ",kind14,13");
			}

			if (tempclass15.size() != 0) {
				String temp15 = PreFindbestsplit(tempclass15, resultpredic);
				String[] arr15 = temp15.split("\\|");
				newarray[sum] = arr15[0];
				sum += 1;
				newarr.put(arr15[0], arr15[1] + ",kind15,14");
			}

			if (tempclass16.size() != 0) {
				String temp16 = PreFindbestsplit(tempclass16, resultpredic);
				String[] arr16 = temp16.split("\\|");
				newarray[sum] = arr16[0];
				sum += 1;
				newarr.put(arr16[0], arr16[1] + ",kind16,15");
			}

			if (tempclass17.size() != 0) {
				String temp17 = PreFindbestsplit(tempclass17, resultpredic);
				String[] arr17 = temp17.split("\\|");
				newarray[sum] = arr17[0];
				sum += 1;
				newarr.put(arr17[0], arr17[1] + ",kind17,16");
			}

			if (tempclass18.size() != 0) {
				String temp18 = PreFindbestsplit(tempclass18, resultpredic);
				String[] arr18 = temp18.split("\\|");
				newarray[sum] = arr18[0];
				sum += 1;
				newarr.put(arr18[0], arr18[1] + ",kind18,17");
			}

			if (tempclass19.size() != 0) {
				String temp19 = PreFindbestsplit(tempclass19, resultpredic);
				String[] arr19 = temp19.split("\\|");
				newarray[sum] = arr19[0];
				sum += 1;
				newarr.put(arr19[0], arr19[1] + ",kind19,18");
			}

			if (tempclass20.size() != 0) {
				String temp20 = PreFindbestsplit(tempclass20, resultpredic);
				String[] arr20 = temp20.split("\\|");
				newarray[sum] = arr20[0];
				sum += 1;
				newarr.put(arr20[0], arr20[1] + ",kind20,19");
			}

			if (tempclass21.size() != 0) {
				String temp21 = PreFindbestsplit(tempclass21, resultpredic);
				String[] arr21 = temp21.split("\\|");
				newarray[sum] = arr21[0];
				sum += 1;
				newarr.put(arr21[0], arr21[1] + ",kind21,20");
			}

			if (tempclass22.size() != 0) {
				String temp22 = PreFindbestsplit(tempclass22, resultpredic);
				String[] arr22 = temp22.split("\\|");
				newarray[sum] = arr22[0];
				sum += 1;
				newarr.put(arr22[0], arr22[1] + ",kind22,21");
			}

			if (tempclass23.size() != 0) {
				String temp23 = PreFindbestsplit(tempclass23, resultpredic);
				String[] arr23 = temp23.split("\\|");
				newarray[sum] = arr23[0];
				sum += 1;
				newarr.put(arr23[0], arr23[1] + ",kind23,22");
			}

			if (tempclass24.size() != 0) {
				String temp24 = PreFindbestsplit(tempclass24, resultpredic);
				String[] arr24 = temp24.split("\\|");
				newarray[sum] = arr24[0];
				sum += 1;
				newarr.put(arr24[0], arr24[1] + ",kind24,23");
			}

			if (tempclass25.size() != 0) {
				String temp25 = PreFindbestsplit(tempclass25, resultpredic);
				String[] arr25 = temp25.split("\\|");
				newarray[sum] = arr25[0];
				sum += 1;
				newarr.put(arr25[0], arr25[1] + ",kind25,24");
			}

			if (tempclass26.size() != 0) {
				String temp26 = PreFindbestsplit(tempclass26, resultpredic);
				String[] arr26 = temp26.split("\\|");
				newarray[sum] = arr26[0];
				sum += 1;
				newarr.put(arr26[0], arr26[1] + ",kind26,25");
			}

			Arrays.sort(newarray); // 큰 순서대로 배열하기!

			int check = 0;

			for (int i = 0; i < newarray.length; i++) {
				if (!newarray[i].equals("0")) {
					check = 1;
				}
			}
			String choosing = "";

			choosing = newarr.get(newarray[0]);

			if (check == 1) {
				tree = Findbestsplit2(tree, dataarray, choosing, side, remain, resultpredic);
			} else {
				Set<String> keyss = tempclass27.keySet();
				Iterator<String> itrr = keyss.iterator();

				while (itrr.hasNext()) {
					String key = itrr.next();
					int valuess = tempclass27.get(key);

					tempvalue += valuess;
				}

				Set<String> keyss2 = tempclass27.keySet();
				Iterator<String> itrr2 = keyss2.iterator();
				String bestnode = null;
				int count = 0;
				double bestv = 0.0;

				while (itrr2.hasNext()) {
					String key = itrr2.next();
					int valuess = tempclass27.get(key);

					String[] arr = key.split("\\|");

					if (count == 0) {
						bestv = (double) valuess / tempvalue;
						bestnode = arr[0];
					} else {
						if (bestv < (double) valuess / tempvalue) {
							bestv = (double) valuess / tempvalue;
							bestnode = arr[0];
						}
					}

					count += 1;
				}

				if (side.equals("root")) {
					tree = new Node(bestnode);
				} else if (side.equals("left")) {
					Node children = new Node(bestnode);
					tree.setLeft(children);
					tree = children;
				} else if (side.equals("right")) {
					Node children = new Node(bestnode);
					tree.setRight(children);
					tree = children;
				}
			}
		}

		return tree;
	}

	public static Node Findbestsplit2(Node tree, String[] data, String choosing, String side, String remain,
			String resultpredic) {
		String[] choose = choosing.split(",");
		String bestnode = choose[0];
		String Attribute = choose[1];
		remain += "'" + choose[2] + "'" + "|";

		int resultleft = 0;
		int resultright = 0;

		String[] remains = remain.split("\\|");

		HashMap<String, Integer> outclassleft = new HashMap<String, Integer>();
		HashMap<String, Integer> outclassright = new HashMap<String, Integer>();
		HashMap<String, Integer> resultyesleft = new HashMap<String, Integer>();
		HashMap<String, Integer> resultnoleft = new HashMap<String, Integer>();
		HashMap<String, Integer> resultyesright = new HashMap<String, Integer>();
		HashMap<String, Integer> resultnoright = new HashMap<String, Integer>();
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		String[] dataleft = new String[data.length];
		int lefttemp = 0;
		String[] dataright = new String[data.length];
		int righttemp = 0;

		if (side.equals("root")) {
			tree = new Node(bestnode + "," + Attribute);
		} else if (side.equals("left")) {
			Node children = new Node(bestnode + "," + Attribute);
			tree.setLeft(children);
			tree = children;
		} else if (side.equals("right")) {
			Node children = new Node(bestnode + "," + Attribute);
			tree.setRight(children);
			tree = children;
		}

		if (Attribute.equals("kind1") || Attribute.equals("kind2") || Attribute.equals("kind3")
				|| Attribute.equals("kind4") || Attribute.equals("kind5") || Attribute.equals("kind17")
				|| Attribute.equals("kind18") || Attribute.equals("kind20") || Attribute.equals("kind21")
				|| Attribute.equals("kind22") || Attribute.equals("kind23") || Attribute.equals("kind24")
				|| Attribute.equals("kind25") || Attribute.equals("kind26") || Attribute.equals("kind27")) { // numerical

			BigDecimal numericnode = new BigDecimal(bestnode);

			for (int i = 0; i < data.length; i++) { // 들어온 데이터의 길이에 따라!
				if (data[i] != null) {
					String[] arr = data[i].split("\\|");
					String[] indexs = Attribute.split("kind");
					int index = Integer.parseInt(indexs[1]);
					String whatnode = arr[index - 1];
					BigDecimal nodevalue = new BigDecimal(whatnode);

					// 결과값을 따로 저장한다. (leaf node 판별을 위해)
					if (nodevalue.compareTo(numericnode) == -1) { // yes쪽 데이터가 될
																	// 것들
						if (Integer.parseInt(arr[arr.length - 1]) < Integer.parseInt(resultpredic)) { // 결과값
																										// bestnode보다
																										// 작은
																										// 값을
							if (!resultyesleft.containsKey(arr[arr.length - 1])) {
								resultyesleft.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultyesleft.get(arr[arr.length - 1]);
								resultyesleft.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultleft += 1;
						} else {
							if (!resultnoleft.containsKey(arr[arr.length - 1])) {
								resultnoleft.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultnoleft.get(arr[arr.length - 1]);
								resultnoleft.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultleft += 1;
						}

						dataleft[lefttemp] = data[i];
						lefttemp += 1;
					} else { // no쪽 데이터가 될 것들
						if (Integer.parseInt(arr[arr.length - 1]) < Integer.parseInt(resultpredic)) { // yes
							if (!resultyesright.containsKey(arr[arr.length - 1])) {
								resultyesright.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultyesright.get(arr[arr.length - 1]);
								resultyesright.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultright += 1;
						} else {
							if (!resultnoright.containsKey(arr[arr.length - 1])) {
								resultnoright.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultnoright.get(arr[arr.length - 1]);
								resultnoright.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultright += 1;
						}

						dataright[righttemp] = data[i];
						righttemp += 1;
					}

					for (int j = 0; j < 27; j++) {
						if (!remain.contains("'" + Integer.toString(j) + "'")) {
							String classification = arr[j] + "|" + arr[26] + "|kind" + Integer.toString(j + 1);

							if (nodevalue.compareTo(numericnode) == -1) { // yes
								if (!outclassleft.containsKey(classification)) {
									outclassleft.put(classification, 1);
								} else {
									int tempvalue = outclassleft.get(classification);
									outclassleft.replace(classification, tempvalue + 1);
								}
							} else { // no
								if (!outclassright.containsKey(classification)) {
									outclassright.put(classification, 1);
								} else {
									int tempvalue = outclassright.get(classification);
									outclassright.replace(classification, tempvalue + 1);
								}
							}
						}
					}

				} else {
					break;
				}
			}

		} else { // categorical

			for (int i = 0; i < data.length; i++) { // 들어온 데이터의 길이에 따라!
				if (data[i] != null) {
					String[] arr = data[i].split("\\|");
					String[] indexs = Attribute.split("kind");
					int index = Integer.parseInt(indexs[1]);
					String whatnode = arr[index - 1];

					// 결과값을 따로 저장한다. (leaf node 판별을 위해)
					if (whatnode.equals(bestnode)) { // yes쪽 데이터가 될 것들
						if (Integer.parseInt(arr[arr.length - 1]) < Integer.parseInt(resultpredic)) { // 결과값
																										// bestnode보다
																										// 작은
																										// 값을
							if (!resultyesleft.containsKey(arr[arr.length - 1])) {
								resultyesleft.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultyesleft.get(arr[arr.length - 1]);
								resultyesleft.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultleft += 1;
						} else {
							if (!resultnoleft.containsKey(arr[arr.length - 1])) {
								resultnoleft.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultnoleft.get(arr[arr.length - 1]);
								resultnoleft.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultleft += 1;
						}

						dataleft[lefttemp] = data[i];
						lefttemp += 1;
					} else { // no쪽 데이터가 될 것들
						if (Integer.parseInt(arr[arr.length - 1]) < Integer.parseInt(resultpredic)) { // yes
							if (!resultyesright.containsKey(arr[arr.length - 1])) {
								resultyesright.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultyesright.get(arr[arr.length - 1]);
								resultyesright.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultright += 1;
						} else {
							if (!resultnoright.containsKey(arr[arr.length - 1])) {
								resultnoright.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = resultnoright.get(arr[arr.length - 1]);
								resultnoright.replace(arr[arr.length - 1], tempvalue + 1);
							}

							if (!result.containsKey(arr[arr.length - 1])) {
								result.put(arr[arr.length - 1], 1);
							} else {
								int tempvalue = result.get(arr[arr.length - 1]);
								result.replace(arr[arr.length - 1], tempvalue + 1);
							}
							resultright += 1;
						}

						dataright[righttemp] = data[i];
						righttemp += 1;
					}

					for (int j = 0; j < 27; j++) {
						if (!remain.contains("'" + Integer.toString(j) + "'")) {
							String classification = arr[j] + "|" + arr[26] + "|kind" + Integer.toString(j + 1);
							if (whatnode.equals(bestnode)) { // yes
								if (!outclassleft.containsKey(classification)) {
									outclassleft.put(classification, 1);
								} else {
									int tempvalue = outclassleft.get(classification);
									outclassleft.replace(classification, tempvalue + 1);
								}
							} else { // no
								if (!outclassright.containsKey(classification)) {
									outclassright.put(classification, 1);
								} else {
									int tempvalue = outclassright.get(classification);
									outclassright.replace(classification, tempvalue + 1);
								}
							}
						}
					}

				} else {
					break;
				}
			}
		}

		// leaf node 여뷰를 확인한다.

		int remaincount = 26 - remains.length;

		// leaf node 여부 검사

		int leftsign = 0;
		int rightsign = 0;

		Set<String> keys1 = resultyesleft.keySet();
		Iterator<String> itr1 = keys1.iterator();

		while (itr1.hasNext()) {
			String keyss = itr1.next();
			int valuess = resultyesleft.get(keyss);

			if ((double) valuess / resultleft > 0.8) {
				Node leaf = new Node(keyss);
				tree.setLeft(leaf);
				leftsign = 1;
				break;
			}
		}

		Set<String> keys2 = resultnoleft.keySet();
		Iterator<String> itr2 = keys2.iterator();

		while (itr2.hasNext()) {
			String keyss = itr2.next();
			int valuess = resultnoleft.get(keyss);

			if ((double) valuess / resultleft > 0.8) {
				Node leaf = new Node(keyss);
				tree.setLeft(leaf);
				leftsign = 1;
				break;
			}
		}

		Set<String> keys3 = resultyesright.keySet();
		Iterator<String> itr3 = keys3.iterator();

		while (itr3.hasNext()) {
			String keyss = itr3.next();
			int valuess = resultyesright.get(keyss);

			if ((double) valuess / resultright > 0.8) {
				Node leaf = new Node(keyss);
				tree.setRight(leaf);
				rightsign = 1;
				break;
			}
		}

		Set<String> keys4 = resultnoright.keySet();
		Iterator<String> itr4 = keys4.iterator();

		while (itr4.hasNext()) {
			String keyss = itr4.next();
			int valuess = resultnoright.get(keyss);

			if ((double) valuess / resultright > 0.8) {
				Node leaf = new Node(keyss);
				tree.setRight(leaf);
				rightsign = 1;
				break;
			}
		}

		if (outclassleft.size() == 0) {
			leftsign = 1;
			int temp = resultleft + resultright;

			Set<String> keys = result.keySet();
			Iterator<String> itr = keys.iterator();
			int count = 0;
			double bestv = 0.0;
			String bestn = null;

			while (itr.hasNext()) {
				String key = itr.next();
				int valuess = result.get(key);

				if (count == 0) {
					bestv = (double) valuess / temp;
					bestn = key;
				} else {
					if (bestv < (double) valuess / temp) {
						bestv = (double) valuess / temp;
						bestn = key;
					}
				}

				count += 1;
			}

			Node leaf = new Node(bestn);
			tree.setLeft(leaf);
		}

		if (outclassright.size() == 0) {
			rightsign = 1;
			int temp = resultleft + resultright;

			Set<String> keys = result.keySet();
			Iterator<String> itr = keys.iterator();
			int count = 0;
			double bestv = 0.0;
			String bestn = null;

			while (itr.hasNext()) {
				String key = itr.next();
				int valuess = result.get(key);

				if (count == 0) {
					bestv = (double) valuess / temp;
					bestn = key;
				} else {
					if (bestv < (double) valuess / temp) {
						bestv = (double) valuess / temp;
						bestn = key;
					}
				}

				count += 1;
			}

			Node leaf = new Node(bestn);
			tree.setRight(leaf);
		}

		if (leftsign == 0 || rightsign == 0) {
			if (leftsign == 0 && rightsign == 1) {
				Findbestsplit1(tree, outclassleft, remaincount, "left", remain, dataleft);
			} else if (leftsign == 0 && rightsign == 0) {
				Findbestsplit1(tree, outclassleft, remaincount, "left", remain, dataleft);
				Findbestsplit1(tree, outclassright, remaincount, "right", remain, dataright);
			} else if (leftsign == 1 && rightsign == 0) {
				Findbestsplit1(tree, outclassright, remaincount, "right", remain, dataright);
			}
		}

		return tree;
	}

	public static BigDecimal Bigcalculate(int yes, int no, int all, int allnumber) {
		BigDecimal bigvalueyes = new BigDecimal(yes); //
		BigDecimal bigvalueno = new BigDecimal(no);
		BigDecimal bigtempall = new BigDecimal(all);
		BigDecimal bigallno = new BigDecimal(allnumber);
		BigDecimal bigallno2 = new BigDecimal("0");
		BigDecimal minusform = new BigDecimal("-1");
		BigDecimal logvalueall = new BigDecimal(Math.log(all));

		BigDecimal logvalueyes;
		BigDecimal logvalueno;

		if (yes != 0) {
			logvalueyes = new BigDecimal(Math.log(yes));
		} else {
			logvalueyes = new BigDecimal("0");
		}

		if (no != 0) {
			logvalueno = new BigDecimal(Math.log(no));
		} else {
			logvalueno = new BigDecimal("0");
		}

		BigDecimal lastcal;

		BigDecimal caltemp2 = minusform.multiply(bigvalueyes.divide(bigtempall, 3, BigDecimal.ROUND_CEILING))
				.multiply(logvalueyes.subtract(logvalueall));
		BigDecimal caltemp3 = minusform.multiply(bigvalueno.divide(bigtempall, 3, BigDecimal.ROUND_CEILING))
				.multiply(logvalueno.subtract(logvalueall));
		if (bigallno.compareTo(bigallno2) != 0) {
			BigDecimal caltemp1 = minusform.multiply(bigtempall.divide(bigallno, 3, BigDecimal.ROUND_CEILING));
			lastcal = caltemp1.multiply(caltemp2.add(caltemp3));
		} else {
			lastcal = minusform.multiply(caltemp2.add(caltemp3));
		}

		return lastcal;
	}

	public static int testing(Node learningtree, String[] testarray) {
		int hit = 0;

		for (int i = 0; i < testarray.length; i++) {
			String[] arr = testarray[i].split("\\|");
			int hits = treesearching(learningtree, arr);

			if (hits > 0) {
				hit += 1;
			}
		}

		return hit;
	}

	public static int treesearching(Node learningtree, String[] testarray) {
		int answer = 0;
		String numerical = "'1''2''3''4''5''17''18''20''21''22''23''24''25''26''27'";
		int index = 0;
		int sign = 0;

		String bestnode = learningtree.getData();
		BigDecimal bestvalue = new BigDecimal("0");
		String bestvalues = null;

		if (bestnode.contains(",")) {
			String[] bestarr = bestnode.split(",");
			bestvalues = bestarr[0];
			String[] indexes = bestarr[1].split("kind");
			index = Integer.parseInt(indexes[1]) - 1;

			if (numerical.contains("'" + indexes[1] + "'")) {
				bestvalue = new BigDecimal(bestarr[0]);
				sign = 1;
			} else {
				sign = 2;
			}
		} else {
			sign = 3;
		}

		for (int i = 0; i < testarray.length; i++) {
			if (i == index && sign == 1) { // numerical bestnode
				BigDecimal testarrayvalue = new BigDecimal(testarray[i]);
				if (testarrayvalue.compareTo(bestvalue) == -1) { //왼쪽 노드로 이동해야 됨
					learningtree = learningtree.getLeft();
				} else { //오른쪽 노드로 이동해야됨
					learningtree = learningtree.getRight();
				}
				answer = treesearching(learningtree, testarray);
			} else if (i == index && sign == 2) { // categorical bestnode
				if (testarray[i].equals(bestvalues)) { //왼쪽 노드로 이동해야 됨
					learningtree = learningtree.getLeft();
				} else { //오른쪽 노드로 이동해야됨
					learningtree = learningtree.getRight();
				}
				answer = treesearching(learningtree, testarray);
			} else if (i == testarray.length - 1 && sign == 3) {
				BigDecimal testarrayvalue = new BigDecimal(testarray[i]);
				BigDecimal bestnodevalue = new BigDecimal(bestnode);
				if (testarrayvalue.compareTo(bestnodevalue) == 0) {
					answer = 1;
				}
			}
		}

		return answer;
	}
}
