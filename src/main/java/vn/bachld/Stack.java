package vn.bachld;

public class Stack<Element> {
    private LinkedList<Element> stackInternal = null;

    public Stack() {
        stackInternal = new LinkedList<Element>();
    }

    public boolean isEmpty() {
        return stackInternal == null || stackInternal.isEmpty();
    }

    public int size() {
        return stackInternal != null ? stackInternal.size() : 0;
    }

    public void push(Element element) {
        if (stackInternal == null) {
            stackInternal = new LinkedList<Element>();
        }

        stackInternal.insertHead(element);
    }

    public void clear() {
        if (stackInternal != null) {
            stackInternal.clear();
        }

        stackInternal = null;
    }

    public Element pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop when stack is empty.");
        }

        Element e = stackInternal.head();
        stackInternal.removeHead();
        return e;
    }

    public Element peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek when stack is empty.");
        }

        return stackInternal.head();
    }

    public boolean contains(Element element) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot search when stack is empty.");
        }
        return stackInternal.contains(element);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return stackInternal.toString();
    }
}
