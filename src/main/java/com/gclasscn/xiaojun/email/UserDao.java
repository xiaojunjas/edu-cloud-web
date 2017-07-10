package com.gclasscn.xiaojun.email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import groovyjarjarcommonscli.ParseException;

public class UserDao {
	
	public HashMap<String, String> map=new HashMap<String, String>();  
    /** 
     * @保存注册信息 
     *  private Long id; 
        private String name; 
        private String password; 
        private String email;//注册账号 
        private int status;//激活状态 
        private String validateCode;//激活码 
        private Date  registerTime;//注册时间 
     */  
    public void save(UserModel user){  
        System.out.println("cicicici");  
        map.put("id", String.valueOf(user.getId()));  
        map.put("email", user.getEmail());  
        map.put("validateCode", user.getValidateCode());  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");  
        String time=sdf.format(user.getRegisterTime());  
        map.put("registerTime", time);  
        int status=user.getStatus();  
        map.put("status", String.valueOf(status));  
        map.put("name", user.getName());  
        String t2=sdf.format(user.getLastActivateTime());  
        map.put("activeLastTime", String.valueOf(t2));  
        System.out.println("=======s========="+status);  
          
    }  
      
    /** 
     * @更新 user 
     */  
    public void update(UserModel user){  
        map.put("email", user.getEmail());  
        map.put("validateCode", user.getValidateCode());  
        Date time=user.getRegisterTime();  
        map.put("registerTime", String.valueOf(time));  
        int status=user.getStatus();  
        map.put("status", String.valueOf(status));  
        System.out.println("=======st========="+status);  
    }  
      
    /** 
     * @throws ParseException  
     * @throws java.text.ParseException 
     * @查找信息 
     */  
    public UserModel find(String email) throws ParseException, java.text.ParseException{  
        UserModel user=new UserModel();  
        user.setEmail(map.get("email"));  
        user.setName(map.get("name"));  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");  
        Date day=sdf.parse(map.get("registerTime"));  
        user.setRegisterTime(day);  
        user.setStatus(Integer.valueOf(map.get("status")));  
        user.setValidateCode(map.get("validateCode"));  
  
        return user;  
    }  
}
