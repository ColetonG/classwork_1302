package prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CodeComparatorTest {

	public static void main(String[] args) {
		testSort();
	}
	
	private static void testSort() {
		for(int testNum=1; testNum<6; testNum++) {
			ArrayList<Product> prodsSorted = createProductList(testNum);
			ArrayList<Product> prodsOriginal = new ArrayList<>(prodsSorted);
			
			Collections.sort(prodsSorted, new CodeComparator());

			printProductList(prodsOriginal, prodsSorted, testNum);
		}
	}

	private static void printProductList(ArrayList<Product> prodsOriginal, ArrayList<Product> prodsSorted, int testNum) {
		System.out.println("Test: " + testNum + "\nOriginal\tSorted");
		System.out.println("--------\t------");
		for(int i=0; i<prodsOriginal.size(); i++) {
			String codeOriginal = prodsOriginal.get(i).getCode();
			String codeSorted = prodsSorted.get(i).getCode();
			System.out.println(codeOriginal + "\t\t" + codeSorted);
		}
		System.out.println();
	}
	private static ArrayList<Product> createProductList(int version) {
		
		ArrayList<Product> prods=null;
		switch (version) {
		case 1:
			prods = new ArrayList<>(Arrays.asList(
					new Product("QC-53"),
					new Product("QC-44")
					));
			break;

		case 2:
			prods = new ArrayList<>(Arrays.asList(
					new Product("DA-333"),
					new Product("DA-111")
					));
			break;

		case 3:
			prods = new ArrayList<>(Arrays.asList(
					new Product("MZ-883"),
					new Product("MZ-050")
					));
			break;

		case 4:
			prods = new ArrayList<>(Arrays.asList(
					new Product("DA-333"),
					new Product("QC-44"),
					new Product("DA-111")
					));
			break;

		case 5:
			prods = new ArrayList<>(Arrays.asList(
					new Product("DA-333"),
					new Product("QC-44"),
					new Product("DA-111"),
					new Product("MZ-883"),
					new Product("QC-53"),
					new Product("MZ-050")
					));
			break;
		}
		return prods;
	}
}
