package com.app.utils;

import java.util.Iterator;
import java.util.List;

import com.app.core.Cricketer;
import com.app.custom_exception.CricketException;

public class CricketerUtils {
	
	public static String updateRating(String email,int newRating,List<Cricketer> list) {
		Iterator<Cricketer> itr=list.listIterator();
		while(itr.hasNext()) {
			Cricketer cricketer = itr.next();
			if(cricketer.getEmail().equals(email)) {
				cricketer.setRating(newRating);
			}
		}
		return "Rating modified successfully";
	}

	public static Cricketer searchCricketerByName(String name, List<Cricketer> clist) throws CricketException {
		Iterator<Cricketer>itr=clist.listIterator();
		while(itr.hasNext()) {
			Cricketer cricketer = itr.next();
			if(cricketer.getName().equalsIgnoreCase(name)) {
				return cricketer;
			}
		}
		throw new CricketException("Circketer is not available of this name");
	}

}
