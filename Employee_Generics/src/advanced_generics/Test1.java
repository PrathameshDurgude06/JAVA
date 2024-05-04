package advanced_generics;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// Testing generic method
		//create fixed size list of integers : 10,20,30,40,50
		List<Integer> intList=Arrays.asList(10,20,30,40,50);//auto boxing
		System.out.println(intList);
		intList.set(0,12345);
		System.out.println(intList);
		//create fixed size list of doubles
		List<Double> doubleList=Arrays.asList(10.0,20.67,30.567,
				40.12,50.0);
		System.out.println(doubleList);

	}

}
