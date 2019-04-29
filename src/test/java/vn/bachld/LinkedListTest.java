package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void before() {
        this.list = new LinkedList<Integer>();
    }

    @After
    public void after() {
        this.list.clear();
        this.list = null;
    }

    @Test
    public void testInsertAtTail() {
        list.insertTail(0);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(Integer.valueOf(0), list.tail());
        list.insertTail(1);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.tail());
        list.insertTail(2);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(2), list.tail());
    }

    @Test
    public void testInsertAtHead() {
        list.insertHead(0);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(Integer.valueOf(0), list.head());
        list.insertHead(1);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.head());
        list.insertHead(2);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(Integer.valueOf(2), list.head());
    }

    @Test
    public void testRemoveHead() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        Assert.assertEquals(3, list.size());
        list.removeHead();
        Assert.assertEquals(Integer.valueOf(1), list.head());
        Assert.assertEquals(2, list.size());
        list.removeHead();
        Assert.assertEquals(Integer.valueOf(0), list.head());
        Assert.assertEquals(1, list.size());
        list.removeHead();
        Assert.assertNull(list.head());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveTail() {
        list.insertTail(0);
        list.insertTail(1);
        list.insertTail(2);
        Assert.assertEquals(3, list.size());
        list.removeTail();
        Assert.assertEquals(Integer.valueOf(1), list.tail());
        Assert.assertEquals(2, list.size());
        list.removeTail();
        Assert.assertEquals(Integer.valueOf(0), list.tail());
        Assert.assertEquals(1, list.size());
        list.removeTail();
        Assert.assertNull(list.tail());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testHeadAndTailTheSameListOneElement() {
        list.insertTail(1);
        Assert.assertEquals(list.head(), list.tail());
    }

    @Test
    public void testRemoveWhenListIsEmpty() {
        list.removeHead();
        Assert.assertEquals(0, list.size());
        list.removeTail();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testRemoveElementNotInList() {
        list.insertTail(0);
        list.insertTail(1);
        Assert.assertTrue(list.removeElement(0));
        Assert.assertTrue(list.removeElement(1));
        Assert.assertFalse(list.removeElement(0));
        Assert.assertFalse(list.removeElement(1));
    }


    @Test
    public void testSearchElementInLinkedList() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertHead(4);
        Assert.assertEquals(5, list.size());
        Assert.assertTrue(list.contains(0));
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(4));
    }

    @Test
    public void testSearchElementNotInLinkedList() {
        list.insertHead(0);
        Assert.assertFalse(list.contains(1));
    }

    @Test
    public void testRemoveOneElement() {
        list.insertHead(0);
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);
        list.insertHead(1);
        Assert.assertEquals(5, list.size());
        Assert.assertTrue(list.removeElement(0));
        Assert.assertEquals(4, list.size());
        Assert.assertTrue(list.removeElement(1));
        Assert.assertEquals(3, list.size());
        Assert.assertTrue(list.removeElement(2));
        Assert.assertEquals(2, list.size());
        Assert.assertTrue(list.removeElement(3));
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void testRemoveElementAtTail() {
        list.insertTail(0);
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        list.insertTail(5);
        list.insertTail(6);
        list.insertTail(7);
        for (int i = 7; i >= 0; --i) {
            Assert.assertTrue(list.removeElement(i));
            Assert.assertEquals(i, list.size());
        }
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveAllMatched() {
        list.insertHead(0);
        list.insertHead(0);
        list.insertHead(0);
        list.insertHead(0);
        list.insertHead(0);
        Assert.assertEquals(5, list.removeAllMatchedElement(0));
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(0));
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", list.toString());
        list.insertTail(0);
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        list.insertTail(5);
        list.insertTail(6);
        list.insertTail(7);
        Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7]", list.toString());
        list.removeElement(2);
        list.removeElement(4);
        list.removeElement(7);
        Assert.assertEquals("[0, 1, 3, 5, 6]", list.toString());
    }

    @Test
    public void testGetFirstAndLast() {
        Assert.assertNull(list.head());
        Assert.assertNull(list.tail());
        list.insertTail(0);
        Assert.assertEquals(Integer.valueOf(0), list.head());
        Assert.assertEquals(Integer.valueOf(0), list.tail());
    }
}
