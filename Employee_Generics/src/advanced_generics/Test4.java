package advanced_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		// Testing generic method
		// create fixed size list of integers : 10,20,30,40,50
		List<Integer> intList = Arrays.asList(10, 20, 30, 40, 50);// auto boxing
		System.out.println(intList);
		// shuffle the list n print contents again
		Collections.shuffle(intList);
		// string list
		List<String> stringList = new ArrayList<>
		(Arrays.asList("one", "two", "three"));
		stringList.add(0,"ten");
		System.out.println(stringList);
		//shuffle n print
		Collections.shuffle(stringList);
		System.out.println(stringList);

	}

}
