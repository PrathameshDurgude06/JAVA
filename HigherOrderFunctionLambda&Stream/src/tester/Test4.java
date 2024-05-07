package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static utils.IOUtils.*;
import com.app.core.Student;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		try (Scanner sc = new Scanner(System.in)) 
		{	
		try {
		Map<String, Student> studMap = populateMap(populateList());
		Comparator<Student>comp=(s1,s2) -> s1.getName().compareTo(s2.getName());
		Comparator<Student>comp1=(s1,s2) ->s1.getDob().compareTo(s2.getDob());
		
		Stream<Student>str=studMap.values().stream().sorted(comp);
		Stream<Student>str1=studMap.values().stream().sorted(comp1);
		
		System.out.println("Enter File name");
		storeStudentDetails(str,sc.nextLine());
		System.out.println("Data Stored");
		
		System.out.println("Enter File name for Sort data as per dob ");
		storeStudentDetails(str1,sc.nextLine());
		System.out.println("Sorted as per DOB");
		}
		
		catch(Exception e) {
			e.printStackTrace();
			sc.nextLine();
		}

	}
	}
}
