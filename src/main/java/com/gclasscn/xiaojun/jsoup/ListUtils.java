package com.gclasscn.xiaojun.jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtils { 
	
	public static List<Long> getDiffrent4(List<Long> list1, List<Long> list2) {
        Map<Long,Integer> map = new HashMap<Long,Integer>(list1.size()+list2.size());
        List<Long> diff = new ArrayList<Long>();
        List<Long> maxList = list1;
        List<Long> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        for (Long string : maxList) {
            map.put(string, 1);
        }
        for (Long string : minList) {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for(Map.Entry<Long, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }
	/*
	public static void main(String[] args) {
		String[] userid = {"aa","bb","cc"};
		List<String> userList = new ArrayList<String>();
		System.out.println(Collections.addAll(userList, userid));
		System.out.println(getDiffrent4(new Integer[] { 1, 2, 3 }, new Integer[] {  
                1, 2})  );
	}
	
	public static <T> List<T> compare(T[] t1, T[] t2) {  
        List<T> list1 = Arrays.asList(t1);  
        List<T> list2 = new ArrayList<T>();  
        for (T t : t2) {  
            if (!list1.contains(t)) {  
                list2.add(t);  
            }  
        }  
        return list2;  
    }  
	 */
	
	public static void main(String[] args) {
		List<String> list1= new ArrayList<String>();
		list1.add("1");
		
		List<String> list2= new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		System.out.println(list1.removeAll(list2));
	}
}
