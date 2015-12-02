package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String,Integer> map = Collections.synchronizedMap(new HashMap<>());
		map.put("Crazy Me", 120);
		map.put("Cold Me", null);
		map.put("Cool Me", 20);
		for (Object key : map.keySet()) {
			System.out.println(key+"-->"+map.get(key));
		}
		System.out.println(map.containsKey("Cool Me"));
		map.remove("Cool Me");
		map.containsKey("Cool Me");
		System.out.println(map.containsKey("Cool Me"));
		System.out.println(map);
	}
}
