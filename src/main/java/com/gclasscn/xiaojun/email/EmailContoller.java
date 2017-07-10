package com.gclasscn.xiaojun.email;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailContoller {
	
	/*@Autowired  
    private EmailService emailService; */ 
	
	/*@Autowired  
    private UserDao userDao; */ 
	
    @RequestMapping(value="/email/register", method=RequestMethod.POST)
	public @ResponseBody Integer emailRegister(String email){
    	
        UserModel user=new UserModel();   
        Long as=5480l;  
        user.setId(as);  
        user.setName("xiaoming");  
        user.setPassword("324545");  
        user.setEmail(email);  
        user.setRegisterTime(new Date());  
        user.setStatus(0);  
        ///如果处于安全，可以将激活码处理的更复杂点，这里我稍做简单处理  
        //user.setValidateCode(MD5Tool.MD5Encrypt(email));  
        user.setValidateCode(MD5Util.encode2hex(email));  
          
//        userDao.save(user);//保存注册信息  
          
        ///邮件的内容  
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");  
        sb.append("<a href=\"http://localhost:7009/cloud/email/activate?email=");  
        sb.append(email);   
        sb.append("&validateCode=");   
        sb.append(user.getValidateCode());  
        sb.append("\">http://localhost:7009/cloud/email/activate?email=");   
        sb.append(email);  
        sb.append("&validateCode=");  
        sb.append(user.getValidateCode());  
        sb.append("</a>");  
          
        //发送邮件  
        SendEmail.send(email, sb.toString());  
        System.out.println("发送邮件");  
        return 0;
    }
    
    @RequestMapping(value="/email/activate", method=RequestMethod.POST)
  	public @ResponseBody Integer emailActivate(String email,String validateCode) throws ParseException, Exception{
//    	service.processActivate(email , validateCode);//调用激活方法  
  		return 0;
      }
	
}
