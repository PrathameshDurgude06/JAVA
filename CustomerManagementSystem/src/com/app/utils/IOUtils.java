package com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.coreclasses.Customer;

public interface IOUtils {
	
	static void writeDetails(Map<String,Customer>map,String filename) throws IOException{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(map);
		}
	}
	
	@SuppressWarnings("unchecked")
	static Map<String,Customer> readDetails(String filename)throws IOException,ClassNotFoundException{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)))
		{
			return (Map<String,Customer>)in.readObject();
		}
		
	}

}
