package vn.bachld;

import java.util.Iterator;

public class LinkedList<Element> implements Iterable<Element> {

    private int length = 0;
    private Node<Element> headNode;
    private Node<Element> tailNode;

    public LinkedList() {
        this.headNode = null;
        this.tailNode = null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    public Element tail() {
        return tailNode != null ? tailNode.element : null;
    }

    public Element head() {
        return headNode != null ? headNode.element : null;
    }

    public void clear() {
        Node<Element> currentNode = headNode;
        headNode = null;
        tailNode = null;
        while (currentNode != null) {
            currentNode = currentNode.nextNode;
        }
    }

    public void insertHead(Element element) {
        length += 1;
        Node<Element> newNode = new Node<Element>(element, null, headNode);
        if (headNode == null || tailNode == null) {
            headNode = tailNode = newNode;
        } else {
            headNode.previousNode = newNode;
            headNode = newNode;
        }
    }

    public void removeHead() {
        if (headNode != null && headNode.nextNode != null) {
            headNode = headNode.nextNode;
            headNode.previousNode = null;
        } else {
            headNode = tailNode = null;
        }
        length = Math.max(0, length - 1);
    }

    public void insertTail(Element element) {
        length += 1;
        Node<Element> newNode = new Node<Element>(element, tailNode, null);
        if (headNode == null || tailNode == null) {
            headNode = tailNode = newNode;
        } else {
            tailNode.nextNode = newNode;
            tailNode = newNode;
        }
    }

    public void removeTail() {
        if (tailNode != null && tailNode.previousNode != null) {
            tailNode = tailNode.previousNode;
            tailNode.nextNode = null;
        } else {
            headNode = tailNode = null;
        }

        length = Math.max(0, length - 1);
    }

    public boolean contains(Element element) {
        Node<Element> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.element == element) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int removeAllMatchedElement(Element element) {
        return 0;
    }

    public boolean removeElement(Element element) {
        Node<Element> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.element == element) {
                this.removeNode(currentNode);
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    private void removeNode(Node<Element> node) {
        if (node == headNode) {
            removeHead();
        } else if (node == tailNode) {
            removeTail();
        } else {
            node.previousNode.nextNode = node.nextNode;
            node.nextNode.previousNode = node.previousNode;
            length -= 1;
        }
    }

    class Node<T> {
        T element;
        Node<T> nextNode;
        Node<T> previousNode;

        Node(T element, Node<T> previousNode, Node<T> nextNode) {
            this.element = element;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

    public Iterator<Element> iterator() {
        return new Iterator<Element>() {
            public boolean hasNext() {
                return false;
            }

            public Element next() {
                return null;
            }

            public void remove() {
                return;
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<Element> currentNode = headNode;
        while (currentNode != tailNode) {
            sb.append(currentNode.element);
            sb.append(", ");
        }
        sb.append(currentNode.element);
        sb.append("]");
        return sb.toString();
    }
}
