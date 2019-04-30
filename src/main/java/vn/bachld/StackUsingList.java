package vn.bachld;

public class StackUsingList<Element> {
    LinkedList<Element> stackInternal = null;

    public StackUsingList() {
        stackInternal = new LinkedList<Element>();
    }

    public boolean isEmpty() {
        return stackInternal.isEmpty();
    }

    public int size() {
        return stackInternal.size();
    }

    public void push(Element element) {
        stackInternal.insertHead(element);
    }

    public void clear() {
        stackInternal.clear();
    }

    public Element pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop when stack is empty");
        }

        Element e = stackInternal.head();
        stackInternal.removeHead();
        return e;
    }

    public Element peek() {
        return stackInternal.head();
    }

    public boolean contains(Element element) {
        return stackInternal.contains(element);
    }
}
