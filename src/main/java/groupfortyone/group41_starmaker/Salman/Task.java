package groupfortyone.group41_starmaker.Salman;

import java.util.ArrayList;

public class Task {
    private String employeeName;
    private String task;

    public static ArrayList<Task> taskList = new ArrayList<>();

    public Task(String employeeName, String task) {
        this.employeeName = employeeName;
        this.task = task;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "employeeName='" + employeeName + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
