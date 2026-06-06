package model;

public class Task {

    private int taskId;
    private String title;
    private String description;
    private String status;
    private String priority;

    public Task(int taskId,
                String title,
                String description,
                String status,
                String priority) {

        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description) {

        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(
            String priority) {

        this.priority = priority;
    }

    @Override
    public String toString() {

        return "\n=========================" +
                "\nTask ID     : " + taskId +
                "\nTitle       : " + title +
                "\nDescription : " + description +
                "\nStatus      : " + status +
                "\nPriority    : " + priority +
                "\n=========================";
    }

    /*
     * Used for file storage
     * Format:
     * id,title,description,status,priority
     */
    public String toFileString() {

        return taskId + "," +
                title + "," +
                description + "," +
                status + "," +
                priority;
    }

    /*
     * Used while loading data
     * from tasks.txt
     */
    public static Task fromFileString(
            String line) {

        String[] data =
                line.split(",");

        if (data.length != 5) {

            return null;
        }

        return new Task(
                Integer.parseInt(data[0]),
                data[1],
                data[2],
                data[3],
                data[4]
        );
    }
}