package vn.bachld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    }

    @Test
    public void testInsertAtHead() {

    }
}