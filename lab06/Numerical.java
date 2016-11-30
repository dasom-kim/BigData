package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Numerical {
	static Node tree;

	public static void main(String[] args) throws IOException {
		String s;
		int count = 0; // 전체 데이터의 갯수
		String[] dataarray = new String[100];
		HashMap<String, Integer> datasum = new HashMap<String, Integer>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("C://Users/Poweruser/Downloads/train_rev2.txt"));
			while ((s = br.readLine()) != null) {
				String[] arr = s.split(","); // ',' is delimiter

				dataarray[count] = "";

				for (int i = 0; i < arr.length; i++) {

					dataarray[count] += arr[i] + "|";

				}

				for (int i = 0; i < arr.length - 1; i++) {
					String classout;

					classout = arr[i] +"|"+ arr[15] +"|kind" + Integer.toString(i);  

					if (!datasum.containsKey(classout)) {
						datasum.put(classout, 1);
					} else {
						int tempvalue = datasum.get(classout);
						datasum.replace(classout, tempvalue + 1);
					}
				}

				count += 1;

			}

			tree = Findbestsplit1(tree, datasum, 15, "root", "", dataarray);

			br.close();
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String PreFindbestsplit(HashMap<String, Integer> data) {
		HashMap<String, Integer> tempclassyes = new HashMap<String, Integer>(); // yes
		HashMap<String, Integer> tempclassno = new HashMap<String, Integer>(); // no
		HashMap<String, Integer> tempclass = new HashMap<String, Integer>();
		int tempall = 0;

		Set<String> keys = data.keySet(); // 들어온 데이터셋을 정리한다! <Sunny|Yes, 2.0>

		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) {
			String keyss = itr.next();

			if (keyss != null) {
				String[] arr = keyss.split("\\|"); // ',' is delimiter.

				int valuess = data.get(keyss); // # of yes or no

				if (arr[1].equals("yes")) {
					tempclassyes.put(arr[0], valuess);
				} else if (arr[1].equals("no")) { // no
					tempclassno.put(arr[0], valuess);
				}

				if (!tempclass.containsKey(arr[0])) {
					tempclass.put(arr[0], valuess);
				} else {
					int tempvalue = tempclass.get(arr[0]);
					tempclass.replace(arr[0], tempvalue + valuess);
				}
			}
		}

		BigDecimal bestvalue = new BigDecimal("0");
		String bestnode = null;
		int tempcount = 0;

		Set<String> key = tempclass.keySet(); // 들어온 데이터셋을 정리한다! <Sunny|Yes,
												// 2.0> 이런 형태이므로.
		Iterator<String> it = key.iterator();

		while (it.hasNext()) {
			String keyss = it.next(); // 첫번째 스트링부터 먼저 계산해둔다.

			int valuesyes = 0;
			int valuesno = 0;

			if (tempclassyes.containsKey(keyss)) {
				valuesyes = tempclassyes.get(keyss); // # of yes
			}

			if (tempclassno.containsKey(keyss)) {
				valuesno = tempclassno.get(keyss); // # of no
			}

			tempall = tempclass.get(keyss); // 해당 스트링의 총 갯수!

			BigDecimal temp = Bigcalculate(valuesyes, valuesno, tempall, data.size()); // 해당
																						// 스트링의
																						// 엔트로피

			Set<String> key1 = tempclass.keySet(); // 해당 스트링을 제외한 값들의 합을 구하기 위함
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
				tempremain = Bigcalculate(valuesyes1, valuesno1, tempall1, data.size()); // 나머지
																							// 스트링의
																							// 엔트로피
																							// //
																							// 엔트로피
			}

			temp = temp.add(tempremain); // 해당 스트링의 information gain

			if (tempcount == 0) { // 첫번째 단계면 일단 best에 부여
				bestnode = keyss;
				bestvalue = temp;
			} else {
				if (temp.compareTo(bestvalue) == 1) { // temp값이 bestvalue보다 크면
					bestnode = keyss;
					bestvalue = temp;
				}
			}

			tempcount += 1;

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

		Set<String> keys = datasum.keySet();
		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) {
			String keyss = itr.next();

			String[] arr = keyss.split("\\|"); // ',' is delimiter.
			int valuess = datasum.get(keyss); // # of yes or no

			if (arr[2].contains("kind1")) {
				if (!tempclass1.containsKey(arr[0] + "|" + arr[1])) {
					tempclass1.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass1.get(arr[0] + "|" + arr[1]);
					tempclass1.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].contains("kind2")) {
				if (!tempclass2.containsKey(arr[0] + "|" + arr[1])) {
					tempclass2.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass2.get(arr[0] + "|" + arr[1]);
					tempclass2.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].contains("kind3")) {
				if (!tempclass3.containsKey(arr[0] + "|" + arr[1])) {
					tempclass3.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass3.get(arr[0] + "|" + arr[1]);
					tempclass3.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].contains("kind4")) {
				if (!tempclass4.containsKey(arr[0] + "|" + arr[1])) {
					tempclass4.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass4.get(arr[0] + "|" + arr[1]);
					tempclass4.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind5")) {
				if (!tempclass5.containsKey(arr[0] + "|" + arr[1])) {
					tempclass5.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass5.get(arr[0] + "|" + arr[1]);
					tempclass5.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind6")) {
				if (!tempclass6.containsKey(arr[0] + "|" + arr[1])) {
					tempclass6.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass6.get(arr[0] + "|" + arr[1]);
					tempclass6.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind7")) {
				if (!tempclass7.containsKey(arr[0] + "|" + arr[1])) {
					tempclass7.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass7.get(arr[0] + "|" + arr[1]);
					tempclass7.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind8")) {
				if (!tempclass8.containsKey(arr[0] + "|" + arr[1])) {
					tempclass8.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass8.get(arr[0] + "|" + arr[1]);
					tempclass8.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind9")) {
				if (!tempclass9.containsKey(arr[0] + "|" + arr[1])) {
					tempclass9.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass9.get(arr[0] + "|" + arr[1]);
					tempclass9.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind10")) {
				if (!tempclass10.containsKey(arr[0] + "|" + arr[1])) {
					tempclass10.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass10.get(arr[0] + "|" + arr[1]);
					tempclass10.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind11")) {
				if (!tempclass11.containsKey(arr[0] + "|" + arr[1])) {
					tempclass11.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass11.get(arr[0] + "|" + arr[1]);
					tempclass11.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind12")) {
				if (!tempclass12.containsKey(arr[0] + "|" + arr[1])) {
					tempclass12.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass12.get(arr[0] + "|" + arr[1]);
					tempclass12.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind13")) {
				if (!tempclass13.containsKey(arr[0] + "|" + arr[1])) {
					tempclass13.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass13.get(arr[0] + "|" + arr[1]);
					tempclass13.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind14")) {
				if (!tempclass14.containsKey(arr[0] + "|" + arr[1])) {
					tempclass14.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass14.get(arr[0] + "|" + arr[1]);
					tempclass14.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			} else if (arr[2].contains("kind15")) {
				if (!tempclass15.containsKey(arr[0] + "|" + arr[1])) {
					tempclass15.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass15.get(arr[0] + "|" + arr[1]);
					tempclass15.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}
			}

		}

		// 순서 정하기!
		HashMap<String, String> newarr = new HashMap<String, String>();
		String[] newarray = new String[remaincount];

		int sum = 0;

		if (tempclass1.size() != 0) {
			String temp1 = PreFindbestsplit(tempclass1);
			String[] arr1 = temp1.split("\\|");
			newarray[sum] = arr1[0];
			sum += 1;
			newarr.put(arr1[0], arr1[1] + ",outlook,0");
		}

		if (tempclass2.size() != 0) {
			String temp2 = PreFindbestsplit(tempclass2);
			String[] arr2 = temp2.split("\\|");
			newarray[sum] = arr2[0];
			sum += 1;
			newarr.put(arr2[0], arr2[1] + ",temperature,1");
		}

		if (tempclass3.size() != 0) {
			String temp3 = PreFindbestsplit(tempclass3);
			String[] arr3 = temp3.split("\\|");
			newarray[sum] = arr3[0];
			sum += 1;
			newarr.put(arr3[0], arr3[1] + ",humidity,2");
		}

		if (tempclass4.size() != 0) {
			String temp4 = PreFindbestsplit(tempclass4);
			String[] arr4 = temp4.split("\\|");
			newarray[sum] = arr4[0];
			sum += 1;
			newarr.put(arr4[0], arr4[1] + ",wind,3");
		}

		Arrays.sort(newarray); // 큰 순서대로 배열하기!

		String choosing = "";

		choosing = newarr.get(newarray[0]);

		tree = Findbestsplit2(tree, dataarray, choosing, side, remain);

		return tree;
	}

	public static Node Findbestsplit2(Node tree, String[] data, String choosing, String side, String remain) {
		String[] choose = choosing.split(",");
		String bestnode = choose[0];
		String Attribute = choose[1];
		remain += choose[2] + "|";

		String[] remains = remain.split("\\|");

		HashMap<String, Integer> outclassleft = new HashMap<String, Integer>();
		HashMap<String, Integer> outclassright = new HashMap<String, Integer>();

		int tempyesleft = 0;
		int tempnoleft = 0;
		int tempyesright = 0;
		int tempnoright = 0;

		String[] dataleft = new String[data.length];
		int lefttemp = 0;
		String[] dataright = new String[data.length];
		int righttemp = 0;

		System.out.println(side);

		String[] att = { "outlook", "temperature", "humidity", "wind" };

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

		if (Attribute.equals("temperature") || Attribute.equals("humidity")) { // numerical
																				// data
			int numericnode = Integer.parseInt(bestnode);

			for (int i = 0; i < data.length; i++) {
				if (data[i] != null) {
					String[] information = data[i].split("\\|");
					String temperature = information[1];
					String humidity = information[2];
					String classname = information[4];

					if (Attribute.equals("temperature")) {
						if (Integer.parseInt(temperature) < numericnode) { // 왼쪽(yes)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassleft.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassleft.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassleft
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassleft.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataleft[lefttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							lefttemp += 1;
							if (classname.equals("yes")) {
								tempyesleft += 1;
							} else {
								tempnoleft += 1;
							}
						} else { // 오른쪽(no)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassright.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassright.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassright
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassright.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataright[righttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							righttemp += 1;
							if (classname.equals("yes")) {
								tempyesright += 1;
							} else {
								tempnoright += 1;
							}
						}
					} else {
						if (Integer.parseInt(humidity) < numericnode) { // 왼쪽(yes)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassleft.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassleft.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassleft
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassleft.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataleft[lefttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							lefttemp += 1;
							if (classname.equals("yes")) {
								tempyesleft += 1;
							} else {
								tempnoleft += 1;
							}
						} else { // 오른쪽(no)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassright.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassright.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassright
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassright.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataright[righttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							righttemp += 1;
							if (classname.equals("yes")) {
								tempyesright += 1;
							} else {
								tempnoright += 1;
							}
						}

					}
				}
			}

		} else { // categorical data

			for (int i = 0; i < data.length; i++) {
				if (data[i] != null) {
					String[] information = data[i].split("\\|");
					String outlook = information[0];
					String wind = information[3];
					String classname = information[4];

					if (Attribute.equals("outlook")) {
						if (outlook.equals(bestnode)) { // 왼쪽(yes)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassleft.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassleft.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassleft
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassleft.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataleft[lefttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							lefttemp += 1;
							if (classname.equals("yes")) {
								tempyesleft += 1;
							} else {
								tempnoleft += 1;
							}
						} else { // 오른쪽(no)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassright.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassright.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassright
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassright.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataright[righttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							righttemp += 1;
							if (classname.equals("yes")) {
								tempyesright += 1;
							} else {
								tempnoright += 1;
							}
						}
					} else {
						if (wind.equals(bestnode)) { // 왼쪽(yes)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassleft.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassleft.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassleft
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassleft.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataleft[lefttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							lefttemp += 1;
							if (classname.equals("yes")) {
								tempyesleft += 1;
							} else {
								tempnoleft += 1;
							}
						} else { // 오른쪽(no)
							for (int j = 0; j < information.length; j++) {
								if (!remain.contains(Integer.toString(j)) && j != 4) {
									if (!outclassright.containsKey(information[j] + "|" + classname + "|" + att[j])) {
										outclassright.put(information[j] + "|" + classname + "|" + att[j], 1);
									} else {
										int tempvalue = outclassright
												.get(information[j] + "|" + classname + "|" + att[j]);
										outclassright.replace(information[j] + "|" + classname + "|" + att[j],
												tempvalue + 1);
									}
								}
							}

							dataright[righttemp] = information[0] + "|" + information[1] + "|" + information[2] + "|"
									+ information[3] + "|" + information[4];
							righttemp += 1;
							if (classname.equals("yes")) {
								tempyesright += 1;
							} else {
								tempnoright += 1;
							}
						}

					}
				}
			}

		}

		// leaf node 여뷰를 확인한다.

		int remaincount = 4 - remains.length;

		if ((double) tempyesleft / lefttemp >= 0.66 || (double) tempnoleft / lefttemp >= 0.66) {
			if (righttemp == 0) {
				if ((double) tempyesleft / lefttemp >= 0.66) {
					Node leaf = new Node("yes");
					tree.setLeft(leaf);
				} else {
					Node leaf = new Node("no");
					tree.setLeft(leaf);
				}
			} else if ((double) tempyesleft / lefttemp >= 0.66 && (double) tempyesright / righttemp < 0.66
					&& (double) tempnoright / righttemp < 0.66) { // left만

				Node leaf = new Node("yes");
				tree.setLeft(leaf);

				Findbestsplit1(tree, outclassright, remaincount, "right", remain, dataright);
			} else if ((double) tempnoleft / lefttemp >= 0.66 && (double) tempyesright / righttemp < 0.66
					&& (double) tempnoright / righttemp < 0.66) { // left만
				Node leaf = new Node("no");
				tree.setLeft(leaf);

				Findbestsplit1(tree, outclassright, remaincount, "right", remain, dataright);
			} else if ((double) tempyesleft / lefttemp >= 0.66 && (double) tempyesright / righttemp >= 0.66) {
				Node leaf = new Node("yes");
				tree.setLeft(leaf);
				Node leaf2 = new Node("no");
				tree.setRight(leaf2);

			} else if ((double) tempyesleft / lefttemp >= 0.66 && (double) tempnoright / righttemp >= 0.66) {
				Node leaf = new Node("yes");
				tree.setLeft(leaf);
				Node leaf2 = new Node("no");
				tree.setRight(leaf2);

			} else if ((double) tempnoleft / lefttemp >= 0.66 && (double) tempyesright / righttemp >= 0.66) {
				Node leaf = new Node("no");
				tree.setLeft(leaf);
				Node leaf2 = new Node("yes");
				tree.setRight(leaf2);
			} else if ((double) tempnoleft / lefttemp >= 0.66 && (double) tempnoright / righttemp >= 0.66) {
				Node leaf = new Node("no");
				tree.setLeft(leaf);
				Node leaf2 = new Node("no");
				tree.setRight(leaf2);
			}
		} else if ((double) tempyesright / righttemp >= 0.66 || (double) tempnoright / righttemp >= 0.66) {
			if (lefttemp == 0) {
				if ((double) tempyesright / righttemp >= 0.66) {
					Node leaf = new Node("yes");
					tree.setRight(leaf);
				} else {
					Node leaf = new Node("no");
					tree.setRight(leaf);
				}
			} else if ((double) tempyesright / righttemp >= 0.66) {
				Node leaf = new Node("yes");
				tree.setRight(leaf);
			} else {
				Node leaf = new Node("no");
				tree.setRight(leaf);
			}

			Findbestsplit1(tree, outclassleft, remaincount, "left", remain, dataleft);
		} else { // 둘 다 치우치지 않았다
			Findbestsplit1(tree, outclassleft, remaincount, "left", remain, dataleft);
			Findbestsplit1(tree, outclassright, remaincount, "right", remain, dataright);
		}

		return tree;
	}

	public static BigDecimal Bigcalculate(int yes, int no, int all, int allnumber) {
		BigDecimal bigvalueyes = new BigDecimal(yes); //
		BigDecimal bigvalueno = new BigDecimal(no);
		BigDecimal bigtempall = new BigDecimal(all);
		BigDecimal bigallno = new BigDecimal(allnumber);
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

		BigDecimal caltemp1 = minusform.multiply(bigtempall.divide(bigallno, 3, BigDecimal.ROUND_CEILING));
		BigDecimal caltemp2 = minusform.multiply(bigvalueyes.divide(bigtempall, 3, BigDecimal.ROUND_CEILING))
				.multiply(logvalueyes.subtract(logvalueall));
		BigDecimal caltemp3 = minusform.multiply(bigvalueno.divide(bigtempall, 3, BigDecimal.ROUND_CEILING))
				.multiply(logvalueno.subtract(logvalueall));
		BigDecimal lastcal = caltemp1.multiply(caltemp2.add(caltemp3));

		return lastcal;
	}

}
