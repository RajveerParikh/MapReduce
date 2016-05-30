package myMapReduce;

import java.util.ArrayList;
import java.util.List;

import mapReduce.Mapper;

/**
 * Class to check each word of file for initial, final and total letters
 * @author Rajveer Parikh
 */

public class MyMapper extends Mapper {
    /**
     * Method used to process each word of the text file for the initial, final and total letters 
     * @param documentID The ID for the document to be read
     * @param document The text file to be processed
     */
    @Override
    public void map(String documentID, String document) {
    	int wordCount = 0;
    	document = document.replaceAll("'", "");
        String[] words = document.split("[^a-zA-Z]");
        for (char ch = 'A'; ch <= 'Z'; ch++){
        	emit(ch+"", "w");
        }
        for (String word : words) {
        	word = word.toUpperCase();
        	if (word.length() > 0){
        		emit(word.charAt(0) + "", "i");
        		emit(word.charAt(word.length()-1) + "", "f");
        		for (int i = 0; i < word.length();i++){
        			emit(word.charAt(i)+"", "o");
        		}
        	}
        }
    }
}