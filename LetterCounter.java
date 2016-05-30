package myMapReduce;
import javax.swing.JFileChooser;

import mapReduce.MapReduce;
import mapReduce.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class with main method to count each letter count. Asks user for file input, processes text 
 * and saves into string builder and then calls the execute method.
 * @author Rajveer Parikh
 */
public class LetterCounter {
//	static int wordCount = 0;
	public static void main(String args[]){
		String filePath = null;
		BufferedReader reader = null;
		List<Pair<String, String>> listOfPairs = new ArrayList<Pair<String, String>>();
		//JFileChooser to prompt user to select a text file
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Load which file?");
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String fileName = file.getName();
			if (file != null) {
				try {
					filePath = file.getCanonicalPath();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					reader = new BufferedReader(new FileReader(filePath));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				String line;
				StringBuilder sb = new StringBuilder();
				try {
					//Process all text in the input file into a string builder
					while ((line = reader.readLine()) != null) {
						sb.append(line);
						sb.append("\n");
//						wordCount = wordCount + wordCounter(sb.toString());
					}
//					System.out.println(wordCount);
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				MapReduce mapReducer = new MapReduce();
				listOfPairs = mapReducer.execute(fileName, sb.toString());
				PairComparator listComparator = new PairComparator();
				listOfPairs.sort(listComparator);
			}
		}
		//Print first row of output (Letters from A-Z)
		System.out.print("           ");
		for (char ch = 'A'; ch <= 'Z'; ch++){
			System.out.print(ch + "      ");
		}
		//Print Row of Initial counts for each letter
		System.out.println();
		System.out.print("Intial:  ");
		for (int i = 0; i < listOfPairs.size(); i++){
			if (listOfPairs.get(i).key.charAt(2) == 'I'){
				printValue(listOfPairs.get(i).value);
			}
		}
		//Print Row of Final counts for each letter
		System.out.println();
		System.out.print("Final:   ");
		for (int i = 0; i < listOfPairs.size(); i++){
			if (listOfPairs.get(i).key.charAt(2) == 'F'){
				printValue(listOfPairs.get(i).value);
			}
		}
		//Print Row of Total counts for each letter
		System.out.println();
		System.out.print("Total:   ");
		for (int i = 0; i < listOfPairs.size(); i++){
			if (listOfPairs.get(i).key.charAt(2) == 'T'){
				printValue(listOfPairs.get(i).value);
			}
		}
	}
	
	/**
	 * Helper method to help print the text in a formatter manner
	 * @param value Value to be printed
	 */
	public static void printValue(String value){
		if (value.length() == 1){
			System.out.print(value + "      " );
		}
		else if(value.length() == 2){
			System.out.print(value + "     ");
		}
		else if(value.length() == 3){
			System.out.print(value + "    ");
		}
		else if(value.length() == 4){
			System.out.print(value + "   ");
		}
		else if(value.length() == 5){
			System.out.print(value + "  ");
		}
		else if(value.length() == 6){
			System.out.print(value + " ");
		}
		else{
			System.out.print(value + "");
		}
	}
	
//	/**
//	 * Helper method to print the total word count in text file
//	 * @param line Counts total words one line at a time
//	 */
//	public static int wordCounter(String line){
//		int  i = 0;
//		while (line.charAt(i) != '\n'){
//			wordCount++;
//		}
//		return wordCount;
//	}
}
