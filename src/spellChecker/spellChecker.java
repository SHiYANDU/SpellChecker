package spellChecker;
import java.util.*;

public class spellChecker {
	
	public static void main(String args[]){
		
//		declare variables for dictionary and file
		Set<String> dictionary=null;
		Set<String> words=null;
		Map<String,String> corrections=null;
		String dictPath=null;
		String textPath=null;
//		path for saving to new file
		String savePath=null;
//		choose path of dictionary and text file
		System.out.println("select the dictionary file");
		dictPath= FileChooser.chooseFile();
		System.out.println("select the text file");
		textPath= FileChooser.chooseFile();
//		if user does not choose file, exit the program
		if(dictPath==null||textPath==null){
			System.out.println("no file is chosen, I assume that the program is not intended to be run");
			System.exit(0);
		}
//		load dictionary and text from the path
		dictionary=DictLoader.loadDict(dictPath);
		words=TextLoader.loadText(textPath);
//		instantiate new WordChecker object with loaded data
		WordChecker checker=new WordChecker(words,dictionary);
//		do the spell check
		corrections=checker.check();


//		ask for the destination to save the corrected text
		System.out.println("choose the place and name to store");
		savePath= FileChooser.chooseFile();
		if(savePath==null){
			System.out.println("no location is chosen, I assume that nothing is to be stored");
			System.exit(0);
		}
//		instantiate textwriter to replace correction and write to new file
		TextWriter writer = new TextWriter(textPath, corrections, savePath);
		writer.write();
		
		
	}

	
}
