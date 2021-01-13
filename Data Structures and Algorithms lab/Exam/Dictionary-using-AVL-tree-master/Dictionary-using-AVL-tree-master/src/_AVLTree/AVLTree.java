package _AVLTree;

import _AVLTreeIf.IAVLTree;
import _AVLTreeIf.INode;

public class AVLTree<T> implements IAVLTree<T> {

    private Node<T> root;
    private AVLTreeOperations<T> operations;
    /**
     * duplication is used in creating the AVL to determine if duplication is
     * required in the instance or not. doneMsg is true if any main operations
     * completed successfully.it's reset to false after each operation.
     */
    private Boolean duplication, doneMsg;

    public AVLTree(Boolean duplication) {
        super();
        operations = new AVLTreeOperations<>();
        doneMsg = false;
        this.duplication = duplication;
    }

    /**
     * @return true if operation in AVL completed successfully.
     */
    public Boolean getDoneMsg() {
        return doneMsg;
    }

    /**
     * @param doneMsg true if operation in AVL completed successfully.
     */
    public void setDoneMsg(Boolean doneMsg) {
        this.doneMsg = doneMsg;
    }

    /**
     * reset doneMsg to false.
     * to prevent conflict.
     * it's used at the beginning of each operation.
     */
    public void resetDoneMsg() {
        doneMsg = false;
    }

    /**
     * print the AVL Tree in ascending order.
     */
    public void inOrder() {
        if (root != null) {
            inOrder((Node<T>) root.getLeftChild());
            System.out.print(root.getValue() + " ");
            inOrder((Node<T>) root.getRightChild());
        }
    }

    void inOrder(Node<T> node) {
        if (node != null) {
            inOrder((Node<T>) node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrder((Node<T>) node.getRightChild());
        }
    }

    @Override
    public void insert(T key) {
        // TODO Auto-generated method stub
        resetDoneMsg();
        if (root == null) {
            setDoneMsg(true);
            root = new Node<T>(key);
        } else {
            if (root.compareTo((T) key) > 0) {
                root.setLeftChild(insert((Node<T>) root.getLeftChild(), key));
            } else if (root.compareTo((T) key) < 0) {
                root.setRightChild(insert((Node<T>) root.getRightChild(), key));
            } else {
                if (duplication) {
                    setDoneMsg(true);
                    root.setCnt(root.getCnt() + 1);
                } else {
                    setDoneMsg(false);
                }
            }
        }
        resetHeight(root);
        root = rebalancing(root, key);
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null) {
            setDoneMsg(true);
            return new Node<T>(key);
        }
        if (node.compareTo((T) key) > 0) {
            node.setLeftChild(insert((Node<T>) node.getLeftChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else if (node.compareTo((T) key) < 0) {
            node.setRightChild(insert((Node<T>) node.getRightChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else {
            if (duplication) {
                setDoneMsg(true);
                root.setCnt(root.getCnt() + 1);
            } else {
                setDoneMsg(false);
            }
        }
        return node;
    }

    private void resetHeight(Node<T> node) {
        if (node != null) {
            node.setHeight(1 + operations.getMax(operations.getHeight((Node<T>) node.getLeftChild()),
                    operations.getHeight((Node<T>) node.getRightChild())));
        }
    }

    private Node<T> rebalancing(Node<T> node, T key) {
        if (node != null) {
            int balance = operations.getBalance(node);

            if (balance > 1 && node.hasLeftChild() && node.getLeftChild().compareTo((T) key) > 0)
                node = operations.rightRotate(node);

            if (balance < -1 && node.hasRightChild() && node.getRightChild().compareTo((T) key) < 0)
                node = operations.leftRotate(node);

            if (balance > 1 && node.hasLeftChild() && node.getLeftChild().compareTo((T) key) < 0) {
                node.setLeftChild(operations.leftRotate((Node<T>) node.getLeftChild()));
                node = operations.rightRotate(node);
            }

            if (balance < -1 && node.hasRightChild() && node.getRightChild().compareTo((T) key) > 0) {
                node.setRightChild(operations.rightRotate((Node<T>) node.getRightChild()));
                node = operations.leftRotate(node);
            }
        }
        return node;
    }

    private Node<T> getMin(Node<T> node) {
        Node<T> minNode = node;
        while (minNode.hasLeftChild()) {
            minNode = (Node<T>) minNode.getLeftChild();
        }
        return minNode;
    }

    @Override
    public boolean delete(T key) {
        // TODO Auto-generated method stub
        resetDoneMsg();
        if (root == null) {
            return getDoneMsg();
        } else {
            if (root.compareTo((T) key) > 0) {
                root.setLeftChild(delete((Node<T>) root.getLeftChild(), key));
            } else if (root.compareTo((T) key) < 0) {
                root.setRightChild(delete((Node<T>) root.getRightChild(), key));
            } else {
                setDoneMsg(true);
                if (root.getCnt() > 1) {
                    root.setCnt(root.getCnt() - 1);
                } else {
                    if (!root.hasLeftChild() && !root.hasRightChild()) {
                        root = null;
                    } else if (root.hasLeftChild() && root.hasRightChild()) {
                        Node<T> temp = getMin((Node<T>) root.getRightChild());
                        root.setValue(temp.getValue());
                        root.setRightChild(delete((Node<T>) root.getRightChild(), temp.getValue()));
                    } else if (root.hasLeftChild()) {
                        root = (Node<T>) root.getLeftChild();
                    } else {
                        root = (Node<T>) root.getRightChild();
                    }
                }
            }
        }
        resetHeight(root);
        root = rebalancing(root, key);
        return getDoneMsg();
    }

    private Node<T> delete(Node<T> node, T key) {
        if (node == null) {
            return null;
        }
        if (node.compareTo((T) key) > 0) {
            node.setLeftChild(delete((Node<T>) node.getLeftChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else if (node.compareTo((T) key) < 0) {
            node.setRightChild(delete((Node<T>) node.getRightChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else {
            setDoneMsg(true);
            if (node.getCnt() > 1) {
                node.setCnt(node.getCnt() - 1);
            } else {
                if (!node.hasLeftChild() && !node.hasRightChild()) {
                    node = null;
                } else if (node.hasLeftChild() && node.hasRightChild()) {
                    Node<T> temp = getMin((Node<T>) node.getRightChild());
                    node.setValue(temp.getValue());
                    node.setRightChild(delete((Node<T>) node.getRightChild(), temp.getValue()));
                } else if (node.hasLeftChild()) {
                    node = (Node<T>) node.getLeftChild();
                } else {
                    node = (Node<T>) node.getRightChild();
                }
            }
        }
        return node;
    }

    @Override
    public boolean search(T key) {
        // TODO Auto-generated method stub
        resetDoneMsg();
        Node<T> child = root;
        while ((child != null) && !getDoneMsg()) {
            if (child.getValue().equals(key)) {
                setDoneMsg(true);
            } else if (child.hasLeftChild() || child.hasRightChild()) {
                if (child.compareTo(key) < 1) {
                    child = (Node<T>) child.getRightChild();
                } else {
                    child = (Node<T>) child.getLeftChild();
                }
            } else {
                child = null;
            }
        }
        return getDoneMsg();
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }

    @Override
    public INode<T> getTree() {
        // TODO Auto-generated method stub
        return root;
    }
}
