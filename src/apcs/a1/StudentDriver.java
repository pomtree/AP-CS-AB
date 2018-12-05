package apcs.a1;

import java.util.Scanner;

public class StudentDriver {
    public static void main(String args[]) {
        System.out.println("How many students would you like to process?");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Student students[] = new Student[num];
        char choice = '.';
        while (choice != 'Q') {
            System.out.println("Enter L to (L)oad Student info\n" +
                    "Enter M to (M)odify Student info\n" +
                    "Enter P to (P)rint Student info\n" +
                    "Enter Q to quit");
            choice = scanner.next().toUpperCase().charAt(0);
            while (!"LMPQ".contains(choice + "")) {
                System.out.println("Invalid Input." +
                        "Enter L to (L)oad Student info\n" +
                        "Enter M to (M)odify Student info\n" +
                        "Enter P to (P)rint Student info\n" +
                        "Enter Q to quit");
                choice = scanner.next().toUpperCase().charAt(0);
            }
            if (choice == 'L') {
                System.out.println("Loading Students...");
                for (int i = 0; i < num; i++) {
                    String last_name, first_name, street, city, phone;
                    int zip;
                    double gpa;
                    System.out.println("Student " + (i + 1) + ":");
                    System.out.print("Enter last name:");
                    scanner.nextLine();
                    last_name = scanner.nextLine();
                    System.out.print("Enter first name:");
                    first_name = scanner.nextLine();
                    System.out.print("Enter street:");
                    street = scanner.nextLine();
                    System.out.print("Enter city:");
                    city = scanner.nextLine();
                    System.out.print("Enter zip:");
                    zip = scanner.nextInt();
                    System.out.print("Enter phone:");
                    phone = scanner.next();
                    System.out.print("Enter GPA:");
                    gpa = scanner.nextDouble();
                    students[i] = new Student(last_name, first_name, street, city, phone, zip, gpa, i);
                    System.out.println();

                }
                for (Student s : students) {
                    System.out.println(s.toString());
                }

            } else if (choice == 'M') {
                System.out.println("Modifying Students...");
            } else if (choice == 'P') {
                System.out.println("Printing Students...");
            }
        }
        System.out.println("Goodbye.");


    }
}
