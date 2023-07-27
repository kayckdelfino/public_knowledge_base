/*
You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.

Input Format
The first line of input contains an integer N, representing the total number of students. The next N lines contains a list of student information in the following structure:

ID Name CGPA

Constraints
- 2 <= N <= 1000
- 0 <= ID <= 100000
- 5 <= |Name| <= 30
- 0 <= CGPA <= 4.00

The name contains only lowercase English letters. The ID contains only integer numbers without leading zeros. The CGPA will contain, at most, 2 digits after the decimal point.

Output Format
After rearranging the students according to the above rules, print the first name of each student on a separate line.

Sample Input
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Sample Output
Ashis
Fahim
Samara
Samiha
Rumpa
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        if (cgpa != other.cgpa) {
            return Double.compare(other.cgpa, cgpa);
        } else if (!name.equals(other.name)) {
            return name.compareTo(other.name);
        } else {
            return Integer.compare(id, other.id);
        }
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            students.add(new Student(id, name, cgpa));
        }
        sc.close();

        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}