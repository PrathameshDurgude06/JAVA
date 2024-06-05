package Tester;

import Utils.ListUtils;
import core.Status;
import core.TasksAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        try( Scanner sc = new Scanner(System.in)){
           ArrayList <TasksAttribute> task = ListUtils.populateList();
           boolean exit = false;
           try{

               while(!exit){
                   System.out.println("Choose options : 0 : Exit , 1: Create Task , 2 : Delete Task , 3 : Display all Tasks , 4 : Display All PendingTask  " +
                           "5 : all pending task for Today  6 : sort by date 7 : update Task Status  "  );
                   switch (sc.nextInt()){
                       case 0 : {
                           exit = true;
                           break;
                       }
                       case 1 : {
                           //String taskName,String desc , String date, String status
                           System.out.println("Enter the taskName taskDescription, Date , Status");
                           task.add(vaildation.vaildation.createTask(sc.next(), sc.next(), sc.next(), sc.next()));
                           break;
                       }
                       case 2 : {
                           System.out.println("Enter task Id ");
                           ListUtils.removeFromList(sc.nextInt(),task);
                           break;
                       }
                       case 3 : {
                           task.forEach(i -> System.out.println(i.getTaskId()+" "+i.getTaskName()+" "+i.getTaskDate()));
                           break;
                       }
                       case 4 : {
                           task.stream().filter(i ->i.getStatus() == Status.PENDING).forEach(i -> System.out.println(i));
                           break;
                       }
                       case 5 : {
                           task.stream().filter(i ->i.getStatus() == Status.PENDING).filter(i -> i.getTaskDate().equals(LocalDate.now())).forEach(i -> System.out.println(i));

                           break;
                       }
                       case 6 : {
                           Comparator<TasksAttribute>lambda = (i,j) -> i.getTaskDate().compareTo(j.getTaskDate());

                           task.stream().sorted(lambda).forEach(i -> System.out.println(i));

                           break;

                       }
                       case 7 : {
                           System.out.println("Enter the task id ");
                           int id =sc.nextInt();
                           System.out.println(" 1 : in_progress 2 : Completed ");
                           switch (sc.nextInt()){
                               case 1 : {
                                   ListUtils.updateStatus(id,task,Status.COMPLETED);
                                   break;
                               }
                               case 2 :{
                                   ListUtils.updateStatus(id,task,Status.IN_PROGRESS);
                                   break;
                               }


                           }
                           break;


                       }
                   }

               }




           }
           catch(Exception a){
               System.out.println(a.getMessage());
           }




       }
        catch (Exception a){
            System.out.println(a.getMessage());
        }



    }
}
