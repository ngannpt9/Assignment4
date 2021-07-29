package edu.sjsu.assignment4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class will test methods in MyCollections class.
 *
 */
public class MyCollectionsTest {

    /**
     * This method will test downsize.
     *
     */
    @Test
    public void testDownsize() {
        String[] s = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        List<String> l = Arrays.asList(s);
        LinkedList<String> actual = new LinkedList<>(l);
        MyCollections.downsize(actual, 3);

        String[] s1 = {"Tom", "Bob", "Alice", "Trudy", "Denny"};
        List<String> l1 = Arrays.asList(s1);
        LinkedList<String> expect = new LinkedList<>(l1);
        Assert.assertEquals(expect, actual);

    }
    /**
     * This method will test isBalanced.
     *
     */
    @Test
    public void testIsBalanced () {
        boolean actual = MyCollections.isBalanced("[](3*5)^2");
        assertEquals(true, actual);
    }

}