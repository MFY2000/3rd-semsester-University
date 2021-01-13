package eg.edu.alexu.csd.filestructure.test.avl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dictionary.*;
import dictionaryIf.*;
import junit.framework.Assert;

public class DictionaryTest {

	public static Class<?> getSpecifications(){
		return IDictionary.class;
	}

	public void testLoad() {
		IDictionary dict = (IDictionary) TestRunner.getDicImplementationInstance();
		File input = new File("TestCases/dictionary.txt");
		dict.load(input);
		Assert.assertEquals(9123, dict.size()); // out of the 10,000 input words, there are only 9123 unique words
		Assert.assertEquals(16, dict.height());
	}

	public void testLookup() throws FileNotFoundException {
		IDictionary dict = (IDictionary) TestRunner.getDicImplementationInstance();
		File dictFile = new File("TestCases/dictionary.txt");
		dict.load(dictFile);
		File inputFile = new File("TestCases/queries.txt");
		Scanner sc = new Scanner(inputFile);
		// there are 15 queries. the first 10 exist, and the remaining 5 don't
		for (int i = 0; i < 10; ++i)
			Assert.assertTrue(dict.exists(sc.next()));
		for (int i = 0; i < 5; ++i)
			Assert.assertFalse(dict.exists(sc.next()));
		sc.close();
	}

	public void testDelete() throws FileNotFoundException {
		IDictionary dict = (IDictionary) TestRunner.getDicImplementationInstance();
		File dictFile = new File("TestCases/dictionary.txt");
		dict.load(dictFile);
		File inputFile = new File("TestCases/deletions.txt");
		Scanner sc = new Scanner(inputFile);
		// there are 300 words to delete, but only 290 unique words in them
		while (sc.hasNext())
			dict.delete(sc.next());
		sc.close();
		Assert.assertEquals(9123 - 290, dict.size()); // out of the 10,000 input words, there are only 9123 unique words
		Assert.assertEquals(15, dict.height());
	}

}
