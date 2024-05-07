package tester;
import static utils.StudentCollectionUtils.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.app.core.Student;

class Test1 {

	public static void main(String[] args) {
		
		List<Student>list=populateList();
		// 1.1 Display all student details from a student list
		list.forEach(s -> System.out.println(s));
		
		//get student map
		Map<String,Student>map=populateMap(list);
		//1.2  Display all student details(Student roll no n gpa)from a student map
		map.forEach((k,v) -> System.out.println("Roll no "+v.getRollNo()+" GPA "+v.getGpa()));

		//1.3 Display all student details(from the list) sorted as per GPA (desc order)
		
//		Comparator<Student>studComp=(s1,s2) -> {
//			if(s1.getGpa()< s2.getGpa())
//				return 1;
//			if(s1.getGpa() > s2.getGpa())
//				return -1;
//			return 0;
//		};
		
		//using compare to --typecast prim double into Double then use compareTo
		Comparator<Student>studComp=(s1,s2) -> {
			return ((Double)s1.getGpa()).compareTo(s2.getGpa());
		};
		Collections.sort(list,studComp);
		//display sorted list
		list.forEach(s -> System.out.println(s));
		
		System.out.println();
		System.out.println();

		//1.4 Remove all failed students from the map n display the map again (gpa < 6 =>failure)
		map.values().removeIf(s -> s.getGpa() < 6);//convert Map into Collection<Student> 
		map.forEach((k, v) -> System.out.println(v));
		
		
		}

}
