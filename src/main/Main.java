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

        System.out.println(
                "\nBefore Update:");

        taskService.viewTasks();

        boolean updated =
                taskService.updateTaskStatus(
                        1,
                        "IN_PROGRESS");

        if (updated) {

            System.out.println(
                    "\nStatus Updated Successfully");

        } else {

            System.out.println(
                    "\nTask Not Found");
        }

        System.out.println(
                "\nAfter Update:");

        taskService.viewTasks();
    }
}