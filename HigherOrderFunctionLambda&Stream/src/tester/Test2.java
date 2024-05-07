package tester;

import java.util.List;

import com.app.core.Student;
import com.app.core.Subject;

import static utils.StudentCollectionUtils.*;

public class Test2 {

	public static void main(String[] args) {
		List<Student>list=populateList();
		//display complete list of students
		System.out.println("ALl Students");
		list.forEach(s -> System.out.println(s));
		//accept subject from user
		Subject sub=Subject.JAVA;
		System.out.println("/n/nFiltered Students");
		
		
		list.stream().filter(s -> s.getSubject()==sub).forEach(s -> System.out.println(s));

	}

}
