package spellChecker;
import java.util.*;
import java.io.*;
/**The TextLoader provide functionality to read a file as text to correct and store individual words
 * All method are static and does not require an instance
 * @author ShiYan
 * @version 1.0
 * @since 2017-04-30
 */
public class TextLoader {
	/**public static method containing the declaration of text word set and a call to private readText method
	 * main implementation is done in readText
	 * @param textPath path of the file to be checked
	 * @return a Set of distinct words in text to be checked
	 */
//	method to load text to check
	public static Set<String> loadText(String textPath){
//		initialize text file
		Set<String> text=new HashSet<String>();

//		call readText to get text word set
		text=readText(textPath);
		
		return text;
	}
	/**Read the file from input path and parse it by splitting it by one or more non-word characters
	 * the tokenized words will be stored in a Set, which will be returned as output, this set contains every distinct words in text
	 * @param path path a String containing the path of the text file
	 * @return a Set<String> which contains the words in text
	 */
//	method to read and parse text into HashSet
	private static Set<String> readText(String path){
//		initialize set
		Set<String> text = new HashSet<String>();
//		string for line read
		String line="";
//		read from file
		try{
			BufferedReader br= new BufferedReader(new FileReader(path));
//			loop until EOF
			while((line=br.readLine())!=null){
//				separate the line by non word characters
				String[] words = line.split("\\W+");
				for (int i=0; i<words.length;i++){
//					if the word is not added to set yet
					if(!text.contains(words[i])){
//						add the word to the set
						text.add(words[i]);
					}
					
				}
			}
			br.close();
		}
//		catch for IOException
		catch(IOException e){
			System.out.println("wrong file path");
		}
		
		return text;
	}
}
