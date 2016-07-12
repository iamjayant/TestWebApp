package com.testwebapp;

import java.util.HashMap;
import java.util.Map;

public class Servicetwo {
	static Map<String, String> map = new HashMap<String, String>();

	void create() {
		map.put("OneLink1", "details of key 1 link 1");
		map.put("OneLink2", "details of key 1 link 2");
		map.put("TwoLink1", "details of key 2 link 1");
		map.put("TwoLink2", "details of key 2 link 2");
		map.put("TwoLink3", "details of key 2 link 3");
		map.put("ThreeLink1", "details of key 3 link 1");
		map.put("ThreeLink2", "details of key 3 link 2");
		map.put("ThreeLink3", "details of key 3 link 3");
		map.put("ThreeLink4", "details of key 3 link 4");
	}

	String fetchdetails(String link) {
		return map.get(link);
	}
}
