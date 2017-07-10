package com.gclasscn.xiaojun.jsoup;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
public class Video {
	
	public static void yeant(){
	  	  try {
	            //创建client实例
	            HttpClient client= HttpClients.createDefault();
	            //创建httpget实例
	            HttpGet httpGet=new HttpGet("http://www.btba.com.cn");
	            //执行 get请求
	            HttpResponse response=client.execute(httpGet);
	            //返回获取实体
	            HttpEntity entity=response.getEntity();
	            //获取网页内容，指定编码
	            String web= EntityUtils.toString(entity,"UTF-8");
	            //输出网页
	            System.out.println(web);
	            Document doc= Jsoup.parse(web);
	            Elements links=doc.select("a[href~=http://www.btba.com.cn/type/*]");//选择器，选取特征信息
	            String webs=null;
	            for (Element link:links) {
	                webs=link.attr("abs:href").toString();
	                System.out.println(webs+"\t\t"+link.text());//输出特征信息
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  }
	
	  public void downMovie(String str) {  
	        String homeurl = "";  
	        String page = "";  
	        String suf = "";  
	        // 正则表达式处理 解析地址  
	        Pattern p_url = Pattern.compile("(.*)(\\d)(\\.html)");  
	        Matcher m_url = p_url.matcher(str);  
	        if (m_url.find()) {  
	            homeurl = m_url.group(1);  
	            page = m_url.group(2);  
	            suf = m_url.group(3);  
	        }  
	        // 循环抓取  
	        for (int i = Integer.parseInt(page); i <= 30; i++) {  
	            String path = homeurl + i + suf;  
	            Document doc1 = null;  
	            try {  
	                doc1 = Jsoup.connect(path).get();  
	            } catch (IOException e2) {  
	                System.out.println(">>>>>>IO 错误 1");  
	                continue;  
	            }  
	            Element listofficial = doc1.getElementById("listofficial");  
	            Elements p_pvs = listofficial.getElementsByTag("ul");  
	            for (int j = 0; j < 40; j++) {  
	                Element p_pv = p_pvs.get(j);  
	                String a = p_pv.getElementsByTag("a").attr("href");  
	                String title = p_pv.getElementsByTag("a").attr("title");  
	                Document doc2 = null;  
	                try {  
	                    doc2 = Jsoup.connect(a).get();  
	                } catch (IOException e1) {  
	                    System.out.println(">>>>>>IO 错误 2");  
	                    continue;  
	                }  
	                Element showInfo = doc2.getElementById("showInfo");  
	                Element baseinfo = showInfo.getElementsByClass("baseinfo").get(0);  
	                Elements link = baseinfo.getElementsByClass("link");  
	                Element url_a = null;  
	                if (link.size() > 0) {  
	                    url_a = link.get(0).getElementsByTag("a").get(0);  
	                } else {  
	                    System.out.println(title + " : " + "无视频链接");  
	                    continue;  
	                }  
	                String url = url_a.attr("href");  
	                System.out.print(url + "\t\t");  
	                System.out.println(title);  
	            }  
	        }  
	  
	    }  
	
	public static void main(String[] args) {
//		Video.yeant();
		 String ss = "http://www.youku.com/v_olist/c_96_a__s__g__r__lg__im__st__mt__tg__d_1_et_0_ag_0_fv_0_fl__fc__fe__o_7_p_1.html";  
	      new Video().downMovie(ss);  
	}
}
