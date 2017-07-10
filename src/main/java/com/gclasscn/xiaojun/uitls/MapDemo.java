package com.gclasscn.xiaojun.uitls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {/*
	
	private static String mapVal(String key){
		Map<String,String> maps = Maps.newHashMap();
		maps.put("学生","1");
		maps.put("家长","2");
		maps.put("老师","3");
		return maps.get(key);
	}
	
	public static void main(String[] args) {
		Map<String,Integer> maps = Maps.newHashMap();
		maps.put("学生",1);
		maps.put("家长",2);
		maps.put("老师",3);
		System.out.println(maps.get(1));
	}
*/
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		/*list1.add("2");
		list1.add("3");*/
		List<String> list2 = new ArrayList<>();
		list2.add("1");
		list2.add("2");
	    
		/*List<String> diff = new ArrayList<String>();
	        for(String str:list1){
	            if(!list2.contains(str)){
	                diff.add(str);
	            } 
	        }
	        System.out.println("getDiffrent total times "+diff);*/
		System.out.println(getDiffrent4(list1,list2));
	}

	
	
	 private static List<String> getDiffrent4(List<String> list1, List<String> list2) {
	        long st = System.nanoTime();
	        Map<String,Integer> map = new HashMap<String,Integer>(list1.size()+list2.size());
	        List<String> diff = new ArrayList<String>();
	        List<String> maxList = list1;
	        List<String> minList = list2;
	        if(list2.size()>list1.size())
	        {
	            maxList = list2;
	            minList = list1;
	        }
	        for (String string : maxList) {
	            map.put(string, 1);
	        }
	        for (String string : minList) {
	            Integer cc = map.get(string);
	            if(cc!=null)
	            {
	                map.put(string, ++cc);
	                continue;
	            }
	            map.put(string, 1);
	        }
	        for(Map.Entry<String, Integer> entry:map.entrySet())
	        {
	            if(entry.getValue()==1)
	            {
	                diff.add(entry.getKey());
	            }
	        }
	        System.out.println("getDiffrent4 total times "+(System.nanoTime()-st));
	        return diff;
	        
	    }
}
