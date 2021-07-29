package edu.sjsu.assignment4;

import java.util.*;

/**
 * This class manages a collection of students.
 *
 */
public class Gradebook extends HashMap<Student, Character> {
    /**
     * Add a student with the id, name and grade to the map.
     *
     * @param id    the student id.
     * @param name  the student name.
     * @param grade the student grade.
     * @return true if add successfully.
     */
    public boolean addStudent(int id, String name, char grade) {
        Student student = new Student(id, name);

        if (this.containsKey(student)) return false;
        else if (isValidGrade(grade)) this.put(student, grade);
        else this.put(student, 'N');
        return true;
    }

    /**
     * This method will check the grade input is correct form or not.
     *
     * @param grade the input grade.
     * @return true if the input grade correct form.
     */
    private boolean isValidGrade(char grade) {
        return "ABCDF".contains(String.valueOf(grade));
    }

    /**
     * Add a student with the id, name and grade to the map.
     *
     * @param id   the student id.
     * @param name the student name.
     * @return true if add successfully.
     */
    public boolean addStudent(int id, String name) {
        return addStudent(id, name, 'N');
    }

    /**
     * Delete the corresponding student with the id from the map.
     *
     * @param id the object to remove.
     * @return true if removed successfully.
     */
    public boolean deleteStudent(int id) {
        Student student = new Student(id);
        if (this.containsKey(student)) {
            this.remove(student);
            return true;
        } else return false;
    }

    /**
     * Find the corresponding student with the id from the map, and update the grade.
     *
     * @param id       the id need to find.
     * @param newGrade the grade need to update.
     * @return true if update successfully
     */
    public boolean updateGrade(int id, char newGrade) {
        Student student = new Student(id);
        if (this.containsKey(student) && isValidGrade(newGrade)) {
            this.replace(student, newGrade);
            return true;
        } else return false;
    }

    /**
     * Print the students with the grade, sort by the order based on the comparator.
     *
     * @param comparator the order based on the comparator
     */
    public void printGrade(Comparator<Student> comparator) {
        List<Student> stu = new ArrayList<>(this.keySet());
        Collections.sort(stu, comparator);
        LinkedHashMap<Student, Character> sortedMap = new LinkedHashMap<>();
        for (Student students : stu) {
            sortedMap.put(students, this.get(students));
        }
        for (Map.Entry<Student, Character> e : sortedMap.entrySet()) {
            System.out.println(e.getKey().toString() + e.getValue());
        }
    }
}
