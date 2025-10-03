/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prld5121w.assignment1;

/**
 * In this program, we will be managing a class of 10 learners, storing their names and test marks in parallel arrays, categorizing their results, and calculating class statistics.
 * 
 *
 * @author Chumisa Haya
 */

import java.util.Scanner;

public class PRLD5121wAssignment1 {

    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        
        String[] names = new String[10];    // This Array will store the learners names
        int[] marks = new int[10];          // and this Array stores the learner's test marks
        
        // Display program purpose
        System.out.println("=== CLASS REPORTs ===");
        System.out.println("Please enter data for 10 learners");
        System.out.println("Marks must be between 0 and 100");
        System.out.println("=================================");
        
        // Input data for all 10 learners
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Learner " + (i + 1) + " ---");
            
            // Input learner name
            System.out.print("Enter name: ");
            names[i] = input.nextLine();
            
  // Input and validate mark (must be between 0-100)
            boolean validMark = false;
            while (!validMark) {
                System.out.print("Enter mark for " + names[i] + ": ");
                marks[i] = input.nextInt();
                input.nextLine(); // Clear the input buffer
                
                // Check if mark is valid
                if (marks[i] >= 0 && marks[i] <= 100) {
                    validMark = true; // Mark is valid, exit loop
                } else {
                    System.out.println("ERROR: Mark must be between 0 and 100. Please re-enter.");
                }
            }
        }        // Display the class report
        displayClassReport(names, marks);
        
        // Close scanner to prevent resource leak
        input.close();
    }
    
    /**
     * Displays the complete class report including names, marks, categories,
     * average mark, highest and lowest achievers.
     * 
     * @param names Array containing learner names
     * @param marks Array containing corresponding marks
     */
    public static void displayClassReport(String[] names, int[] marks) {
        // Display report header
        System.out.println("\n\n==============================================");
        System.out.println("                 CLASS REPORT");
        System.out.println("==============================================");
        System.out.printf("%-15s %-15s %-12s%n", "NAME", "MARK ACHIEVED", "CATEGORY");
        System.out.println("----------------------------------------------");

       // Variables for statistics
        int totalMarks = 0;
        int highestMark = marks[0];
        int lowestMark = marks[0];
        String highestName = names[0];
        String lowestName = names[0];
        
        // Process each learner and display their data
        for (int i = 0; i < 10; i++) {
            // Add to total for average calculation
            totalMarks += marks[i];
            
            // Determine result category
            String category = determineCategory(marks[i]);
            
            // Display learner data in formatted columns
            System.out.printf("%-15s %-15d %-12s%n", names[i], marks[i], category);
            
            // Check for highest mark
            if (marks[i] > highestMark) {
                highestMark = marks[i];
                highestName = names[i];
            } 
  // Check for lowest mark
            if (marks[i] < lowestMark) {
                lowestMark = marks[i];
                lowestName = names[i];
            }
        }
        
        // Calculate average mark
        double averageMark = (double) totalMarks / 10;
        
        // Display statistics
        System.out.println("==============================================");
        System.out.printf("AVERAGE CLASS MARK: %.1f%%%n", averageMark);
        System.out.println("HIGHEST MARK: " + highestName);
        System.out.println("LOWEST MARK: " + lowestName);
    }
     /**
     * Determines the result category based on the mark.
     * 
     * @param mark The student's test mark
     * @return The category as a string: "Distinction", "Pass", or "Fail"
     */
    public static String determineCategory(int mark) {
        if (mark >= 75) {
            return "Distinction";
        } else if (mark >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
}
