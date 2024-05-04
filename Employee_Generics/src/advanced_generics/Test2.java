package advanced_generics;
import static utils.GenericUtils.printAllElements;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test2 {

	public static void main(String[] args) {
		//integer list
		List<Integer> intList=Arrays.asList(1,2,3,4,5,7,8);
		printAllElements(intList);
		TreeSet<LocalDate> dates=new TreeSet<>();
		dates.add(LocalDate.of(1990, 10, 20));
		dates.add(LocalDate.of(1997, 10, 20));
		dates.add(LocalDate.of(1978, 10, 20));
		printAllElements(dates);

	}

}
