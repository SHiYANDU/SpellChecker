package spellChecker;
import java.util.*;
//check the spelling of the word
/**class which contains in it the set of word and dictionary, it perform check with these two sets
 * it need to be an instance with correct parameters and its method perform the check and return correction map
 * @author ShiYan
 * @version 1.0
 * @since 2017-04-30
 */
public class WordChecker{

	private Set<String> word;
	private Set<String> dict;
//	to store the correction pairs in HashMap, making it thread-safe
	private Map<String,String> corr= Collections.synchronizedMap(new HashMap<String,String>());

//	constructor storing word and dictionary
	public WordChecker(Set<String> inputWord, Set<String> inputDict){
		word=inputWord;
		dict=inputDict;
	}
	/**check the map with the two set stored in the object
	 * this will check each word with the dictionary parallelly and provoke a Correction Proposer window for each, putting the wrong-corrected pair into output map
	 * @return the map of wrongword-correction pairs
	 */
//  spell checking method. return a Map with key as words to correct
	public Map<String,String> check(){
		
//		iterate over item in word
		Iterator<String> iter = word.iterator();
		while(iter.hasNext()){
//			new thread for each word
			Thread t = new Thread(new Checker(iter.next()));
			t.start();
//			pause the main method until the threads finish
			try{
				t.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		return corr;
	}
	/**The class implementing Runnable interface to be used to initialize a thread 
	 * this provide functionality to the thread to verify the word and ask for correction
	 * @author ShiYan
	 * @version 1.0
	 * @since 2017-04-30
	 */
//	runnable interface for check one word in thread
	public class Checker implements Runnable{
//		the word to check
		private String singleword;
//		constructor to initialize singleword
		public Checker(String input){
			singleword=input;
		}
		/** the run method implemented to be started in thread
		 *  the thread manipulates the thread-safe synchronized Map correction and put the resulting pairs in it
		 */
//		the run method for thread
		public void run(){
			
//			if the dictionary does not contain word, put the word as a key in corr
			if (!dict.contains(singleword)){
				
//				instantiate the GUI object to ask for correction
				CorrectionProposer proposer = new CorrectionProposer(singleword);
//				wait until action is performed in proposer GUI
				while (!proposer.performed())
				{
					corr.put(singleword, proposer.getCorrection());
				}
				

				corr.put(singleword, proposer.getCorrection());
//				close the awt window
				proposer.dispose();
			}
			
		}	
	}		
}