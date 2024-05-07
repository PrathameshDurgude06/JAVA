package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;
import com.app.core.Student;

public interface IOUtils {
	
	 static void storeStudentDetails(Stream<Student>strm,String filename) throws IOException
	{
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename)))
		{
			strm.forEach(line -> pw.println(line));
		}//jvm: pw.close--pw.flush(data will send to FW) --fw.close
	}
	
}
