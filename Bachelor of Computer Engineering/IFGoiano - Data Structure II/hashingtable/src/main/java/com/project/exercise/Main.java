package com.project.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.model.HashTable;
import com.project.model.Node;
import com.project.service.HashList;
import com.project.service.IHashing;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IHashing<Student> hashingService = new HashList<Student>();
        HashTable<Student> hashTable = hashingService.createHashTable(15);

        int option;
        do {
            option = getMenuOption(scanner);
            
            switch (option) {
                case 1:
                    registerStudent(scanner, hashingService, hashTable);
                    
                    break;
                case 2:
                    List<Student> approvedStudents = findApprovedStudents(hashTable);
                    
                    displaySearchResult("Approved Students:", approvedStudents);
                    
                    break;
                case 3:
                    List<Student> allStudents = findAllStudents(hashTable);
                    
                    displaySearchResult("All Students:", allStudents);
                    
                    break;
                case 4:
                    System.out.println("Exiting...");
                    
                    break;
                default:
                    System.out.println("Invalid option!");
                    
                    break;
            }
        } while (option != 4);

        scanner.close();
    }

    static int getMenuOption(Scanner scanner) {
        System.out.println("================================================================");
        System.out.println("Menu:");
        System.out.println("1 - Register student.");
        System.out.println("2 - Find approved students.");
        System.out.println("3 - Find all students.");
        System.out.println("4 - Exit.");
        System.out.print("Choose an option: ");
        
        int option;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            option = 0;
        }

        System.out.println("================================================================");

        return option;
    }

    static void registerStudent(Scanner scanner, IHashing<Student> hashingService, HashTable<Student> hashTable) {
        try {
            System.out.print("Enter student code: ");
            int code = scanner.nextInt();

            System.out.print("Enter student name: ");
            String name = scanner.next();

            System.out.print("Enter student final grade: ");
            double finalGrade = scanner.nextDouble();

            if (finalGrade < 0.0 || finalGrade > 10.0) throw new IllegalArgumentException();

            boolean inserted = hashingService.insert(hashTable, new Student(code, name, finalGrade));
            
            if (inserted) {
                System.out.println("\nStudent registered successfully!");
            } else {
                System.out.println("\nAn error occurred while registering the student!");
            }

        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input! Make sure to enter numbers correctly.");
            scanner.next();

        } catch (IllegalArgumentException e) {
            System.out.println("\nInvalid input! Final grade must be between 0.0 and 10.0.");
        }
    }

    static List<Student> findApprovedStudents(HashTable<Student> hashTable) {
        List<Student> list = new ArrayList<>();

        for (Node<Student> node : hashTable.getItems()) {
            while (node.getNext() != null) {
                Student student = node.getValue();

                if (student.getFinalGrade() >= 7.0) {
                    list.add(student);
                }

                node = node.getNext();
            }
        }

        return list;
    }

    static List<Student> findAllStudents(HashTable<Student> hashTable) {
        List<Student> list = new ArrayList<>();

        for (Node<Student> node : hashTable.getItems()) {
            while (node.getNext() != null) {
                list.add(node.getValue());

                node = node.getNext();
            }
        }

        return list;
    }

    static void displaySearchResult(String title, List<Student> students) {
        System.out.println(title);

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}