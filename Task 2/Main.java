import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int Subjects = scanner.nextInt();
        
        int[] marks = new int[Subjects];
        
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < Subjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        double percentage = totalMarks / Subjects;
        
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + " out of " + (Subjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Grade: " + grade);
    }
}
