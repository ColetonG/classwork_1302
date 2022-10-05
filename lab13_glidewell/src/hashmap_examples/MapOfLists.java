package hashmap_examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MapOfLists {

	public static void main(String[] args) {
		HashMap<String,List<String>> hmFavMusic = buildHashMap();
		hmExample1(hmFavMusic);
		hmExample2(hmFavMusic);
		HashMap<String,List<String>> hmFavMusic2 = buildHashMap2();
		HashMap<String,List<String>> hmCombined = hmExample3(hmFavMusic, hmFavMusic2);

		System.out.println("Iterate over all key-value pairs:");
		for(String key : hmCombined.keySet()) {
			System.out.printf("   name=%s,\t fav music: ", key);
			List<String> artists = hmCombined.get(key);
			for(String artist : artists) {
				System.out.printf(artist + ", ");
			}
			System.out.println();
		}

	}

	public static HashMap<String,List<String>> buildHashMap() {

		HashMap<String,List<String>> hmFavMusic = new HashMap<>();

		List<String> artists1 = new ArrayList<>();
		artists1.add("Bob Dylan"); artists1.add("Dead"); artists1.add("John Prine");
		hmFavMusic.put("Dave", artists1);

		List<String> artists2 = new ArrayList<>();
		artists2.add("Boz Scaggs"); artists2.add("Dead");
		hmFavMusic.put("Anna", artists2);

		List<String> artists3 = new ArrayList<>();
		artists3.add("Dead"); artists3.add("Bob Dylan"); artists3.add("Steve Miller"); artists3.add("Digit 60");
		hmFavMusic.put("Lee", artists3);

		return hmFavMusic;
	}

	public static void hmExample1(HashMap<String,List<String>> hmFavMusic) {
		System.out.println("\nMap of Lists Example 1\n----------------------");

		System.out.println("Iterate over all key-value pairs:");
		for(String key : hmFavMusic.keySet()) {
			System.out.printf("   name=%s,\t fav music: ", key);
			List<String> artists = hmFavMusic.get(key);
			for(String artist : artists) {
				System.out.printf(artist + ", ");
			}
			System.out.println();
		}
	}
	
	public static void hmExample2(HashMap<String,List<String>> hmFavMusic) {
		System.out.println("\nMap of Lists Example 2\n----------------------");

		HashSet<String> uniqueArtists = new HashSet<>();
		for(List<String> artists : hmFavMusic.values()) {
			uniqueArtists.addAll(artists);			
		}
		System.out.println("Unique Artists: " + uniqueArtists);
	}
	
	public static HashMap<String,List<String>> buildHashMap2() {

		HashMap<String,List<String>> hmFavMusic = new HashMap<>();

		List<String> artists1 = new ArrayList<>();
		artists1.add("Guy Clark"); artists1.add("Dead"); artists1.add("John Prine");
		hmFavMusic.put("Dave", artists1);

		List<String> artists2 = new ArrayList<>();
		artists2.add("Prince"); artists2.add("Jefferson Airplane");
		hmFavMusic.put("Xavier", artists2);

		return hmFavMusic;
	}
	
	public static HashMap<String,List<String>> hmExample3(
			HashMap<String,List<String>> hmFavMusic1,
			HashMap<String,List<String>> hmFavMusic2) {
		System.out.println("\nMap of Lists Example 3\n----------------------");
		
		HashMap<String,List<String>> hmCombined = new HashMap<>(hmFavMusic1);
		
		for(String name : hmFavMusic2.keySet()) {
			if(hmCombined.containsKey(name)) {
				HashSet<String> hsUniqueArtists = new HashSet<>(hmCombined.get(name));
				hsUniqueArtists.addAll(hmFavMusic2.get(name));
				ArrayList<String> alUniqueArtists = new ArrayList<>(hsUniqueArtists);
				hmCombined.put(name, alUniqueArtists);
			}
			else {
				hmCombined.put(name, hmFavMusic2.get(name));
			}
		}
		return hmCombined;
	}



}

