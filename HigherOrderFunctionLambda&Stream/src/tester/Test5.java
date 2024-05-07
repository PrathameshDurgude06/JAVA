package tester;

import java.util.Comparator;
import java.util.Map;
import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import com.app.core.Student;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Student>studMap=populateMap(populateList());
		
		//Display all student details(list) sorted as per GPA 
		Comparator<Student>comp=(s1,s2) -> {
			return ((Double)s1.getGpa()).compareTo(s2.getGpa());
		};
		
		studMap.values().stream().sorted(comp).forEach(s -> System.out.println("Students are Sorted as per GPA: "+s ));
	}

}
