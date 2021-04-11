package com.Test.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionExample {

	public static void main(String args[]) {

		//Normal hashmap- On running, it throws ConcurrentModificationException
		//Map<String, String> myMap = new HashMap<String, String>();
		
		//Concurrent hashmap- On running, it doesnt throw ConcurrentModificationException		
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();

		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				myMap.put("4", "4");
			}
		}

	}
}

