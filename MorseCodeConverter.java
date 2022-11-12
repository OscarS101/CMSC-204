/**
 * Author:Oscar Saravia
 * CMSC 204
 * Assignment 5
 * MorseCodeTreeConverter:This class is designed to show the contents of the tree 
 * in LNR order. It also has methods that allow it to read from files and string 
 * and translates the morse code to English.
 */
package abc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	
	public MorseCodeConverter() {
		
	}
	
	
	
	/**
	 * 
	 * @return-A string representing the node of the tree in in-order
	 */
	public static String  printTree() {
		//Create tree
		MorseCodeTree test=new MorseCodeTree();
		//Create node and root
		TreeNode list=new TreeNode("");
		test.setRoot(list);
		ArrayList<String> print=new ArrayList<String>();
		//Put words into array
		print=test.LNR(list, print);
		String result="";
		//Print array
		for(int i=0;i<print.size();i++) {
			if(i!=print.size()/2-1)
				result+=print.get(i)+" ";
			if(i==print.size()/2-1)
				result+=" ";
		}
		result=result.trim();
		return result;
	}
	
	/**
	 * 
	 * @param file-The file to read the morse code from
	 * @return-English translation of the morse code
	 */
	public static String convertToEnglish(File file) {
		//Create tree
		MorseCodeTree test=new MorseCodeTree();
		//Initialize variables
		String words[] = null;
		String line="";
		try {
			//Create scanner to read info
			Scanner read=new Scanner(file);
			while(read.hasNext()) {
				//Split code into array
				words=read.nextLine().split(" ");
				
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Translate code
		for(int i=0;i<words.length;i++) {
			line+=test.fetch(words[i]);
		}
		
		return line;
	}
	
	/**
	 * 
	 * @param code-String in morse code to be read
	 * @return-A string of the morse code translated
	 */
	public static String convertToEnglish(String code) {
		//Create tree
		MorseCodeTree test=new MorseCodeTree();
		
		
		//Split code
		String words[]=code.trim().split(" ");
		String result="";
		for(int i=0;i<words.length;i++) {
		//Translate code
		result+=test.fetch(words[i]);
		
		
		}
		return result;
	}
	
	

	
}
