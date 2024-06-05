package core;


import java.time.LocalDate;
import java.util.Objects;

//You can create a class Task with fields like taskId, taskName, description, taskDate, status, active.
//taskId should be unique and generated automatically.
//status should be either PENDING, IN PROGRESS or COMPLETED.
//active should be either true or false. Deleted task will have active=false
//Newly added task should have default status as PENDING and active=true
public class TasksAttribute {
    private int taskId;
    private String taskName;
    private String desc;
    private LocalDate taskDate;
    private Status status;
    private boolean active;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "TasksAttribute{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", desc='" + desc + '\'' +
                ", taskDate=" + taskDate +
                ", status=" + status +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TasksAttribute that)) return false;
        return taskId == that.taskId ;
    }

    public TasksAttribute(int taskId, String taskName, String desc, LocalDate taskDate, Status status, boolean active) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.desc = desc;
        this.taskDate = taskDate;
        this.status = status;
        this.active = active;
    }
}
