package eg.edu.alexu.csd.filestructure.test.avl;

import java.util.ArrayList;

import _AVLTreeIf.INode;


public class TestUtil<T extends Comparable<T>> {

	public boolean validateAVL(INode<T> root) {
		return validateBST(root) && checkBalance(root);
	}
	
	public boolean validateBST(INode<T> root) {
		if (root == null)
			return true;
		
		ArrayList<T> inOrder = new ArrayList<T>();
		inOrderTraversal(root, inOrder);
		for (int i = 1; i < inOrder.size(); ++i) {
			if (inOrder.get(i).compareTo(inOrder.get(i - 1)) < 0)
				return false;
		}
		return true;
	}
	
	private void inOrderTraversal(INode<T> node, ArrayList<T> list) {
		if (node == null)
			return;
		inOrderTraversal(node.getLeftChild(), list);
		list.add(node.getValue());
		inOrderTraversal(node.getRightChild(), list);
	}
	
	public boolean checkBalance(INode<T> root) {
		return checkBalanceAux(root) != -1;
	}
	
	private int checkBalanceAux(INode<T> node) {
		if (node == null)
			return 0;
		int left = checkBalanceAux(node.getLeftChild());
		int right = checkBalanceAux(node.getRightChild());
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}
}
