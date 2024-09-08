package com.ust.tolist;

import java.util.Scanner;

public class TodoListApp {
    
    private static String[] tasks = new String[10];
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add a Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Remove a Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    
    private static void addTask(Scanner scanner) {
        if (taskCount >= tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }
        System.out.print("Enter a task: ");
        String task = scanner.nextLine();
        tasks[taskCount] = task;
        taskCount++;
        System.out.println("Task added successfully.");
    }

  
    private static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Task List ---");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }

    
    private static void removeTask(Scanner scanner) {
        if (taskCount == 0) {
            System.out.println("No tasks to remove.");
            return;
        }
        System.out.print("Enter the task number to remove: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber < 1 || taskNumber > taskCount) {
            System.out.println("Invalid task number.");
        } else {
            for (int i = taskNumber - 1; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[taskCount - 1] = null;  // Clear last task
            taskCount--;
            System.out.println("Task removed successfully.");
        }
    }
}
