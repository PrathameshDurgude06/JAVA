package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.app.core.Emp;
import com.app.core.Mgr;
import com.app.core.Worker;

import static utils.GenericUtils.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Emp e=new Mgr(1000.00);
		// System.out.println(e.computeSalary());
		 
		
		 List<Mgr> mgrs = Arrays.asList(new Mgr(100), 
					new Mgr(200), new Mgr(300));
		 Collection<?>any=mgrs;
		 Double sum = sumOfSalaries(mgrs);
		 System.out.println(sum);
	}

}
