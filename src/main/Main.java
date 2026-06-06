package main;

import model.Task;
import service.TaskService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskService taskService =
                new TaskService();

        int choice;

        do {

            System.out.println(
                    "\n=========================");
            System.out.println(
                    " TASK MANAGER SYSTEM");
            System.out.println(
                    "=========================");

            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Update Status");
            System.out.println("5. Delete Task");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");

            System.out.print(
                    "\nEnter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print(
                            "Enter Title: ");
                    String title =
                            sc.nextLine();

                    System.out.print(
                            "Enter Description: ");
                    String description =
                            sc.nextLine();

                    System.out.print(
                            "Enter Priority: ");
                    String priority =
                            sc.nextLine();

                    Task task =
                            new Task(
                                    id,
                                    title,
                                    description,
                                    "TODO",
                                    priority);

                    taskService.addTask(task);

                    break;

                case 2:

                    taskService.viewTasks();

                    break;

                case 7:

                    System.out.println(
                            "\nExiting Application...");

                    break;

                default:

                    System.out.println(
                            "Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}