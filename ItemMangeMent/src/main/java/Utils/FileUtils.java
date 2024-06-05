package Utils;

import Vaildation.vaildate;
import core.Item;

import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<Item> populateList (){
      ArrayList<Item>list = new ArrayList<>();
      list.add(vaildate.creatrItem("pens","Writing",20,"2024-09-08"));
        list.add(vaildate.creatrItem("toys","Playing",200,"2024-06-01"));
        list.add(vaildate.creatrItem("mobile","communication",500000,"2024-12-02"));
        list.add(vaildate.creatrItem("Bed","sleep",20,"2021-02-08"));



        return list;
    }


}
