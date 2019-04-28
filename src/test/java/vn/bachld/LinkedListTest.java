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
}