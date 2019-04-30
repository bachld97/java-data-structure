package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void before() {
        queue = new Queue<Integer>();
    }

    @After
    public void after() {
        queue.clear();
        queue = null;
    }

    @Test (expected = IllegalStateException.class)
    public void testPopWhenQueueIsEmpty() {
        Assert.assertTrue(queue.isEmpty());
        queue.pop();
    }

    @Test (expected = IllegalStateException.class)
    public void testSearchWhenQueueIsEmpty() {
        Assert.assertTrue(queue.isEmpty());
        queue.contains(0);
    }

    @Test (expected = IllegalStateException.class)
    public void testPeekWhenQueueIsEmpty() {
        Assert.assertTrue(queue.isEmpty());
        queue.peek();
    }

    @Test
    public void testSearchElementInQueue() {
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertTrue(queue.contains(0));
        Assert.assertTrue(queue.contains(1));
        Assert.assertTrue(queue.contains(2));
        Assert.assertTrue(queue.contains(3));
    }

    @Test
    public void testSearchElementNotInQueue() {
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertFalse(queue.contains(4));
    }

    @Test
    public void testPushIntoQueue() {
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        Assert.assertEquals(1, queue.size());
        queue.push(1);
        Assert.assertEquals(2, queue.size());
        queue.push(2);
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void testPopAndPeekFromQueue() {
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        Assert.assertEquals(1, queue.size());
        queue.push(1);
        Assert.assertEquals(2, queue.size());
        queue.push(2);
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(Integer.valueOf(0), queue.peek());
        Assert.assertEquals(Integer.valueOf(0), queue.pop());
        Assert.assertEquals(Integer.valueOf(1), queue.peek());
        Assert.assertEquals(Integer.valueOf(1), queue.pop());
        Assert.assertEquals(Integer.valueOf(2), queue.peek());
        Assert.assertEquals(Integer.valueOf(2), queue.pop());
    }

    @Test
    public void testToString() {
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals("[]", queue.toString());
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertEquals("[0, 1, 2, 3]", queue.toString());
    }

    @Test
    public void testClearQueue() {
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.clear();
        Assert.assertTrue(queue.isEmpty());
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertEquals("[0, 1, 2, 3]", queue.toString());
    }
}