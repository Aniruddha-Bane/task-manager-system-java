package service;

import model.Task;
import util.FileManager;

import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> tasks;

    public TaskService() {

        FileManager.initializeStorage();

        tasks =
                FileManager.loadTasks();
    }

    /*
     * CREATE
     */
    public boolean addTask(Task task) {

        for (Task existingTask : tasks) {

            if (existingTask.getTaskId()
                    == task.getTaskId()) {

                return false;
            }
        }

        tasks.add(task);

        FileManager.saveTasks(tasks);

        return true;
    }

    /*
     * READ ALL
     */
    public void viewTasks() {

        if (tasks.isEmpty()) {

            System.out.println(
                    "\nNo tasks available.");

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

    /*
     * SEARCH
     */
    public Task searchTask(int taskId) {

        for (Task task : tasks) {

            if (task.getTaskId()
                    == taskId) {

                return task;
            }
        }

        return null;
    }

    /*
     * UPDATE STATUS
     */
    public boolean updateTaskStatus(
            int taskId,
            String newStatus) {

        Task task =
                searchTask(taskId);

        if (task == null) {

            return false;
        }

        task.setStatus(
                newStatus.toUpperCase());

        FileManager.saveTasks(tasks);

        return true;
    }

    /*
     * DELETE
     */
    public boolean deleteTask(
            int taskId) {

        Task task =
                searchTask(taskId);

        if (task == null) {

            return false;
        }

        tasks.remove(task);

        FileManager.saveTasks(tasks);

        return true;
    }

    /*
     * REPORTS
     */
    public void generateReport() {

        int totalTasks =
                tasks.size();

        int todoCount = 0;
        int inProgressCount = 0;
        int doneCount = 0;

        for (Task task : tasks) {

            String status =
                    task.getStatus();

            if (status.equalsIgnoreCase(
                    "TODO")) {

                todoCount++;

            } else if (status.equalsIgnoreCase(
                    "IN_PROGRESS")) {

                inProgressCount++;

            } else if (status.equalsIgnoreCase(
                    "DONE")) {

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

        System.out.printf(
                "Completion Rate   : %.2f%%\n",
                completionRate);
    }

    /*
     * VALIDATION
     */
    public boolean isValidStatus(
            String status) {

        return status.equalsIgnoreCase(
                "TODO")
                ||
                status.equalsIgnoreCase(
                        "IN_PROGRESS")
                ||
                status.equalsIgnoreCase(
                        "DONE");
    }

    /*
     * TOTAL TASKS
     */
    public int getTaskCount() {

        return tasks.size();
    }

    /*
     * GET ALL TASKS
     */
    public ArrayList<Task> getTasks() {

        return tasks;
    }
}