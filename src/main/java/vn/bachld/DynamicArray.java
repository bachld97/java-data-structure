package vn.bachld;


import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<Element> implements Iterable<Element>  {
    private int capacity;
    private int length;
    private Element[] elements;

    public DynamicArray() {
        this(8);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        elements = (Element[]) new Object[capacity];
    }

    public int size() { return length; }
    public boolean isEmpty() { return length == 0; }

    public void clear() {
        for (int i = 0; i < capacity; ++i) {
            elements[i] = null;
        }
        length = 0;
    }

    public Element get(int index) {
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void set(Element element, int index) {
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    public void insert(Element element) {
        if (length + 1 > capacity) {
            capacity *= 2;

            Element[] newElements = (Element[]) new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, length);
            elements = newElements;
        }

        elements[length++] = element;
    }

    public void insertAll(Element[] elements) {
        int lengthIncrement = elements.length;
        while (length + lengthIncrement > capacity) {
            capacity *= 2;
        }
        Element[] newElements = (Element[]) new Object[capacity];
        System.arraycopy(this.elements, 0, newElements, 0, length);
        System.arraycopy(elements, 0, newElements, length, lengthIncrement);
        this.elements = newElements;
        length += lengthIncrement;
    }

    public void mergeWith(DynamicArray<Element> otherArray) {
        int lengthIncrement = otherArray.size();
        while (length + lengthIncrement > capacity) {
            capacity *= 2;
        }
        Element[] newElements = (Element[]) new Object[capacity];
        System.arraycopy(this.elements, 0, newElements, 0, length);
        System.arraycopy(otherArray.elements, 0, newElements, length, lengthIncrement);
        elements = newElements;
        length += lengthIncrement;
    }

    public void remove(Element element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAt(index);
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (length > 1) {
            System.arraycopy(elements, index + 1, elements, index, length - 1 - index);
        }
        elements[length - 1] = null;
        length -= 1;
    }

    public boolean contains(Element element) {
        return indexOf(element) != -1;
    }

    public int indexOf(Element element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot remove null element");
        }

        for (int i = 0; i < length; ++i) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<Element> iterator() {
        return new Iterator<Element>() {
            int index = 0;

            public boolean hasNext() {
                return index < length;
            }

            public Element next() {
                return elements[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void swapAtIndices(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= length || index2 >= length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Array length: ");
            sb.append(length);
            sb.append(" - Requested indices: ");
            sb.append(index1);
            sb.append(" and ");
            sb.append(index2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }

        Element tem = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = tem;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < length - 1; ++i) {
            sb.append(elements[i]);
            sb.append(", ");
        }
        sb.append(elements[length - 1]);
        sb.append("]");
        return sb.toString();
    }
}
