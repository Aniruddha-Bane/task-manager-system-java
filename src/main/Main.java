package main;

import model.Task;
import service.TaskService;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
    Task task1 = new Task(1,"Learn Java collections",
            "Practice ArrayList","TODO","HIGH");

    taskService.addTask(task1);
    }
}
