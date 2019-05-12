package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree;

    @Before
    public void before() {
        tree = new BinarySearchTree<Integer>();
    }

    @After
    public void after() {
        tree.clear();
        tree = null;
    }

    @Test
    public void testEmptyTree() {
        Assert.assertTrue(tree.isEmpty());
        Assert.assertEquals(0, tree.size());
    }

    @Test
    public void testInsertElement() {
        Assert.assertTrue(tree.isEmpty());
        tree.insert(0);
        Assert.assertFalse(tree.isEmpty());
        Assert.assertEquals(1, tree.size());
        Assert.assertEquals(1, tree.depth());

        tree.insert(1);
        Assert.assertFalse(tree.isEmpty());
        Assert.assertEquals(2, tree.size());
        Assert.assertEquals(2, tree.depth());

        tree.insert(2);
        Assert.assertFalse(tree.isEmpty());
        Assert.assertEquals(3, tree.size());
        Assert.assertEquals(2, tree.depth());
    }

    @Test
    public void testFindElement() {
        tree.insert(0);
        Assert.assertTrue(tree.contains(0));
        tree.insert(1);
        Assert.assertTrue(tree.contains(1));
        tree.insert(2);
        Assert.assertTrue(tree.contains(2));
        tree.insert(3);
        Assert.assertTrue(tree.contains(3));
    }
}