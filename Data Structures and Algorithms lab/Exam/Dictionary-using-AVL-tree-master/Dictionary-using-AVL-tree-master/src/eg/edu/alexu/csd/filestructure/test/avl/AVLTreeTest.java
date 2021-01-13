package eg.edu.alexu.csd.filestructure.test.avl;

import junit.framework.Assert;
import _AVLTreeIf.IAVLTree;


public class AVLTreeTest {

	TestUtil<Integer> validator;
	
	public AVLTreeTest() {
		validator = new TestUtil<Integer>();
	}

	public static Class<?> getSpecifications(){
		return IAVLTree.class;
	}
	
	public void testInsert() {
		@SuppressWarnings("unchecked")
		IAVLTree<Integer> avl = (IAVLTree<Integer>) TestRunner.getImplementationInstance();
		int[] input = {13,8,5,9,4,6,12,2,1,3};
//		int[] height = {0,1,1,2,2,2,2,3,3,3};
		int[] height = {1,2,2,3,3,3,3,4,4,4};
		
		for (int i = 0; i < input.length; ++i) {
			avl.insert(input[i]);
			Assert.assertEquals(avl.height(), height[i]);
		}
	}

	public void testInsertSkewed() {
		@SuppressWarnings("unchecked")
		IAVLTree<Integer> avl = (IAVLTree<Integer>) TestRunner.getImplementationInstance();
		for (int i = 1; i < 1000; ++i)
			avl.insert(i);
		
		Assert.assertTrue(validator.validateAVL(avl.getTree()));
	}

	public void testSearch() {
		@SuppressWarnings("unchecked")
		IAVLTree<Integer> avl = (IAVLTree<Integer>) TestRunner.getImplementationInstance();
		int[] input = {13,8,5,9,4,6,12,2,1,3};
		int[] positive = {8,12,3};
		int[] negative = {0,11,20};
		
		for (int i = 0; i < input.length; ++i) {
			avl.insert(input[i]);
		}
		for (int q : positive)
			Assert.assertTrue(avl.search(q));
		for (int q : negative)
			Assert.assertFalse(avl.search(q));
	}

	public void testDelete() {
		@SuppressWarnings("unchecked")
		IAVLTree<Integer> avl = (IAVLTree<Integer>) TestRunner.getImplementationInstance();
		int[] input = {13,8,5,9,4,6,12,2,1,3};
		
		for (int i = 0; i < input.length; ++i)
			avl.insert(input[i]);

		// try deleting non-existing elements
		for (int i = -1; i >= -5; --i) {
			Assert.assertFalse(avl.delete(i));
		}

		// check that the tree structure is not affected
		Assert.assertTrue(validator.validateAVL(avl.getTree()));

		// delete all existing elements
		int[] deleteOrder = {8,4,2,12,9,13,5,3,1,6};
		for (int element : deleteOrder) {
			Assert.assertTrue(avl.delete(element));
			Assert.assertTrue(validator.validateAVL(avl.getTree()));
		}
	}

}
