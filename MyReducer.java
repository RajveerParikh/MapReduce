package myMapReduce;

import java.util.List;

import mapReduce.Reducer;

/**
 * Class to get total initial, final and total letter count for each letter in text file
 * @author Rajveer Parikh
 */
public class MyReducer extends Reducer {
    /**
     * Method counts total initial, final and total count for each letter and emits 
     * @param word Letter for which the counts need to be processed
     * @param counts List of the different positions the letter is found in the text file
     * (i = Intial, f = Final, o = Other
     */
    @Override
    public void reduce(String word, List<String> counts) {
    	int initialLetters = 0;
    	int finalLetters = 0;
    	int otherLetters = 0;
    	for (int i = 0; i < counts.size(); i++){
    		if ("i".equals(counts.get(i))){
    			initialLetters++;
    		}
    		else if("o".equals(counts.get(i))){
    			otherLetters++;
    		}
    		else if("f".equals(counts.get(i))){
    			finalLetters++;
    		}
    		else if("w".equals(counts.get(i))){
    			
    		}
    	}
    	emit(word + " Initial", initialLetters + "");
    	emit(word + " Total", otherLetters + "");
    	emit(word + " Final", finalLetters + "");
    }
}
