package advanced_generics;

import static utils.GenericUtils.printAllElements2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.app.core.Emp;
import com.app.core.Mgr;

public class Test3 {

	public static void main(String[] args) {
		Emp e = new Mgr(1000);// up casting
		Collection<Emp> emps=null;
		//System.out.println(emps);
		List<Mgr> mgrs = Arrays.asList(new Mgr(100), 
				new Mgr(200), new Mgr(300));
	//	emps=mgrs;//since generic collections are : in variant
	//	Collection<Object> objects=mgrs;
		Collection<?> anyCollection=mgrs;
		printAllElements2(mgrs);
		List<?> anyList=new ArrayList<>();

	}

}
