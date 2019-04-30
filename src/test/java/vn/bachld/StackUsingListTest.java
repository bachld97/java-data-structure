package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackUsingListTest {

    private StackUsingList<Integer> stack;

    @Before
    public void before() {
        stack = new StackUsingList<Integer>();
    }

    @After
    public void after() {
        stack.clear();
    }

    @Test
    public void testPushToStack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void testPopFromStack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(0), stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test (expected = IllegalStateException.class)
    public void testPopFromEmptyStack() {
        stack.pop();
    }

    @Test
    public void testPeek() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(Integer.valueOf(2), stack.peek());
        Assert.assertEquals(Integer.valueOf(2), stack.peek());
        Assert.assertEquals(3,  stack.size());
    }

    @Test
    public void testSearchForElementInStack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertTrue(stack.contains(0));
        Assert.assertTrue(stack.contains(1));
        Assert.assertTrue(stack.contains(2));
        Assert.assertTrue(stack.contains(3));
        Assert.assertTrue(stack.contains(4));
    }

    @Test
    public void testSearchForElementNotInStack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        Assert.assertFalse(stack.contains(1));
        Assert.assertFalse(stack.contains(2));
        Assert.assertFalse(stack.contains(3));
        Assert.assertFalse(stack.contains(4));
    }
}