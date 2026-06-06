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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\nTask ID : " + taskId +
                "\nTitle : " + title +
                "\nDescription : " + description +
                "\nStatus : " + status +
                "\nPriority : " + priority +
                "\n------------------------";
    }
}