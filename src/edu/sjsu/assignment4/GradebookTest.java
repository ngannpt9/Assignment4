package edu.sjsu.assignment4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class will test methods in Gradebook class.
 *
 */
public class GradebookTest {
    public Gradebook grade = new Gradebook();

    /**
     * This method will test add student.
     */
    @Test
    public void testAddStudent() {
        boolean actual = grade.addStudent(1, "Bob", 'B');
        assertEquals(true, actual);
    }

    /**
     * This method will test delete student.
     *
     */
    @Test
    public void testDeleteStudent() {
    this.grade.addStudent(1, "Bob", 'B');
    boolean actual = grade.deleteStudent(1);
    assertEquals(true, actual);
    }

    /**
     * This method will test update grade.
     *
     */
    @Test
    public void testUpdateGrade() {
        grade.addStudent(1, "Bob", 'B');
        boolean actual = grade.updateGrade(1, 'A');
        assertEquals(true, actual);
    }
}