package com.gclasscn.xiaojun.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class CollectionText {

	      public   static   void  main(String[] args)  {
	         List<String> list  =   new  LinkedList<String>();
	         for  ( int  i  =   0 ; i  <   9 ; i ++ )  {
	             list.add( " a " + i);
	         } 
	         Collections.sort(list); // 顺序排列 
	         System.out.println(list);
	         
	         Collections.shuffle(list); // 混乱的意思 
	         System.out.println(list);
	         
	         Collections.reverse(list); // 倒序排列 
	         System.out.println(list);
	       
	    } 
}
