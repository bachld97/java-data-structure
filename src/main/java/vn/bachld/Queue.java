package vn.bachld;

public class Queue<Element> {
    private LinkedList<Element> queueInternal;

    public Queue() {
        this.queueInternal = new LinkedList<Element>();
    }

    public int size() {
        return queueInternal.size();
    }

    public boolean isEmpty() {
        return queueInternal == null || queueInternal.isEmpty();
    }

    public void clear() {
        if (queueInternal != null) {
            queueInternal.clear();
        }
        queueInternal = null;
    }

    public void push(Element element) {
        if (queueInternal == null) {
            queueInternal = new LinkedList<Element>();
        }
        queueInternal.insertTail(element);
    }

    public Element pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop when queue is empty.");
        }

        Element e = queueInternal.head();
        queueInternal.removeHead();
        return e;
    }

    public Element peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek when queue is empty.");
        }
        return queueInternal.head();
    }

    public boolean contains(Element element) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot search when queue is empty.");
        }

        return queueInternal.contains(element);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return queueInternal.toString();
    }
}
