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
                    "\n=================================");
            System.out.println(
                    "      TASK MANAGER SYSTEM");
            System.out.println(
                    "=================================");

            System.out.println(
                    "1. Add Task");
            System.out.println(
                    "2. View Tasks");
            System.out.println(
                    "3. Search Task");
            System.out.println(
                    "4. Update Task Status");
            System.out.println(
                    "5. Delete Task");
            System.out.println(
                    "6. Generate Report");
            System.out.println(
                    "7. Exit");

            System.out.print(
                    "\nEnter Choice: ");

            while (!sc.hasNextInt()) {

                System.out.print(
                        "Invalid input. Enter number: ");

                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    addTask(sc, taskService);
                    break;

                case 2:

                    taskService.viewTasks();
                    break;

                case 3:

                    searchTask(sc, taskService);
                    break;

                case 4:

                    updateTask(sc, taskService);
                    break;

                case 5:

                    deleteTask(sc, taskService);
                    break;

                case 6:

                    taskService.generateReport();
                    break;

                case 7:

                    System.out.println(
                            "\nSaving and Exiting...");
                    break;

                default:

                    System.out.println(
                            "\nInvalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }

    /*
     * ADD TASK
     */
    private static void addTask(
            Scanner sc,
            TaskService taskService) {

        System.out.print(
                "\nEnter Task ID: ");

        int taskId =
                sc.nextInt();

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
                "Enter Priority (LOW/MEDIUM/HIGH): ");

        String priority =
                sc.nextLine();

        Task task =
                new Task(
                        taskId,
                        title,
                        description,
                        "TODO",
                        priority.toUpperCase());

        boolean added =
                taskService.addTask(task);

        if (added) {

            System.out.println(
                    "\nTask Added Successfully.");

        } else {

            System.out.println(
                    "\nTask ID Already Exists.");
        }
    }

    /*
     * SEARCH TASK
     */
    private static void searchTask(
            Scanner sc,
            TaskService taskService) {

        System.out.print(
                "\nEnter Task ID: ");

        int taskId =
                sc.nextInt();

        Task task =
                taskService.searchTask(
                        taskId);

        if (task != null) {

            System.out.println(task);

        } else {

            System.out.println(
                    "\nTask Not Found.");
        }
    }

    /*
     * UPDATE STATUS
     */
    private static void updateTask(
            Scanner sc,
            TaskService taskService) {

        System.out.print(
                "\nEnter Task ID: ");

        int taskId =
                sc.nextInt();

        sc.nextLine();

        System.out.print(
                "Enter New Status (TODO/IN_PROGRESS/DONE): ");

        String status =
                sc.nextLine();

        if (!taskService.isValidStatus(
                status)) {

            System.out.println(
                    "\nInvalid Status.");

            return;
        }

        boolean updated =
                taskService.updateTaskStatus(
                        taskId,
                        status);

        if (updated) {

            System.out.println(
                    "\nTask Updated Successfully.");

        } else {

            System.out.println(
                    "\nTask Not Found.");
        }
    }

    /*
     * DELETE TASK
     */
    private static void deleteTask(
            Scanner sc,
            TaskService taskService) {

        System.out.print(
                "\nEnter Task ID: ");

        int taskId =
                sc.nextInt();

        boolean deleted =
                taskService.deleteTask(
                        taskId);

        if (deleted) {

            System.out.println(
                    "\nTask Deleted Successfully.");

        } else {

            System.out.println(
                    "\nTask Not Found.");
        }
    }
}