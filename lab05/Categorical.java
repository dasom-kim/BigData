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

public class Categorical {
	static Node tree1;
	static Node tree2;
	static Node tree3;

	public static void main(String[] args) throws IOException {
		String s;
		int count1 = 0; // 전체 데이터의 갯수
		int count2 = 0; // 전체 데이터의 갯수
		int count3 = 0; // 전체 데이터의 갯수
		int countt1 = 0; // 전체 데이터의 갯수
		int countt2 = 0; // 전체 데이터의 갯수
		int countt3 = 0; // 전체 데이터의 갯수
		String[] dataarray1 = new String[8];
		String[] dataarray2 = new String[8];
		String[] dataarray3 = new String[8];
		String[] testarray1 = new String[4];
		String[] testarray2 = new String[4];
		String[] testarray3 = new String[4];
		HashMap<String, Integer> datasum1 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum2 = new HashMap<String, Integer>();
		HashMap<String, Integer> datasum3 = new HashMap<String, Integer>();

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("C://Users/Poweruser/Downloads/play-tennis_train.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C://Users/Poweruser/Downloads/out2.txt"));
			int scount = 0;
			while ((s = br.readLine()) != null) {
				if (!s.contains("@") && !(s.equals(""))) {

					String[] arr = s.split(","); // ',' is delimiter

					if (!(0 <= scount && scount <= 3)) {
						dataarray1[count1] = "";

						for (int i = 0; i < arr.length; i++) {

							dataarray1[count1] += arr[i] + "|";

						}

						count1 += 1;

						for (int i = 0; i < arr.length - 1; i++) {
							String classout;

							classout = arr[i] + "|" + arr[4] + "|kind" + Integer.toString(i + 1);

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

					if (!(4 <= scount && scount <= 7)) {

						dataarray2[count2] = "";

						for (int i = 0; i < arr.length; i++) {

							dataarray2[count2] += arr[i] + "|";

						}

						count2 += 1;

						for (int i = 0; i < arr.length - 1; i++) {
							String classout;

							classout = arr[i] + "|" + arr[4] + "|kind" + Integer.toString(i + 1);

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

					if (!(8 <= scount && scount <= 11)) {

						dataarray3[count3] = "";

						for (int i = 0; i < arr.length; i++) {

							dataarray3[count3] += arr[i] + "|";

						}

						count3 += 1;

						for (int i = 0; i < arr.length - 1; i++) {
							String classout;

							classout = arr[i] + "|" + arr[4] + "|kind" + Integer.toString(i + 1);

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
					scount += 1;
				}
			}

			tree1 = Findbestsplit1(tree1, datasum1, 4, "root", "", dataarray1);
			int answer1 = testing(tree1, testarray1);
			out.write("prediction1 (1~4번째 줄까지 테스트 데이터) : " + (double) answer1 / 4);
			out.newLine();
			tree2 = Findbestsplit1(tree2, datasum2, 4, "root", "", dataarray2);
			int answer2 = testing(tree2, testarray2);
			out.write("prediction2 (5~8번째 줄까지 테스트 데이터) : " + (double) answer2 / 4);
			out.newLine();
			tree3 = Findbestsplit1(tree3, datasum3, 4, "root", "", dataarray3);
			int answer3 = testing(tree3, testarray3);
			out.write("prediction3 (9~12번째 줄까지 테스트 데이터) : " + (double) answer3 / 4);
			out.newLine();
			out.write("총 prediction : " + (double) (answer1 + answer2 + answer3 / 12));
			out.newLine();

			out.close();
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
		int allnumber = 0;

		Set<String> keys = data.keySet(); // 들어온 데이터셋을 정리한다! <Sunny|Yes, 2.0>

		Iterator<String> itr = keys.iterator();

		while (itr.hasNext()) {
			String keyss = itr.next();

			if (keyss != null) {
				String[] arr = keyss.split("\\|"); // ',' is delimiter.
				int valuess = data.get(keyss); // # of yes or no
				;
				if (arr[1].equals("Yes")) {
					if (!tempclassyes.containsKey(arr[0])) {
						tempclassyes.put(arr[0], valuess);
					} else {
						int tempvalue = tempclassyes.get(arr[0]);
						tempclassyes.replace(arr[0], valuess + tempvalue);
					}
				} else if (arr[1].equals("No")) { // no
					if (!tempclassno.containsKey(arr[0])) {
						tempclassno.put(arr[0], valuess);
					} else {
						int tempvalue = tempclassno.get(arr[0]);
						tempclassno.replace(arr[0], valuess + tempvalue);
					}
				}

				if (!tempclass.containsKey(arr[0])) {
					tempclass.put(arr[0], valuess);
				} else {
					int tempvalue = tempclass.get(arr[0]);
					tempclass.replace(arr[0], tempvalue + valuess);
				}

				allnumber += valuess;
			}
		}

		BigDecimal bestvalue = new BigDecimal("0");
		String bestnode = null;
		int tempcount = 0;

		Set<String> key = tempclass.keySet();
		Iterator<String> it = key.iterator();

		BigDecimal temp = new BigDecimal("0");

		while (it.hasNext()) {
			String keyss = it.next(); // 첫번째 스트링부터 먼저 계산해둔다.

			int valuesyes = 0;
			int valuesno = 0;
			int tempall = 0;

			if (tempclassyes.containsKey(keyss)) {
				valuesyes = tempclassyes.get(keyss); // # of yes
			}

			if (tempclassno.containsKey(keyss)) {
				valuesno = tempclassno.get(keyss); // # of no
			}

			tempall = tempclass.get(keyss); // 해당 스트링의 총 갯수!

			temp = Bigcalculate(valuesyes, valuesno, tempall, allnumber); // 해당
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

			if (tempcount == 0) { // 첫번째 단계면 일단 best에 부여
				bestnode = keyss;
				bestvalue = temp;
			} else {
				if (temp.compareTo(bestvalue) == 1) { // temp값이 bestvalue보다
														// 크면
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
				if (!tempclass1.containsKey(arr[0] + "|" + arr[1])) {
					tempclass1.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass1.get(arr[0] + "|" + arr[1]);
					tempclass1.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind2") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass2.containsKey(arr[0] + "|" + arr[1])) {
					tempclass2.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass2.get(arr[0] + "|" + arr[1]);
					tempclass2.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind3") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass3.containsKey(arr[0] + "|" + arr[1])) {
					tempclass3.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass3.get(arr[0] + "|" + arr[1]);
					tempclass3.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
				}

			} else if (arr[2].equals("kind4") && !remain.contains("'" + remainss + "'")) {
				if (!tempclass4.containsKey(arr[0] + "|" + arr[1])) {
					tempclass4.put(arr[0] + "|" + arr[1], valuess);
				} else {
					int tempvalue = tempclass4.get(arr[0] + "|" + arr[1]);
					tempclass4.replace(arr[0] + "|" + arr[1], tempvalue + valuess);
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
			newarr.put(arr1[0], arr1[1] + ",kind1,0");
		}

		if (tempclass2.size() != 0) {
			String temp2 = PreFindbestsplit(tempclass2);
			String[] arr2 = temp2.split("\\|");
			newarray[sum] = arr2[0];
			sum += 1;
			newarr.put(arr2[0], arr2[1] + ",kind2,1");
		}

		if (tempclass3.size() != 0) {
			String temp3 = PreFindbestsplit(tempclass3);
			String[] arr3 = temp3.split("\\|");
			newarray[sum] = arr3[0];
			sum += 1;
			newarr.put(arr3[0], arr3[1] + ",kind3,2");
		}

		if (tempclass4.size() != 0) {
			String temp4 = PreFindbestsplit(tempclass4);
			String[] arr4 = temp4.split("\\|");
			newarray[sum] = arr4[0];
			sum += 1;
			newarr.put(arr4[0], arr4[1] + ",kind4,3");
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

		for (int i = 0; i < data.length; i++) { // 들어온 데이터의 길이에 따라!
			if (data[i] != null) {
				String[] arr = data[i].split("\\|");
				String[] indexs = Attribute.split("kind");
				int index = Integer.parseInt(indexs[1]);
				String whatnode = arr[index - 1];

				// 결과값을 따로 저장한다. (leaf node 판별을 위해)
				if (whatnode.equals(bestnode)) { // yes쪽 데이터가 될 것들
					if (arr[arr.length - 1].equals("Yes")) {
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
					if (arr[arr.length - 1].equals("Yes")) { // yes
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

				for (int j = 0; j < 4; j++) {
					if (!remain.contains("'" + Integer.toString(j) + "'")) {
						String classification = arr[j] + "|" + arr[4] + "|kind" + Integer.toString(j + 1);
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

		// leaf node 여뷰를 확인한다.

		int remaincount = 4 - remains.length;

		// leaf node 여부 검사

		int leftsign = 0;
		int rightsign = 0;
		
		int leftyes = 0;
		int leftno = 0;
		int rightyes = 0;
		int rightno = 0;

		Set<String> keys1 = resultyesleft.keySet();
		Iterator<String> itr1 = keys1.iterator();

		while (itr1.hasNext()) {
			String keyss = itr1.next();
			int valuess = resultyesleft.get(keyss);
			leftyes += valuess;

			if ((double) valuess / resultleft > 0.9) {
				Node leaf = new Node("Yes");
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
			leftno += valuess;

			if ((double) valuess / resultleft > 0.9) {
				Node leaf = new Node("No");
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
			rightyes += valuess;

			if ((double) valuess / resultright > 0.9) {
				Node leaf = new Node("Yes");
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
			rightno += valuess;

			if ((double) valuess / resultright > 0.9) {
				Node leaf = new Node("No");
				tree.setRight(leaf);
				rightsign = 1;
				break;
			}
		}
		
		if (leftyes == 1 && leftno == 1) {
			leftsign = 1;
			Node leaf = new Node("Yes");
			tree.setLeft(leaf);
		}
		
		if (rightyes == 1 && rightno == 1) {
			rightsign = 1;
			Node leaf = new Node("No");
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
		int index = 0;
		int sign = 0;

		String bestnode = learningtree.getData();
		String bestvalues = null;

		if (bestnode.contains(",")) {
			String[] bestarr = bestnode.split(",");
			bestvalues = bestarr[0];
			String[] indexes = bestarr[1].split("kind");
			index = Integer.parseInt(indexes[1]) - 1;
			sign = 1;
		}

		for (int i = 0; i < testarray.length; i++) {
			if (i == index && sign == 1) {
				if (testarray[i].equals(bestvalues)) { // 왼쪽 노드로 이동해야 됨
					learningtree = learningtree.getLeft();
				} else { // 오른쪽 노드로 이동해야됨
					learningtree = learningtree.getRight();
				}
				answer = treesearching(learningtree, testarray);
			} else if (i == testarray.length - 1) {
				String testarrayvalue = testarray[i];
				String bestnodevalue = bestnode;
				if (testarrayvalue.equals(bestnodevalue)) {
					answer = 1;
				}
			}
		}

		return answer;
	}

}
