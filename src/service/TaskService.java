package service;

import model.Task;
import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {

        for (Task existingTask : tasks) {

            if (existingTask.getTaskId()
                    == task.getTaskId()) {

                System.out.println(
                        "Task ID already exists.");

                return;
            }
        }

        tasks.add(task);

        System.out.println(
                "Task added successfully.");
    }

    public void viewTasks() {

        if (tasks.isEmpty()) {

            System.out.println(
                    "No tasks available.");

            return;
        }

        System.out.println(
                "\n=========================");
        System.out.println(
                "       TASK LIST");
        System.out.println(
                "=========================");

        for (Task task : tasks) {

            System.out.println(task);
        }
    }

    public Task searchTask(int taskId) {

        for (Task task : tasks) {

            if (task.getTaskId() == taskId) {

                return task;
            }
        }

        return null;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}