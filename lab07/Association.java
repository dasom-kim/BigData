package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Association {
	static HashMap<String, Integer> dataid = new HashMap<String, Integer>(); // data와
																				// ID가
																				// 저장되어
																				// 있는
																				// 해쉬맵
	static HashMap<String, Integer> tempset = new HashMap<String, Integer>();
	static HashMap<String, Integer> itemset = new HashMap<String, Integer>();
	static HashMap<Integer, String> transaction = new HashMap<Integer, String>(); // transaction
																					// 별로
																					// 저장된
																					// 데이터
	static HashMap<String, Integer> transactionset = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		String s;
		int tcount = 0; // transaction 갯수 저장하는 변수

		try {
			BufferedReader br = new BufferedReader(new FileReader("C://Users/Poweruser/Downloads/vote big.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("C://Users/Poweruser/Downloads/out2.txt"));

			while ((s = br.readLine()) != null) {
				String[] arr = s.split(" "); // ',' is delimiter
				if (!(s.equals(""))) {
					if (s.contains("@")) {
						dataid.put(arr[1], Integer.parseInt(arr[2]));
					} else {
						for (int i = 0; i < arr.length; i++) {
							if (!transaction.containsKey(tcount)) {
								transaction.put(tcount, arr[i]);
							} else {
								String temp = transaction.get(tcount);
								transaction.replace(tcount, temp + "|" + arr[i]);
							}
						}
						tcount += 1;
					}
				}
			}

			Apriori(transaction, 1);
			
			Set<String> keys = itemset.keySet();
			Iterator<String> itr = keys.iterator();

			while (itr.hasNext()) {
				String keyss = itr.next();
				int valuess = itemset.get(keyss);
				
				
				out.write("["+keyss +"] : "+ valuess);
				out.newLine();
			}

			out.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void Apriori(HashMap<Integer, String> data, int elements) {
		int transnum = transaction.size(); // 장바구니 갯수
		Set<Integer> resultset = new HashSet<Integer>();
		Set<Integer> keys = data.keySet();
		Iterator<Integer> itr = keys.iterator();

		while (itr.hasNext()) {
			int keyss = itr.next();
			String valuess = data.get(keyss);
			String[] arr = valuess.split("\\|");

			for (int i = 0; i < arr.length; i++) {
				if (!tempset.containsKey(arr[i])) {
					tempset.put(arr[i], 1);
				} else {
					int tempvalue = tempset.get(arr[i]);
					tempset.put(arr[i], tempvalue + 1);
				}
			}
		}

		Set<String> keys2 = tempset.keySet();
		Iterator<String> itr2 = keys2.iterator();

		while (itr2.hasNext()) {
			String keyss = itr2.next();
			int valuess = tempset.get(keyss);

			if ((double) valuess / transnum >= 0.5) {
				itemset.put(keyss, valuess);
				resultset.add(Integer.parseInt(keyss));
			}
		}

		elements += 1;

		PreChecking(resultset, elements);
	}

	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
		Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<Integer>());
			return sets;
		}
		List<Integer> list = new ArrayList<Integer>(originalSet);
		Integer head = list.get(0);
		Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
		for (Set<Integer> set : powerSet(rest)) {
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}

	public static void PreChecking(Set<Integer> resultset, int elements) {
		Set<Integer> temp = new HashSet<Integer>();

		for (Set<Integer> s1 : Association.powerSet(resultset)) {
			if (s1.size() == elements) { // 삭제 과정쓰
				String temp1 = s1.toString().substring(1);
				String[] temp2 = temp1.split("]");
				String[] temp3 = temp2[0].split(", ");
				temp = Checking(temp3, elements, temp2[0], temp);
			}
		}

		elements += 1;

		if (temp.size() != 0) {
			PreChecking(temp, elements);
		} 
	}

	public static Set<Integer> Checking(String[] tempresult, int elements, String temp, Set<Integer> temphash) {
		int ok = 0;

		Set<Integer> keys = transaction.keySet();
		Iterator<Integer> itr = keys.iterator();

		while (itr.hasNext()) {
			int sign = 0;
			int keyss = itr.next();
			String valuess = transaction.get(keyss);
			String[] arr = valuess.split("\\|");

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < elements; j++) {
					if (arr[i].equals(tempresult[j])) {
						sign += 1;
					}
				}
			}

			if (sign == elements) {
				ok += 1;
			}
		}

		if ((double) ok / transaction.size() >= 0.5) {
			itemset.put(temp, ok);
			for (int j = 0; j < elements; j++) {
				temphash.add(Integer.parseInt(tempresult[j]));
			}
		}

		return temphash;

	}

}
