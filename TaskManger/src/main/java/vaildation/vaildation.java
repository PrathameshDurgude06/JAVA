package vaildation;

import core.Status;
import core.TasksAttribute;

import java.time.LocalDate;

public class vaildation {
    public static int  taskId= 1;

    //  private String taskName;
    //    private String desc;
    //    private LocalDate taskDate;
    //    private Status status;
    //    private boolean active;
    public static TasksAttribute createTask (String taskName,String desc , String date, String status ){
        LocalDate d =dateParsing(date);
        Status a = enumParsing(status);



        return new TasksAttribute(taskId++,taskName,desc,d,a,true);


    }
    public static LocalDate dateParsing(String date ){
        return LocalDate.parse(date);

    }
    public static Status enumParsing (String enums)
    {
        return Status.valueOf(enums.toUpperCase());
    }
    public static boolean cheackActive (Status a){
        if(Status.PENDING == a){
            return true;
        }
        return false;
    }

}
