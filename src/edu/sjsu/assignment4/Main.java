package edu.sjsu.assignment4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Driver method to play the menu option.
 *
 */
public class Main {
    /**
     * Run the menu option.
     *
     * @param args the input object.
     */
    public static void main(String[] args) {

            AppointmentManager appM = new AppointmentManager();
           do {
               String prompt = "(a) for adding an appointment;\n" +
                       "(d) for deleting an appointment;\n" +
                       "(v) for viewing all appointments;\n" +
                       "(q) for quitting the program\n" +
                       "Please choose an option: ";
            System.out.print(prompt);
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch (input) {
                case "a": System.out.print("Please enter the type (onetime, daily or monthly): ");
                    Scanner scanner = new Scanner(System.in);
                    String type = scanner.nextLine();
                    if (!isValidType(type)) System.out.println("Wrong type!");
                    System.out.print("Please enter a description: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String description = scanner1.nextLine();
                    try {
                        System.out.print("Please enter the starting date (yyyy-mm-dd): ");
                        Scanner scanner2 = new Scanner(System.in);
                        LocalDate startDate = LocalDate.parse(scanner2.nextLine());

                        System.out.print("Please enter the starting date (yyyy-mm-dd): ");
                        Scanner scanner3 = new Scanner(System.in);
                        LocalDate endDate = LocalDate.parse(scanner3.nextLine());
                        boolean flag = appM.addApp(new Appointment(description, startDate, endDate));
                        if (flag) System.out.println("Appointment added!");
                        break;
                    } catch (DateTimeException e) {
                        System.out.println("Date input is wrong format!");
                        break;
                    }
                case "d": System.out.print("Please enter the description of the appointment you want delete: ");
                    Scanner scan1 = new Scanner(System.in);
                    String desDelete = scan1.nextLine();
                    boolean flag1 = appM.deleteApp(desDelete);
                    if (flag1) System.out.println("Appointment deleted!");
                    else System.out.println("Sorry, appointment not found!");
                    break;
                case "v": if (appM.isEmpty()) System.out.println("No any appointment now.");
                    else appM.viewApp();
                    break;
                case "q": System.out.println("Thank you for using the program. Have a nice day!");
                    return;
                default:
                    System.out.println("Sorry, wrong option!\nPlease enter again!");
                    break;
            }
            } while (true);
        }

    /**
     * Check input type is correct form or not.
     *
     * @param type the object to check.
     * @return true if it correct form.
     */
    private static boolean isValidType(String type) {
        return "onetime, daily, monthly".contains(type);
    }

}
