package spellChecker;
import java.util.*;
import java.io.*;

public class TextLoader {
	
//	method to load text to check
	public static Set<String> loadText(String textPath){
//		initialize text file
		Set<String> text=new HashSet<String>();

//		call readText to get text word set
		text=readText(textPath);
		
		return text;
	}
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
