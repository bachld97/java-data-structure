package vn.bachld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class DynamicArrayTest {

    DynamicArray<Integer> dynamicArray ;

    @Before
    public void before() {
        dynamicArray = new DynamicArray<Integer>();
    }

    @After
    public void after() {
        dynamicArray.clear();
        dynamicArray = null;
    }

    @Test
    public void testInsertItemAndGetSize() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        dynamicArray.insert(1);
        dynamicArray.insert(2);
        Assert.assertEquals(3, dynamicArray.size());
    }

    @Test
    public void testGetSetItem() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        dynamicArray.insert(1);
        Assert.assertEquals(Integer.valueOf(0), dynamicArray.get(0));
        Assert.assertEquals(Integer.valueOf(1), dynamicArray.get(1));

        dynamicArray.set(1, 0);
        dynamicArray.set(0, 1);
        Assert.assertEquals(Integer.valueOf(1), dynamicArray.get(0));
        Assert.assertEquals(Integer.valueOf(0), dynamicArray.get(1));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSetIndexOutOfBound() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        dynamicArray.set(1, 1);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testSetAtIndexWhenArrayEmpty() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.set(0, 0);
    }

    @Test
    public void testAppendStaticArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        Integer[] toInsert = { 0, 1, 2 };
        dynamicArray.insertAll(toInsert);
        Assert.assertEquals(3, dynamicArray.size());
        Assert.assertEquals(Integer.valueOf(0), dynamicArray.get(0));
        Assert.assertEquals(Integer.valueOf(1), dynamicArray.get(1));
        Assert.assertEquals(Integer.valueOf(2), dynamicArray.get(2));
    }

    @Test
    public void testAppendHugeStaticArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        Integer[] toInsert = new Integer[100];
        for (int i = 0; i < 100; ++i) {
            toInsert[i] = i;
        }
        dynamicArray.insertAll(toInsert);
        Assert.assertEquals(100, dynamicArray.size());
        for (int i = 0; i < 100; ++i) {
            Assert.assertEquals(Integer.valueOf(i), dynamicArray.get(i));
        }
    }

    @Test
    public void testAppendDynamicArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        DynamicArray<Integer> other = new DynamicArray<Integer>();
        other.insert(0);
        other.insert(1);
        other.insert(2);
        dynamicArray.mergeWith(other);
        Assert.assertEquals(3, dynamicArray.size());
        Assert.assertEquals(Integer.valueOf(0), dynamicArray.get(0));
        Assert.assertEquals(Integer.valueOf(1), dynamicArray.get(1));
        Assert.assertEquals(Integer.valueOf(2), dynamicArray.get(2));
    }

    @Test
    public void testAppendHugeDynamicArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        DynamicArray<Integer> other = new DynamicArray<Integer>();
        for (int i = 0; i < 100; ++i) {
            other.insert(i);
        }
        dynamicArray.mergeWith(other);
        for (int i = 0; i < 100; ++i) {
            Assert.assertEquals(Integer.valueOf(i), dynamicArray.get(i));
        }
        Assert.assertEquals(100, dynamicArray.size());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNullItem() {
        dynamicArray.remove(null);
    }

    @Test
    public void testRemoveItemNotInList() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        Assert.assertEquals(1, dynamicArray.size());
        dynamicArray.remove(1);
        Assert.assertEquals(1, dynamicArray.size());
    }

    @Test
    public void testRemoveItemInList() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        Assert.assertEquals(1, dynamicArray.size());
        dynamicArray.remove(0);
        Assert.assertEquals(0, dynamicArray.size());
        Assert.assertTrue(dynamicArray.isEmpty());
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetIndexOutOfBound() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insert(0);
        dynamicArray.get(1);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetAtIndexWhenArrayEmpty() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.get(0);
    }

    @Test
    public void testRemoveItemAtValidIndex() {
        Assert.assertTrue(dynamicArray.isEmpty());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveItemAtZeroWhenEmpty() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.removeAt(0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveItemAtNegativeIndex() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.removeAt(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveItemAtIndexEqualToLength() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        dynamicArray.removeAt(dynamicArray.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveItemAtIndexGreaterThanLength() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        dynamicArray.removeAt(dynamicArray.size() + 1);
    }

    @Test
    public void testRemoveItemAtIndexWhenArrayHasOneItem() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] {0});
        dynamicArray.removeAt(0);
        Assert.assertEquals(0, dynamicArray.size());
    }

    @Test
    public void testRemoveItemAtIndexSuccessfully() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] {0, 1, 2, 3});
        dynamicArray.removeAt(0);
        dynamicArray.removeAt(0);
        dynamicArray.removeAt(0);
        dynamicArray.removeAt(0);
        Assert.assertEquals(0, dynamicArray.size());
    }

    @Test
    public void testArrayContainsElement() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        Assert.assertTrue(dynamicArray.contains(0));
        Assert.assertTrue(dynamicArray.contains(1));
        Assert.assertTrue(dynamicArray.contains(2));
    }

    @Test
    public void testArrayDoesNotContainElement() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        Assert.assertFalse(dynamicArray.contains(3));
    }

    @Test
    public void testIndexOfElementInArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        Assert.assertEquals(0, dynamicArray.indexOf(0));
        Assert.assertEquals(1, dynamicArray.indexOf(1));
        Assert.assertEquals(2, dynamicArray.indexOf(2));
    }

    @Test
    public void testIndexOfDuplicatedElement() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 0, 0 });
        Assert.assertEquals(0, dynamicArray.indexOf(0));
    }

    @Test
    public void testIndexOfElementNotInArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[] { 0, 1, 2 });
        Assert.assertEquals(-1, dynamicArray.indexOf(3));
    }

    @Test
    public void testClearArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        dynamicArray.clear();
        Assert.assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void testToString() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", dynamicArray.toString());
        dynamicArray.clear();
        Assert.assertEquals("[]", dynamicArray.toString());
    }

    @Test
    public void testIterator() {
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.insertAll(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int index = 0;
        for (Integer element : dynamicArray) {
            Assert.assertEquals(dynamicArray.get(index), element);
            index++;
        }
        Assert.assertEquals(index, dynamicArray.size());
    }


    @Test
    public void testIteratorOnEmptyArray() {
        Assert.assertTrue(dynamicArray.isEmpty());
        int index = 0;
        for (Integer ignored : dynamicArray) {
            index++;
        }
        Assert.assertEquals(index, 0);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testIteratorDoesNotSupportRemove() {
        Iterator<Integer> it = dynamicArray.iterator();
        it.remove();
    }
}
