package spellChecker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class TestChecker {

	Set<String> text;
	Set<String> dict;
	Map<String,String> corr;
	
	@Before
	public void setUp() throws Exception {
		text=new HashSet<String>();
		dict=new HashSet<String>();
		corr=new HashMap<String,String>();
		text.add("right");
		text.add("wrongg");
		dict.add("right");
		dict.add("wrong");
	}

	@Test
	public void test() {
		
		WordChecker checker = new WordChecker(text,dict);
		corr=checker.check();
//		wrongg must be in key set
		assertTrue(corr.containsKey("wrongg"));
//		right must not be in key set
		assertTrue(!corr.containsKey("right"));
//		correction of wrongg must not be null
		assertTrue(corr.get("wrongg")!=null);
	}

}
