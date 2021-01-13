package _AVLTree;

/**
 * this class contains all needed operations used in AVL trees.
 * @author Mohamed Murad.
 */
public class AVLTreeOperations<T> {

    /**
     * height of a node is the length of the path. which equals numbers of all
     * nodes in this path.
     * 
     * @param node
     *            which we get its height
     * @return the height value.
     */
    int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    /**
     * get maximum to compare heights of two child.
     * @param first
     *            value in comparison.
     * @param second
     *            value in comparison.
     * @return the largest value.
     */
    int getMax(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * check if the BST property is true.
     * @param node
     *            which we compares its left and right children's heights.
     * @return value which is one of 2,1,0,-1,2 only 2 and -2 the unbalanced
     *         values.
     */
    int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return (getHeight((Node<T>) node.getLeftChild()) - getHeight((Node<T>) node.getRightChild()));
    }

    /**
     * rotate the tree right at y to fulfill the BST property.
     * @param y
     *            is the node which tree needed to be rotated at.
     * @return x is the new node after rotation.
     */
    Node<T> rightRotate(Node<T> y) {
        Node<T> x = (Node<T>) y.getLeftChild();
        Node<T> t2 = (Node<T>) x.getRightChild();

        x.setRightChild(y);
        y.setLeftChild(t2);

        y.setHeight(1 + getMax(getHeight((Node<T>) y.getLeftChild()), getHeight((Node<T>) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node<T>) x.getLeftChild()), getHeight((Node<T>) x.getRightChild())));

        return x;
    }

    /**
     * rotate the tree left at y to fulfill the BST property.
     * @param y
     *            is the node which tree needed to be rotated at.
     * @return x is the new node after rotation.
     */
    Node<T> leftRotate(Node<T> y) {
        Node<T> x = (Node<T>) y.getRightChild();
        Node<T> t2 = (Node<T>) x.getLeftChild();

        x.setLeftChild(y);
        y.setRightChild(t2);

        y.setHeight(1 + getMax(getHeight((Node<T>) y.getLeftChild()), getHeight((Node<T>) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node<T>) x.getLeftChild()), getHeight((Node<T>) x.getRightChild())));

        return x;
    }

}
