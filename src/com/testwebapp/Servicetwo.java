package com.testwebapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servicetwo {
	static Map<String, List<String>> map = new HashMap<String, List<String>>();

	void create() {
		List<String> d1 = new ArrayList<String>();
		d1.add("details of key 1 link 1");
		List<String> d2 = new ArrayList<String>();
		d2.add("details of key 1 link 2");
		List<String> d3 = new ArrayList<String>();
		d3.add("details of key 2 link 1");
		List<String> d4 = new ArrayList<String>();
		d4.add("details of key 2 link 2");
		List<String> d5 = new ArrayList<String>();
		d5.add("details of key 2 link 3");
		List<String> d6 = new ArrayList<String>();
		d6.add("details of key 3 link 1");
		List<String> d7 = new ArrayList<String>();
		d7.add("details of key 3 link 2");
		List<String> d8 = new ArrayList<String>();
		d8.add("details of key 3 link 3");
		List<String> d9 = new ArrayList<String>();
		d9.add("details of key 3 link 4");
		map.put("OneLink1", d1);
		map.put("OneLink2", d2);
		map.put("TwoLink1", d3);
		map.put("TwoLink2", d4);
		map.put("TwoLink3", d5);
		map.put("ThreeLink1", d6);
		map.put("ThreeLink2", d7);
		map.put("ThreeLink3", d8);
		map.put("ThreeLink4", d9);
	}

	List fetchdetails(String link) {
		return map.get(link);
	}
	Map<String, List<String>> fetchdetails1(String link){
		return (Map<String, List<String>>) new HashMap<String, List<String>>().put(link, map.get(link)) ;
	}
}
