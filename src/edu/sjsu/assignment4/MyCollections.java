package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class have methods use Collection Framework.
 *
 * @author Ngan Nguyen
 * github page: https://ngannpt9.github.io/Assignment4/
 */
public class MyCollections {
    /**
     * Driver method to checking.
     *
     * @param args the object to checking.
     */
    public static void main(String[] args) {
        String[] s = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        List<String> l = Arrays.asList(s);
        LinkedList<String> e = new LinkedList<>(l);
        downsize(e, 3);
        System.out.println(e);

//        System.out.println(isBalanced("System.out.println(list.get(0))"));
//        System.out.println(isBalanced("[](3*5)^2"));
//        System.out.println(isBalanced("[(2+3]*5)^2"));
//        System.out.println(isBalanced("System.out.println(list.get(0)"));
//        System.out.println(isBalanced("[(3*5)]^2]"));
    }

    /**
     * This method use queue to print a collection of files.
     *
     * @param files the object to print.
     */
    public static void printFiles(Queue<File> files) {
        while (!files.isEmpty()) {
            File current = files.peek();
            printFile(current);
            files.poll();
        }
    }

    /**
     * This method will read and print the files.
     *
     * @param file the object to read.
     */
    private static void printFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            System.out.println("***");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    /**
     * This methods use a list iterator to go over the collection
     * and remove elements.
     *
     * @param employees the object of a collection.
     * @param n the object to keep track the original indexes.
     */
    public static void downsize(LinkedList<String> employees, int n) {
        ListIterator<String> iterator = employees.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % n == 0)
                iterator.remove();
            index++;
        }
    }

    /**
     * This methods use stack to check if the parentheses are balanced.
     *
     * @param expression the input object.
     * @return the resulting after checking.
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack  = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '[' || c == '(') {
                stack.push(c);
            }  else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}