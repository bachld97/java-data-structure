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

    public void clear() {

    }

    public void insertHead(Element element) {

    }

    public void removeHead() {

    }

    public void insertTail(Element element) {

    }

    public void removeTail() {

    }


    class Node<T> {
        T element;
        Node<T> nextNode;
        Node<T> previousNode;

        Node(T element, Node<T> nextNode, Node<T> previousNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
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
}
