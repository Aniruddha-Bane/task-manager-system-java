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

        taskService.viewTasks();
    }
}