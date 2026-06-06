package service;

import model.Task;
import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    // CREATE
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

    // READ ALL
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

    // SEARCH
    public Task searchTask(int taskId) {

        for (Task task : tasks) {

            if (task.getTaskId() == taskId) {

                return task;
            }
        }

        return null;
    }

    // UPDATE
    public boolean updateTaskStatus(
            int taskId,
            String newStatus) {

        Task task =
                searchTask(taskId);

        if (task == null) {

            return false;
        }

        task.setStatus(newStatus);

        return true;
    }

    // DELETE
    public boolean deleteTask(int taskId) {

        Task task =
                searchTask(taskId);

        if (task == null) {

            return false;
        }

        tasks.remove(task);

        return true;
    }

    // REPORTS
    public void generateReport() {

        int totalTasks = tasks.size();

        int todoCount = 0;
        int inProgressCount = 0;
        int doneCount = 0;

        for (Task task : tasks) {

            if (task.getStatus().equals("TODO")) {

                todoCount++;

            } else if (task.getStatus()
                    .equals("IN_PROGRESS")) {

                inProgressCount++;

            } else if (task.getStatus()
                    .equals("DONE")) {

                doneCount++;
            }
        }

        double completionRate = 0;

        if (totalTasks > 0) {

            completionRate =
                    ((double) doneCount
                            / totalTasks) * 100;
        }

        System.out.println(
                "\n=========================");
        System.out.println(
                "      TASK REPORT");
        System.out.println(
                "=========================");

        System.out.println(
                "Total Tasks       : "
                        + totalTasks);

        System.out.println(
                "TODO Tasks        : "
                        + todoCount);

        System.out.println(
                "IN_PROGRESS Tasks : "
                        + inProgressCount);

        System.out.println(
                "DONE Tasks        : "
                        + doneCount);

        System.out.println(
                "Completion Rate   : "
                        + completionRate + "%");
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}