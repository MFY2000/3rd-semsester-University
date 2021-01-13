package testing;

import java.io.File;

import dictionary.Dictionary;
import dictionaryIf.IDictionary;
import junit.framework.TestCase;

public class DictionaryTestCases extends TestCase {

    public void testDic() {
        IDictionary dictionary = new Dictionary();
        String cPath = System.getProperty("user.home"), fileName = "\\dic.txt";
        File file = new File(cPath + fileName);
        dictionary.load(file);
        assertEquals(dictionary.exists("ziad"), true);
        assertEquals(dictionary.size(), 26);
        assertEquals(dictionary.exists("faN"), false);
        assertEquals(dictionary.insert("ziad"), false);
        assertEquals(dictionary.exists("zoo"), false);
        assertEquals(dictionary.delete("ziad"), true);
        assertEquals(dictionary.exists("ziad"), false);
        assertEquals(dictionary.insert("ziad"), true);
        assertEquals(dictionary.insert("zoo"), true);
        assertEquals(dictionary.size(), 27);
    }
}
