package treemap_examples;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapExamples {
	public static void main(String[] args) {
		tmExample1();
		TreeMap<String,Integer> tmScores1 = buildTreeMap1();
		TreeMap<String,Integer> tmScores2 = buildTreeMap2();
		TreeMap<String,Integer> tmCommon = tmExample2(tmScores1, tmScores2);

		System.out.println("tmScores1=" + tmScores1);
		System.out.println("tmScores2=" + tmScores2);

		System.out.println("\nIterate over all tmCommon:");
		for(String name : tmCommon.keySet()) {
			System.out.printf("   key=%s, value=%d \n", name, tmCommon.get(name));
		}
	}

	public static void tmExample1() {
		System.out.println("TreeMap Example 1\n-----------------");

		TreeMap<String,Integer> tmScores = new TreeMap<>();

		tmScores.put("Felix", 42);
		tmScores.put("Bill", 28);
		tmScores.put("Dee", 42);
		tmScores.put("Sue", 33);
		tmScores.put("Ann", 99);
		tmScores.put("Xavier", 68);
		tmScores.put("Ray", 55);
		tmScores.put("Pam", 35);

		Set<String> names = tmScores.keySet();
		System.out.println("Iterate over all key-value pairs:");
		for(String key : names) {
			System.out.printf("   key=%s, value=%d \n", key, tmScores.get(key));
		}

		String smallestKey = tmScores.firstKey();
		System.out.println("\nSmallest key=" + smallestKey);

		int score = tmScores.get(smallestKey);
		System.out.println("Score corresponding to smallest key=" + score);


		System.out.println("\ntmScores.headMap(\"M\"):");
		SortedMap<String,Integer> sMap = tmScores.headMap("M");
		for(String key : sMap.keySet()) {
			System.out.printf("   key=%s, value=%d \n", key, sMap.get(key));
		}
	}
	
	public static TreeMap<String,Integer> buildTreeMap1() {
		TreeMap<String,Integer> tmScores = new TreeMap<>();

		tmScores.put("Felix", 42);
		tmScores.put("Bill", 28);
		tmScores.put("Dee", 42);
		tmScores.put("Sue", 13);
		tmScores.put("Ann", 33);

		return tmScores;
	}
	public static TreeMap<String,Integer> buildTreeMap2() {
		TreeMap<String,Integer> tmScores = new TreeMap<>();

		tmScores.put("Bill", 12);
		tmScores.put("Sue", 33);
		tmScores.put("Ann", 44);
		tmScores.put("Xavier", 68);
		tmScores.put("Aby", 55);
		tmScores.put("Pam", 35);

		return tmScores;
	}
	
	public static TreeMap<String,Integer> tmExample2(
			TreeMap<String,Integer> tmScores1,
			TreeMap<String,Integer> tmScores2) {

		System.out.println("\nTreeMap Example 2\n-----------------");
		TreeMap<String,Integer> tmCommon = new TreeMap<>();

		for(String name : tmScores1.keySet()) {
			if( tmScores2.containsKey(name)) {
				int s1 = tmScores1.get(name);
				int s2 = tmScores2.get(name);
				tmCommon.put(name, s1+s2);
			}
		}
		return tmCommon;
	}


}

