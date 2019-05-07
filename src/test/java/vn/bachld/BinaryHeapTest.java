package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {

    private BinaryHeap<Integer> ascendingHeap;
    private BinaryHeap<Integer> descendingHeap;

    @Before
    public void setUp() throws Exception {
        ascendingHeap = new BinaryHeap<Integer>();
        descendingHeap = new BinaryHeap<Integer>(true);
    }

    @After
    public void tearDown() throws Exception {
        ascendingHeap.clear();
        ascendingHeap = null;

        descendingHeap.clear();
        descendingHeap = null;
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNonPositiveCapacity() {
        BinaryHeap<Integer> h = new BinaryHeap<Integer>(-1, false);
    }

    @Test
    public void testAscendingInsertIncreaseSize() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.insert(0);
        Assert.assertEquals(1, ascendingHeap.size());
        ascendingHeap.insert(1);
        Assert.assertEquals(2, ascendingHeap.size());
        ascendingHeap.insert(2);
        Assert.assertEquals(3, ascendingHeap.size());
    }

    @Test
    public void testAscendingInsertResultCorrectOrder() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.insert(5);
        Assert.assertEquals(Integer.valueOf(5), ascendingHeap.peek());
        ascendingHeap.insert(4);
        Assert.assertEquals(Integer.valueOf(4), ascendingHeap.peek());
        ascendingHeap.insert(3);
        Assert.assertEquals(Integer.valueOf(3), ascendingHeap.peek());
        ascendingHeap.insert(2);
        Assert.assertEquals(Integer.valueOf(2), ascendingHeap.peek());
        ascendingHeap.insert(1);
        Assert.assertEquals(Integer.valueOf(1), ascendingHeap.peek());
        ascendingHeap.insert(0);
        Assert.assertEquals(Integer.valueOf(0), ascendingHeap.peek());
    }

    @Test (expected = IllegalStateException.class)
    public void testAscendingPeekWhenEmpty() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.peek();
    }

    @Test (expected = IllegalStateException.class)
    public void testAscendingRemoveWhenEmpty() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.pop();
    }

    @Test
    public void testAscendingPopDecreaseSize() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.insert(0);
        ascendingHeap.insert(1);
        ascendingHeap.insert(2);
        Assert.assertEquals(3, ascendingHeap.size());
        ascendingHeap.pop();
        Assert.assertEquals(2, ascendingHeap.size());
        ascendingHeap.pop();
        Assert.assertEquals(1, ascendingHeap.size());
        ascendingHeap.pop();
        Assert.assertEquals(0, ascendingHeap.size());
    }

    @Test
    public void testAscendingPopResultCorrectOrder() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        ascendingHeap.insert(5);
        ascendingHeap.insert(2);
        ascendingHeap.insert(1);
        ascendingHeap.insert(3);
        ascendingHeap.insert(4);
        ascendingHeap.insert(0);
        Assert.assertEquals(Integer.valueOf(0), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(1), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(2), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(3), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(4), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(5), ascendingHeap.pop());

        ascendingHeap.insert(5);
        ascendingHeap.insert(3);
        ascendingHeap.insert(2);
        ascendingHeap.insert(4);
        ascendingHeap.insert(1);
        Assert.assertEquals(Integer.valueOf(1), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(2), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(3), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(4), ascendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(5), ascendingHeap.pop());
    }

    @Test
    public void testDescendingInsertIncreaseSize() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        Assert.assertEquals(1, descendingHeap.size());
        descendingHeap.insert(1);
        Assert.assertEquals(2, descendingHeap.size());
        descendingHeap.insert(2);
        Assert.assertEquals(3, descendingHeap.size());
    }

    @Test
    public void testDescendingInsertResultCorrectOrder() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        Assert.assertEquals(Integer.valueOf(0), descendingHeap.peek());
        descendingHeap.insert(1);
        Assert.assertEquals(Integer.valueOf(1), descendingHeap.peek());
        descendingHeap.insert(2);
        Assert.assertEquals(Integer.valueOf(2), descendingHeap.peek());
        descendingHeap.insert(3);
        Assert.assertEquals(Integer.valueOf(3), descendingHeap.peek());
        descendingHeap.insert(4);
        Assert.assertEquals(Integer.valueOf(4), descendingHeap.peek());
        descendingHeap.insert(5);
        Assert.assertEquals(Integer.valueOf(5), descendingHeap.peek());
    }

    @Test (expected = IllegalStateException.class)
    public void testDescendingPeekWhenEmpty() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.peek();
    }

    @Test (expected = IllegalStateException.class)
    public void testDescendingRemoveWhenEmpty() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.pop();
    }

    @Test
    public void testDescendingPopDecreaseSize() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        descendingHeap.insert(1);
        descendingHeap.insert(2);
        Assert.assertEquals(3, descendingHeap.size());
        descendingHeap.pop();
        Assert.assertEquals(2, descendingHeap.size());
        descendingHeap.pop();
        Assert.assertEquals(1, descendingHeap.size());
        descendingHeap.pop();
        Assert.assertEquals(0, descendingHeap.size());
    }

    @Test
    public void testDescendingPopResultCorrectOrder() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        descendingHeap.insert(2);
        descendingHeap.insert(1);
        descendingHeap.insert(4);
        descendingHeap.insert(3);
        descendingHeap.insert(5);
        Assert.assertEquals(Integer.valueOf(5), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(4), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(3), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(2), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(1), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(0), descendingHeap.pop());

        descendingHeap.insert(5);
        descendingHeap.insert(3);
        descendingHeap.insert(2);
        descendingHeap.insert(4);
        descendingHeap.insert(1);
        Assert.assertEquals(Integer.valueOf(5), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(4), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(3), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(2), descendingHeap.pop());
        Assert.assertEquals(Integer.valueOf(1), descendingHeap.pop());
    }

    @Test
    public void testClearHeapIsEmpty() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        descendingHeap.insert(1);
        descendingHeap.insert(2);
        descendingHeap.insert(3);
        descendingHeap.insert(4);
        descendingHeap.insert(5);
        descendingHeap.clear();
        Assert.assertTrue(descendingHeap.isEmpty());
        assertEquals(0, descendingHeap.size());
    }

    @Test
    public void testClearThenReuseHeap() {
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        descendingHeap.insert(1);
        descendingHeap.clear();
        Assert.assertTrue(descendingHeap.isEmpty());
        descendingHeap.insert(0);
        descendingHeap.insert(1);
        Assert.assertEquals(2, descendingHeap.size());
    }

    @Test
    public void testToString() {
        Assert.assertTrue(ascendingHeap.isEmpty());
        Assert.assertEquals("[]", ascendingHeap.toString());
        ascendingHeap.insert(5);
        Assert.assertEquals("[5]", ascendingHeap.toString());
        ascendingHeap.insert(3);
        Assert.assertEquals("[3, 5]", ascendingHeap.toString());
        ascendingHeap.insert(2);
        Assert.assertEquals("[2, 5, 3]", ascendingHeap.toString());
        ascendingHeap.insert(4);
        Assert.assertEquals("[2, 4, 3, 5]", ascendingHeap.toString());
        ascendingHeap.insert(1);
        Assert.assertEquals("[1, 2, 3, 5, 4]", ascendingHeap.toString());
        ascendingHeap.pop();
        Assert.assertEquals("[2, 4, 3, 5]", ascendingHeap.toString());
        ascendingHeap.pop();
        Assert.assertEquals("[3, 4, 5]", ascendingHeap.toString());
        ascendingHeap.pop();
        Assert.assertEquals("[4, 5]", ascendingHeap.toString());
        ascendingHeap.pop();
        Assert.assertEquals("[5]", ascendingHeap.toString());
        ascendingHeap.pop();
        Assert.assertEquals("[]", ascendingHeap.toString());
    }
}