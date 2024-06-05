package Utils;

import core.Status;
import core.TasksAttribute;

import java.util.ArrayList;

public class ListUtils {

    public static ArrayList<TasksAttribute> populateList(){
        ArrayList<TasksAttribute>list = new ArrayList<>();
        list.add(vaildation.vaildation.createTask("Gym","Exercise","2024-06-07","pending"));
        list.add(vaildation.vaildation.createTask("Dsa","coding","2024-06-04","pending"));
        list.add(vaildation.vaildation.createTask("Movie","Pushpa 2","2024-08-07","pending"));
        list.add(vaildation.vaildation.createTask("project","cda","2024-10-07","pending"));

        return list;
    }
    public static void removeFromList(int id , ArrayList<TasksAttribute>list ){

        list.removeIf(i ->i.getTaskId() == id);
        System.out.println("Successfully");
      }

      public static  void updateStatus (int id , ArrayList<TasksAttribute>list, Status a) {
        list.stream().filter(i -> i.getTaskId() == id).forEach(i -> i.setStatus(a));
          list.stream().filter(i -> i.getTaskId() == id).forEach(i -> i.setActive(false));


        System.out.println("Successfully");

      }


}
