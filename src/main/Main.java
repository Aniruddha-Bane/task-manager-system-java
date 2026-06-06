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

        System.out.println(
                "\nBefore Delete:");

        taskService.viewTasks();

        boolean deleted =
                taskService.deleteTask(2);

        if (deleted) {

            System.out.println(
                    "\nTask Deleted Successfully");

        } else {

            System.out.println(
                    "\nTask Not Found");
        }

        System.out.println(
                "\nAfter Delete:");

        taskService.viewTasks();
    }
}