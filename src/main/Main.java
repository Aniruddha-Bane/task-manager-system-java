package main;

import model.Task;
import service.TaskService;

public class Main {

    public static void main(String[] args) {

        TaskService taskService =
                new TaskService();

        taskService.addTask(
                new Task(
                        1,
                        "Learn Java",
                        "Practice OOP",
                        "DONE",
                        "HIGH"));

        taskService.addTask(
                new Task(
                        2,
                        "Learn Collections",
                        "Practice ArrayList",
                        "TODO",
                        "MEDIUM"));

        taskService.addTask(
                new Task(
                        3,
                        "Build Project",
                        "Task Manager System",
                        "IN_PROGRESS",
                        "HIGH"));

        taskService.addTask(
                new Task(
                        4,
                        "Learn Git",
                        "Push code to GitHub",
                        "DONE",
                        "LOW"));

        System.out.println("\nALL TASKS");
        taskService.viewTasks();

        System.out.println("\nSEARCH TASK ID 2");

        Task foundTask =
                taskService.searchTask(2);

        if (foundTask != null) {

            System.out.println(foundTask);

        } else {

            System.out.println(
                    "Task not found.");
        }

        System.out.println(
                "\nUPDATE STATUS OF TASK 2");

        taskService.updateTaskStatus(
                2,
                "IN_PROGRESS");

        taskService.viewTasks();

        System.out.println(
                "\nDELETE TASK 3");

        taskService.deleteTask(3);

        taskService.viewTasks();

        System.out.println(
                "\nGENERATE REPORT");

        taskService.generateReport();
    }
}