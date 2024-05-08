package tester;

import java.util.Comparator;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import com.app.core.Student;
import com.app.core.Subject;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in)){
		
		Map<String,Student>studMap=populateMap(populateList());
		
		//Display all student details(list) sorted as per GPA 
		Comparator<Student>comp=(s1,s2) -> {
			return ((Double)s1.getGpa()).compareTo(s2.getGpa());
		};
		studMap.values().stream().sorted(comp).
		forEach(s -> System.out.println("Students are Sorted as per GPA: "+s ));
		
		
		//Write a tester to print average of  gpa of students for the specified course/subject
		System.out.println("\nEnter Subject to find Average :");
		Subject sub=Subject.valueOf(sc.next().toUpperCase());
		
		OptionalDouble avg=studMap.values().stream().filter(s -> s.getSubject()==sub)
		.mapToDouble(s -> s.getGpa()).average();
		System.out.println("\nAverage of Students's GPA as per Subject :"+avg);
		
		//Display all student details from a student map
		System.out.println("\n");
		studMap.values().stream().forEach(s -> System.out.println(s));
		
		}
	}

}
