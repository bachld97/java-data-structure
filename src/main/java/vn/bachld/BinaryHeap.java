package vn.bachld;

public class BinaryHeap<Element extends Comparable<Element>> {

    private static int DEFAULT_CAPACITY = 8;
    private DynamicArray<Element> heapInternal;
    private boolean isDescending = false;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY, false);
    }

    public BinaryHeap(boolean isDescending) {
        this(DEFAULT_CAPACITY, isDescending);
    }

    public BinaryHeap(int expectedCapacity, boolean isDescending) {
        if (expectedCapacity <= 0) {
            throw new IllegalArgumentException("The heap does not accept non-positive capacity.");
        }

        heapInternal = new DynamicArray<Element>(expectedCapacity);
        this.isDescending = isDescending;
    }

    public void clear() {
        if (heapInternal != null) {
            heapInternal.clear();
        }
        heapInternal = null;
    }

    public boolean isEmpty() {
        return heapInternal == null || heapInternal.isEmpty();
    }

    public int size() {
        if (heapInternal == null) {
            return 0;
        } else {
            return heapInternal.size();
        }
    }

    public Element peek() {
        if (isEmpty()) {
            throw  new IllegalStateException("Cannot peek into empty heap.");
        }
        return heapInternal.get(0);
    }

    public void insert(Element element) {
        if (heapInternal == null) {
            heapInternal = new DynamicArray<Element>(DEFAULT_CAPACITY);
        }
        heapInternal.insert(element);
        heapifyOnInsert();
    }

    private void heapifyOnInsert() {
        int index = heapInternal.size() - 1;
        boolean swapped = true;
        while (isNotRoot(index) && swapped) {
            int closestParentIndex = closestParentIndexFor(index);
            Element p = heapInternal.get(closestParentIndex);
            Element current = heapInternal.get(index);
            swapped = currentHigherPriorityParent(current, p);
            if (swapped) {
                heapInternal.swapAtIndices(index, closestParentIndex);
                index = closestParentIndex;
            }
        }
    }

    private boolean isNotRoot(int index) {
        return index > 0;
    }

    private int closestParentIndexFor(int index) {
        return (index - 1) / 2;
    }

    private boolean currentHigherPriorityParent(Element current, Element parent) {
        return firstHigherPrioritySecond(current, parent);
    }

    private boolean firstHigherPrioritySecond(Element first, Element second) {
        int comparisionResult = first.compareTo(second);
        if (isDescending) { comparisionResult *= -1; }
        return comparisionResult < 0;
    }

    public Element pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from empty heap.");
        }
        Element element = heapInternal.get(0);
        heapifyOnRemoval();
        return element;
    }

    private void heapifyOnRemoval() {
        int lastIndex = heapInternal.size() - 1;
        heapInternal.swapAtIndices(0, lastIndex);
        heapInternal.removeAt(lastIndex);
        int index = 0;
        boolean swapped = true;
        while (isNotLeaf(index) && swapped) {
            int childIndex = higherPriorityChildIndex(index);
            Element child = heapInternal.get(childIndex);
            Element current = heapInternal.get(index);
            swapped = firstHigherPrioritySecond(child, current);
            if (swapped) {
                heapInternal.swapAtIndices(childIndex, index);
                index = childIndex;
            }
        }
    }

    private boolean isNotLeaf(int index) {
        return (index + 1) * 2 -  1 < size();
    }

    private int higherPriorityChildIndex(int index) {
        int rightChildIndex = (index + 1) * 2;
        int leftChildIndex = rightChildIndex - 1;

        if (rightChildIndex >= size()) {
            return leftChildIndex;
        }

        Element leftChild = heapInternal.get(leftChildIndex);
        Element rightChild = heapInternal.get(rightChildIndex);
        if (firstHigherPrioritySecond(leftChild, rightChild)) {
            return leftChildIndex;
        }

        return rightChildIndex;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        return heapInternal.toString();
    }
}
