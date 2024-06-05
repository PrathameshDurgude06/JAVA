package Vaildation;

import core.Item;

import java.time.LocalDate;

public class vaildate {

    public static Item creatrItem(String code, String desc , double price, String Date  ){

        LocalDate d = LocalDate.parse(Date);


        return new Item(code,desc,price,d);

    }

}
