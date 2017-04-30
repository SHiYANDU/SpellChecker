package spellChecker;
import java.io.*;
import java.util.*;

// this class contains functionalities of rewrite and save the text with appropriate correction
public class TextWriter {
//	the path of the text to be rewritten
	private String textPath;
//	correction map
	private Map<String,String> correction;
//	the destination path of storing new text
	private String newPath;
//	constructor initializing variables
	public TextWriter(String text, Map<String,String> corr, String destination){
		textPath=text;
		correction=corr;
		newPath=destination;
		
	}
//	correct and write the text to new file
	public void write(){
//		try to open the old text and store into string
		try{
			File input = new File(textPath);
			BufferedReader reader = new BufferedReader(new FileReader(input));
			String line="";
//			string to restore the full text to correct
			String fulltext="";
//			read until end of file
			while((line=reader.readLine())!=null){
//				add to full text line read and line split
				fulltext+=line+"\r\n";
				
			}
			reader.close();
			
//			now the thing is, we need to verify every word in text and correct them
//			this can not be done by replaceAll, so the method here is
//			split the old text twice, one time by words, one time by non-words
//			so we have one array of all words and another array of all delimiters
//			as the text start with "", which will be seen as a no word delimiter
//			after the correction, we insert these back to the new text, starting from first delimiter
//			so the new text will be alternating delimiters and words, restoring it with appropriate correction
			String newtext="";
//			get the key set of correction
			Set<String> keys= correction.keySet();
//			split first by non-words then by words forming two array
			String[] words=fulltext.split("\\W+");
			String[] delimiters=fulltext.split("\\w+");
//			correct the words array based on correction mapping
			for (int i=0;i<words.length;i++){
				if (keys.contains(words[i])){
					words[i]=correction.get(words[i]);
				}
			}
//			starting from first delimiter, insert all into new text
			for(int k=0;k<delimiters.length;k++){
				newtext+=delimiters[k];
				if(k<words.length){
					newtext+=words[k];
				}
			}
			
//			write to File
			FileWriter writer = new FileWriter(newPath);
			writer.write(newtext);
			writer.close();
			
		}
		catch(IOException e){
			System.out.println("wrong file path");
		}
		
		
		
		
	}
}
