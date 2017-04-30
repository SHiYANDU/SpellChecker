package spellChecker;
import java.util.*;
import java.io.*;

//load and parse the dictionary file 
public class DictLoader {
	
	
//	method to call to load dictionary, return a HashSet 
	public static Set<String> loadDict(String dictPath){
//		Initialize empty dictionary set
		Set<String> dict = new HashSet<String>();


//		call readFile to get dictionary set
		dict=readFile(dictPath);
		
		return dict;
	}
//	read and parse to hashset
	private static Set<String> readFile(String path){
//		initialize set
		Set<String> dict = new HashSet<String>();
//		string initialized for read from file
		String line="";
//		read from file
		try{
			BufferedReader br= new BufferedReader(new FileReader(path));
//			loop until EOF, add word to dictionary
			while((line=br.readLine())!=null){
//				separate the line by non words characters
				String[] words = line.split("\\W+");
				for (int i=0; i<words.length;i++){
//					if the word is not added to set yet
					if(!dict.contains(words[i])){
//						add the word to the set
						dict.add(words[i]);
					}
					
				}
			}
			br.close();
		}
//		catch for IOException
		catch(IOException e){
			System.out.println("wrong file path");
		}
		return dict;
	}
	
	
}
