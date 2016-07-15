package com.testwebapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serviceone {

	static Map<String, List<String>> map = new HashMap<String, List<String>>();

	void createraw() {
		// create list one and store values
		List<String> valSetOne = new ArrayList<String>();
		valSetOne.add("OneLink1");
		valSetOne.add("OneLink2");
		// create list two and store values
		List<String> valSetTwo = new ArrayList<String>();
		valSetTwo.add("TwoLink1");
		valSetTwo.add("TwoLink2");
		valSetTwo.add("TwoLink3");
		// create list three and store values
		List<String> valSetThree = new ArrayList<String>();
		valSetThree.add("ThreeLink1");
		valSetThree.add("ThreeLink2");
		valSetThree.add("ThreeLink3");
		valSetThree.add("ThreeLink4");

		// put values into map
		map.put("key1", valSetOne);
		map.put("key2", valSetTwo);
		map.put("key3", valSetThree);
	}

	List fetchlinks(String key) {
		return map.get(key);
	}

}
