package vn.bachld;

/*
 * Auto-balancing Binary search tree (AVL-tree)
 * This tree does not allow duplication
 */
public class BinarySearchTree <Element extends Comparable<Element>> {

    private int size = 0;
    private Node<Element> root = null;

    public int size() { return size; }

    public int depth() {
        return (int) (Math.log((double) size) / Math.log(2.0)) + 1;
    }

    public boolean isEmpty() { return root == null || size == 0; }

    public void clear() {
        // Do cleanup
        size = 0;
        root = null;
    }

    public void insert(Element element) {
        size += 1;

        if (root == null) {
            root = new Node<Element>(element, null, null);
            return;
        }

        Node<Element> parentForNode = doInsertToTree(element);
        if (parentForNode == null) {
            // Duplicated element, not inserted
            return;
        }

        if (treeIsImbalance()) {
            balanceTree();
        }
    }

    private Node<Element> doInsertToTree(Element e) {
        int compare;
        Node<Element> curNode = root;
        Node<Element> newNode = new Node<Element>(e);
        while (curNode != null &&
                (compare = e.compareTo(curNode.value)) != 0) {
            if (compare < 0) {
                if (curNode.leftChild == null) {
                    curNode.leftChild = newNode;
                    return curNode;
                } else {
                    curNode = curNode.leftChild;
                }
            } else {
                if (curNode.rightChild == null) {
                    curNode.rightChild = newNode;
                    return curNode;
                } else {
                    curNode = curNode.rightChild;
                }
            }
        }

        return null;
    }


    public boolean contains(Element element) {
        Node<Element> curNode = root;
        while (curNode != null) {
            int comparisonResult = element.compareTo(curNode.value);
            if (comparisonResult == 0)
                return true;
            else if (comparisonResult < 0)
                curNode = curNode.leftChild;
            else
                curNode = curNode.rightChild;
        }

        return false;
    }

    private boolean treeIsImbalance() {
        return false;
    }

    private void balanceTree() {

    }


    private class Node<T extends Comparable<T>> {
        T value;
        Node<T> leftChild = null;
        Node<T> rightChild = null;

        public Node(T value, Node<T> leftChild, Node<T> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public Node(T value) {
            this(value, null, null);
        }
    }
}
