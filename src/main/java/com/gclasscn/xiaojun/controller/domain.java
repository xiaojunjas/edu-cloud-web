package com.gclasscn.xiaojun.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.gclasscn.xiaojun.domain.Parent;
import com.google.common.collect.Maps;
import com.google.gson.Gson;


public class domain {
	private static Gson gson = new Gson();
	
	
	public static Parent getParent(){
		String name="肖军";
		Parent parent =gson.fromJson(name, Parent.class);
		return parent;
	}
	
	/**
	 *  实体转Map
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public static Map<Object, Object> convertBean(Object bean) throws Exception{
		Class<? extends Object> type = bean.getClass();
		Map<Object, Object> returnMap = Maps.newHashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		PropertyDescriptor[] properTyDescriptor = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor descriptor : properTyDescriptor) {
			String porpertyName = descriptor.getName();
			if(!porpertyName.equals("class")){
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean);
				if(result != null){
						returnMap.put(porpertyName, result);
				}else{
						returnMap.put(porpertyName, "");
				}
			}
		}
		return returnMap;
	}
	
	/**
	 * map 转实体
	 * @param type
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static Object convertMap(Class<?> type,Map<?, ?> map) throws Exception{
		BeanInfo beanInfo = Introspector.getBeanInfo(type);
		Object obj = type.newInstance();
		PropertyDescriptor[] properTyDescriptor = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor descriptor : properTyDescriptor) {
			String porpertyName = descriptor.getName();
			if(map.containsKey(porpertyName)){
//				Method readMethod = descriptor.getReadMethod();
				 Object value = map.get(porpertyName);
				 descriptor.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}
	
	public static Map<String,String> mapVal(){
		Map<String, String> map =Maps.newHashMap();
		map.put("name", "肖军");
		map.put("phone", "137");
		map.put("adders", "湖南");
		return map;
	}

	public static Parent parentVal(){
		Parent par = new Parent();
		par.setId(1L);
		par.setName("肖军");
		par.setPhone("137");
		return par;
	}
	
	public static boolean equest(List<String> list,String str){
//		if(Strings.isNullOrEmpty(str) && list != null){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(str))
					return true;
//			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		Long id = 1L;
		Long[] ids = {id};
		String str = "3";
		String[] idsstr = String.valueOf(id).split(",");
		Map<Object, Object> maoObj = convertBean(parentVal());
		System.out.println(convertMap(Parent.class,mapVal())+":map转实体");
		System.out.println(maoObj+":实体转Map");
//		System.out.println(getParent());
		System.out.println(ids+":Long转数组");
		System.out.println(idsstr+":string转数组");
		JSONObject json =new JSONObject(mapVal());
		System.out.println(json+":map转json");
		
		System.out.println(str.equals("1")?"y":"n");
		System.out.println(str.equals("1")?"y":str.equals("2")?"t":str.equals("3")?"s":"n");
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(equest(list,"0"));
	}

}
