package myMapReduce;

import java.util.Comparator;

import mapReduce.Pair;

public class PairComparator implements Comparator <Pair<String, String>>{

	@Override
	public int compare(Pair<String, String> o1, Pair<String, String> o2) {
		String key1 = o1.key;
		String key2 = o2.key;
		return key1.compareTo(key2);
	}
}
