import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task {
    private int taskID;
    private String taskName;
    private String taskDescription;
    private boolean isTaskCompleted;
    static int counter;

    public Task(String taskName , String taskDescription ){
        this.taskName=taskName;
        this.taskDescription=taskDescription;
        this.taskID=  ++counter;
    }

    public void setTaskID(int taskID){
        this.taskID=taskID;
    }
    public void setTaskName(String taskName){
        this.taskName=taskName;
    }
    public void setTaskDescription(String taskDescription){
        this.taskDescription=taskDescription;
    }
    public void setTaskCompleted(boolean taskCompleted){
        this.isTaskCompleted=taskCompleted;
    }

    public String getTaskName(){
        return taskName;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    public int getTaskID(){
        return taskID;
    }
    public int getCounter(){
        return counter;
    }

    public boolean isTaskCompleted() {
        return isTaskCompleted;
    }

}

class Todo{
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addTask(){
        System.out.println("Enter Task name :");
        String name = sc.nextLine();
        System.out.println("Enter Task Description :");
        String description = sc.nextLine();
        Task task = new Task(name , description);
        tasks.add(task);
        System.out.println("Task has been added successfully");

    }
}
