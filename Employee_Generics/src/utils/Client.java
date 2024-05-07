package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.app.core.Emp;
import com.app.core.HRMgr;
import com.app.core.Mgr;
import com.app.core.SalesMgr;
import com.app.core.Worker;

import static utils.GenericUtils.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Emp e=new Mgr(1000.00);
		// System.out.println(e.computeSalary());
		 
		
		 List<Mgr> mgrs = Arrays.asList(new Mgr(100), 
					new Mgr(200), new Mgr(300));
		 Collection<? extends Emp>any;
		 any=mgrs;
		 Double sum;
		 System.out.println("List of Mgr");
		 sum= sumOfSalaries(mgrs);
		 System.out.println(sum+"\n");
		 
		 List<Worker>wkrs=new ArrayList<Worker>();
		 Worker a1=new Worker(100);
		 Worker a2=new Worker(500);
		 Worker a3=new Worker(600);
		 wkrs.add(a1);
		 wkrs.add(a2);
		 wkrs.add(a3);
		 any=wkrs;
		 sum=sumOfSalaries(wkrs);
		 System.out.println("List of Worker");
		 System.out.println(sum+"\n");
		 
		 List<Emp>emps=new Vector<Emp>();
		 Emp e1=new HRMgr(1000);
		 Emp e2=new HRMgr(2000);
		 Emp e3=new HRMgr(3000);
		 emps.add(e1);
		 emps.add(e2);
		 emps.add(e3);
		 any=emps;
		 System.out.println("List of Employee");
		 sum=sumOfSalaries(emps);
		 System.out.println(sum);
		 
	}

}
