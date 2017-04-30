package spellChecker;
import java.util.*;
import java.io.*;
/**The DictLoader provide functionality to read a file as dictionary and store it in appropriate format
 * All method are static and does not require an instance
 * @author ShiYan
 * @version 1.0
 * @since 2017-04-30
 */
//load and parse the dictionary file 
public class DictLoader {
	
/**public static method containing the declaration of dictionary set and a call to readFile method
 * 	main implementation is done in readFile
 * @param dictPath takes a String as the path of the dictionary file
 * @return the resulting dictionary set of string
 */
//	method to call to load dictionary, return a HashSet 
	public static Set<String> loadDict(String dictPath){
//		Initialize empty dictionary set
		Set<String> dict = new HashSet<String>();


//		call readFile to get dictionary set
		dict=readFile(dictPath);
		
		return dict;
	}
/**Read the file from input path and parse it by splitting it by one or more non-word characters
 * the tokenized words will be stored in a Set, which will be returned as output, this set contains every distinct words in dictionary
 * @param path a String containing the path of the dictionary file
 * @return a Set<String> which contains the words in dictionary
 */

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
