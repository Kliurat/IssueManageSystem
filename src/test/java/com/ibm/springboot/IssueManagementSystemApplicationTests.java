package com.ibm.springboot;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IssueManagementSystemApplicationTests {

	@Test
	void contextLoads() {

		HashedMap<String, String> hashedMap = new HashedMap<String, String>();
		hashedMap.put("asd马", "阿答达");
		hashedMap.put("阿特", "大师斯达");
		hashedMap.put("老马", "阿斯达");

		TreeMap<String, String> treeMap = new TreeMap<String, String>(hashedMap);

		Set<String> keySet = hashedMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
//			if ("阿特".equals(next)) {
//				iterator.remove();
//			}

		}

		System.out.println(hashedMap);

	}

}
