package edu.sjsu.assignment4;

import java.util.Map;
import java.util.Objects;

/**
 * This class will keep the information of students.
 *
 */
public class Student implements Comparable<Student> {
    private int id;
    private String name;

    /**
     * Constructor of student clas
     *
     * @param id the id of student.
     * @param name the name of student.
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor take only id.
     *
     * @param id the id of student.
     */
    public Student(int id) {
        this.id = id;
        this.name = "Unnamed";
    }

    /**
     * Getter for student id.
     *
     * @return student id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for student name.
     *
     * @return student name.
     */
    public String getName() {
        return name;
    }

    /**
     * Compare between the inputs.
     *
     * @param o the object to compare.
     * @return the resulting after compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    /**
     * Hashing the inputs.
     *
     * @return the resulting of hashing.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Compare by the natural order, and sort the id first.
     *
     * @param o the object to compare.
     * @return the resulting after compare.
     */
    @Override
    public int compareTo(Student o) {
        if (this.getId() != o.getId()) return this.getId() - o.getId();
        else return this.getName().compareTo(o.getName());
    }

    /**
     * Print the resulting for comparable.
     *
     * @return the resulting of comparable.
     */
    @Override
    public String toString() {
        return id + "." + name + ": ";
    }
}
