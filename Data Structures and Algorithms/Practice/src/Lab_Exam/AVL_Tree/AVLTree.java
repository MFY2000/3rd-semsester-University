package Lab_Exam.AVL_Tree;

public class AVLTree {
    private Node root;
    private Boolean duplication, doneMsg;

    public AVLTree(Boolean duplication) {
        root=null;
        doneMsg = false;
        this.duplication = duplication;
    }
    int getHeight(Node node) { return node == null ? 0 :node.getHeight(); }
    int getMax(int first, int second) {
        return (first > second) ? first : second;
    }
    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return (getHeight((Node) node.getLeftChild()) - getHeight((Node) node.getRightChild()));
    }
    Node rightRotate(Node y) {
        Node x = (Node) y.getLeftChild();
        Node t2 = (Node) x.getRightChild();

        x.setRightChild(y);
        y.setLeftChild(t2);

        y.setHeight(1 + getMax(getHeight((Node) y.getLeftChild()), getHeight((Node) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node) x.getLeftChild()), getHeight((Node) x.getRightChild())));

        return x;
    }
    Node leftRotate(Node y) {
        Node x = (Node) y.getRightChild();
        Node t2 = (Node) x.getLeftChild();

        x.setLeftChild(y);
        y.setRightChild(t2);

        y.setHeight(1 + getMax(getHeight((Node) y.getLeftChild()), getHeight((Node) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node) x.getLeftChild()), getHeight((Node) x.getRightChild())));

        return x;
    }
    public Boolean getDoneMsg() { return doneMsg; }
    public void setDoneMsg(Boolean doneMsg) { this.doneMsg = doneMsg; }
    public void resetDoneMsg() { doneMsg = false; }
    public void inOrder(){
        inOrder(root);
    }
    void inOrder(Node node) {
        if (node != null) {
            inOrder((Node) node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrder((Node) node.getRightChild());
        }
    }
    public void insert(String key) {
        resetDoneMsg();
        if (root == null) {
            setDoneMsg(true);
            root = new Node(key);
        } else {
            System.out.println((root.getValue()).compareTo(key));
            if (root.compareToo(key) > 0) {
                root.setLeftChild(insert((Node) root.getLeftChild(), key));
            } else if (root.compareToo(key) < 0) {
                root.setRightChild(insert((Node) root.getRightChild(), key));
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
    private Node insert(Node node,String key) {
        if (node == null) {
            setDoneMsg(true);
            return new Node(key);
        }
        if (node.compareToo(key) > 0) {
            node.setLeftChild(insert((Node) node.getLeftChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else if (node.compareToo(key) < 0) {
            node.setRightChild(insert((Node) node.getRightChild(), key));
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
    private void resetHeight(Node node) {
        if (node != null) {
            node.setHeight(1 + getMax(getHeight((Node) node.getLeftChild()),getHeight((Node) node.getRightChild())));
        }
    }
    private Node rebalancing(Node node, String key) {
        if (node != null) {
            int balance = getBalance(node);

            if (balance > 1 && node.hasLeftChild() && node.getLeftChild().compareToo(key) > 0)
                node = rightRotate(node);

            if (balance < -1 && node.hasRightChild() && node.getRightChild().compareToo(key) < 0)
                node = leftRotate(node);

            if (balance > 1 && node.hasLeftChild() && node.getLeftChild().compareToo(key) < 0) {
                node.setLeftChild(leftRotate((Node) node.getLeftChild()));
                node = rightRotate(node);
            }

            if (balance < -1 && node.hasRightChild() && node.getRightChild().compareToo(key) > 0) {
                node.setRightChild(rightRotate((Node) node.getRightChild()));
                node = leftRotate(node);
            }
        }
        return node;
    }
    private Node getMin(Node node) {
        Node minNode = node;
        while (minNode.hasLeftChild()) {
            minNode = (Node) minNode.getLeftChild();
        }
        return minNode;
    }
    public boolean delete(String key) {
        resetDoneMsg();
        if (root == null) {
            return getDoneMsg();
        } else {
            if (root.compareToo(key) > 0) {
                root.setLeftChild(delete((Node) root.getLeftChild(), key));
            } else if (root.compareToo(key) < 0) {
                root.setRightChild(delete((Node) root.getRightChild(), key));
            } else {
                setDoneMsg(true);
                if (root.getCnt() > 1) {
                    root.setCnt(root.getCnt() - 1);
                } else {
                    if (!root.hasLeftChild() && !root.hasRightChild()) {
                        root = null;
                    } else if (root.hasLeftChild() && root.hasRightChild()) {
                        Node temp = getMin((Node) root.getRightChild());
                        root.setValue(temp.getValue());
                        root.setRightChild(delete((Node) root.getRightChild(), temp.getValue()));
                    } else if (root.hasLeftChild()) {
                        root = (Node) root.getLeftChild();
                    } else {
                        root = (Node) root.getRightChild();
                    }
                }
            }
        }
        resetHeight(root);
        root = rebalancing(root, key);
        return getDoneMsg();
    }
    private Node delete(Node node,String key) {
        if (node == null) {
            return null;
        }
        if (node.compareToo(key) > 0) {
            node.setLeftChild(delete((Node) node.getLeftChild(), key));
            resetHeight(node);
            node = rebalancing(node, key);
        } else if (node.compareToo(key) < 0) {
            node.setRightChild(delete((Node) node.getRightChild(), key));
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
                    Node temp = getMin((Node) node.getRightChild());
                    node.setValue(temp.getValue());
                    node.setRightChild(delete((Node) node.getRightChild(), temp.getValue()));
                } else if (node.hasLeftChild()) {
                    node = (Node) node.getLeftChild();
                } else {
                    node = (Node) node.getRightChild();
                }
            }
        }
        return node;
    }
    public boolean search(String key) {
        resetDoneMsg();
        Node child = root;
        while ((child != null) && !getDoneMsg()) {
            if (child.getValue().equals(key)) {
                setDoneMsg(true);
            } else if (child.hasLeftChild() || child.hasRightChild()) {
                if (child.compareToo(key) < 1) {
                    child = (Node) child.getRightChild();
                } else {
                    child = (Node) child.getLeftChild();
                }
            } else {
                child = null;
            }
        }
        return getDoneMsg();
    }
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }
    public Node getTree() {
        return root;
    }
}
