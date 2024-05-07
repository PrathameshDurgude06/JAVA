package tester;
import static utils.StudentCollectionUtils.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test3 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			
		//display students details from a specified subject
		Map<String,Student>studentMap=populateMap(populateList());
		
		//for each
		studentMap.forEach((k,v) -> System.out.println(v));
		
		//accept subject name from client
		System.out.println("Enter Subject name");
		Subject chosenSubject=Subject.valueOf(sc.next().toUpperCase());
		
		//display student details from a specified subject
		studentMap.values() //Collection<Student>
		.stream() //Stream<Student>
		.filter(s -> s.getSubject()==chosenSubject) //Stream<Student>
		.filter(s -> s.getGpa()>7)
		.forEach(s -> System.out.println(s));
		
		//display sum of gpas of all passed students
		double gpasum=studentMap.values()
		.stream() //Stream<Student>
		.filter(s -> s.getGpa()>6)
		.mapToDouble(s -> s.getGpa()) //conversion to DoubleStream 
		.sum();
		System.out.println("\n\nSum of gpa of all passed students: "+gpasum);
		
		//display the studen details from list of students sorted as per dob
		List<Student>slist=populateList();
		Comparator<Student>studComp=(s1,s2) -> s1.getDob().compareTo(s2.getDob());
		slist.stream()
		.sorted(studComp)
		.forEach(s -> System.out.println(s.getDob()+" "+ s));
		
		//print the name of subject topper
		System.out.println("Enter Sub for find Topper");
		Subject sub=Subject.valueOf(sc.next().toUpperCase());
		Student topper=studentMap.values()
		.stream()
		.filter(s -> s.getSubject()== sub)
		.max((s1,s2) -> ((Double)s1.getGpa()).compareTo(s2.getGpa()))
		.get();
		System.out.println("Topper: " +topper);
		
		
	}
	}
}
