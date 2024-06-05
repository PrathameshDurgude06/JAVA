package Tester;

import Utils.FileUtils;
import core.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(Scanner sc = new Scanner(System.in); ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("saveData.ser")) ){
            ArrayList<Item>list = FileUtils.populateList();

            boolean exit = false;

            try{
                while(!exit){
                    System.out.println("1 : sort by code & store , 2 : sort by price & store ");
                    switch (sc.nextInt()){
                        case 0 : {
                            exit = true;
                            break;
                        }
                        case 1 : {
                            Comparator<Item>Lambda = (i,j) -> i.getCode().compareTo(j.getCode());
                            list.stream().sorted(Lambda).forEach(i -> System.out.println(i));
                            list.forEach(i -> {
                                try {
                                    fos.writeObject(i);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });

                            break;
                        }
                        case 2 : {
                            Comparator<Item>Lambda = (i,j) -> i.getShipmentDate().compareTo(j.getShipmentDate());
                            list.stream().sorted(Lambda).forEach(i -> System.out.println(i));

                            break;
                        }
                        case 3 : {
                            list.forEach(i -> System.out.println(i));
                            break;
                        }
                    }


                }
            }
            catch (Exception a){
                System.out.println(a.getMessage());
            }





        }
        catch (IOException a){
            System.out.println(a.getMessage());
        }

    }
}
