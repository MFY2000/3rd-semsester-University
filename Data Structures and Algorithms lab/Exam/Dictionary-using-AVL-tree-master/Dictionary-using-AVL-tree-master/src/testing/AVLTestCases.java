package testing;

import _AVLTree.AVLTree;
import junit.framework.TestCase;

public class AVLTestCases extends TestCase {

    AVLTree<Integer> tree ;
    AVLTree<Character> tree2 ;
    AVLTree<String> tree3 ;
    
    /**
     * integers tests.
     * no duplications.
     */
    public void testIntegersNoDup(){
        tree = new AVLTree<Integer>(false);
         tree.insert(5);
         tree.insert(4);
         tree.insert(3);
         tree.insert(2);
         tree.insert(1);
         assertEquals(tree.search(5), true);
         assertEquals(tree.search(4), true);
         tree.insert(4);
         assertEquals((boolean)tree.getDoneMsg(), false);
         assertEquals(tree.search(3), true);
         assertEquals(tree.search(2), true);
         assertEquals(tree.search(1), true);
         tree.insert(1);
         assertEquals((boolean)tree.getDoneMsg(), false);
         assertEquals(tree.search(0), false);
         assertEquals(tree.search(-1), false);
         assertEquals(tree.search(10), false);
         assertEquals(tree.search(6), false);
         tree.insert(-1);
         assertEquals(tree.search(-1), true);
         assertEquals(tree.delete(-1), true);
         assertEquals(tree.search(-1), false);
         assertEquals(tree.height(), 3);
         assertEquals(tree.delete(4), true);
         assertEquals(tree.height(), 3);
    }
    
    /**
     * integers tests.
     * with duplications.
     */
    public void testIntegersWithDup(){
        tree = new AVLTree<Integer>(true);
        tree.insert(5);
        tree.insert(5);
        tree.insert(5);
        assertEquals(tree.search(5), true);
        assertEquals(tree.search(4), false);
        assertEquals(tree.height(), 1);
        assertEquals(tree.delete(4), false);
        assertEquals(tree.height(), 1);
        assertEquals(tree.delete(5), true);
        assertEquals(tree.height(), 1);
        assertEquals(tree.delete(5), true);
        assertEquals(tree.height(), 1);
        assertEquals(tree.delete(5), true);
        assertEquals(tree.height(), 0);
   }
    
    /**
     * chars tests.
     */
    public void testChars(){
        tree2 = new AVLTree<Character>(true);
        tree2.insert('a');
        tree2.insert('b');
        tree2.insert('z');
        assertEquals(tree2.search('c'), false);
        assertEquals(tree2.search('u'), false);
        assertEquals(tree2.height(), 2);
        assertEquals(tree2.delete('b'), true);
        assertEquals(tree2.height(), 2);
        assertEquals(tree2.delete('z'), true);
        assertEquals(tree2.height(), 1);
        assertEquals(tree2.search('a'), true);
        assertEquals(tree2.search('z'), false);
        assertEquals(tree2.search('b'), false);
        assertEquals(tree2.height(), 1);
        assertEquals(tree2.delete('a'), true);
        assertEquals(tree2.height(), 0);
   }
    
    /**
     * Strings tests.
     */
    public void testStrings(){
        tree3 = new AVLTree<String>(true);
        tree3.insert("apple");
        tree3.insert("banana");
        tree3.insert("zoo");
        assertEquals(tree3.search("cat"), false);
        assertEquals(tree3.search("umbrella"), false);
        assertEquals(tree3.height(), 2);
        assertEquals(tree3.delete("banana"), true);
        assertEquals(tree3.height(), 2);
        assertEquals(tree3.delete("zebra"), false);
        assertEquals(tree3.height(), 2);
        assertEquals(tree3.search("apple"), true);
        assertEquals(tree3.search("zoo"), true);
        assertEquals(tree3.delete("apple"), true);
        assertEquals(tree3.height(), 1);
   }
}