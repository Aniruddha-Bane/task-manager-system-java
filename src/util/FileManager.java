package util;

import model.Task;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String DATA_DIR = "data";
    private static final String FILE_PATH =
            "data/tasks.txt";

    /*
     * Creates data folder and tasks.txt
     * if they do not exist.
     */
    public static void initializeStorage() {

        try {

            File directory =
                    new File(DATA_DIR);

            if (!directory.exists()) {

                directory.mkdir();
            }

            File file =
                    new File(FILE_PATH);

            if (!file.exists()) {

                file.createNewFile();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error initializing storage.");

            e.printStackTrace();
        }
    }

    /*
     * Save all tasks to file.
     */
    public static void saveTasks(
            ArrayList<Task> tasks) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_PATH))) {

            for (Task task : tasks) {

                writer.write(
                        task.toFileString());

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving tasks.");

            e.printStackTrace();
        }
    }

    /*
     * Load tasks from file.
     */
    public static ArrayList<Task> loadTasks() {

        ArrayList<Task> tasks =
                new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_PATH))) {

            String line;

            while ((line =
                    reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }

                Task task =
                        Task.fromFileString(
                                line);

                if (task != null) {

                    tasks.add(task);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading tasks.");

            e.printStackTrace();
        }

        return tasks;
    }
}