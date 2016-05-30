package myMapReduce;

import java.util.List;

import mapReduce.MapReduce;
import mapReduce.Pair;

/**
 * @author David Matuszek
 */
public class WordCounter {

    /**
     * Counts word occurrences.
     * 
     * @param args Unused.
     */
    public static void main(String[] args) {
        
        String data = "Map, written by a user of the MapReduce library, takes " +
                      "an input pair and produces a set of intermediate key/value " +
                      "pairs. The MapReduce library groups together all intermediate " +
                      "values associated with the same intermediate key I and passes " +
                      "them to the reduce function. \n" + 
                      "The reduce function, also written by the user, accepts an " +
                      "intermediate key I and a set of values for that key. It merges " +
                      "together these values to form a possibly smaller set of values.";
        
        List<Pair<String, String>> results;
        results = new MapReduce().execute("Test data", data);
        
        for (Pair<String, String> pair : results) {
            System.out.println(pair.key + "   " + pair.value);
        }
    }
}
