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
                        "TODO",
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
                        "TODO",
                        "HIGH"));

        System.out.println("\nALL TASKS:");
        taskService.viewTasks();

        System.out.println("\nSEARCHING TASK ID 2...");

        Task foundTask =
                taskService.searchTask(2);

        if (foundTask != null) {

            System.out.println(
                    "\nTask Found:");

            System.out.println(foundTask);

        } else {

            System.out.println(
                    "Task not found.");
        }
    }
}