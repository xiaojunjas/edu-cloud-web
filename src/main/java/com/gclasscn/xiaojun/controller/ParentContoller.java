package com.gclasscn.xiaojun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gclasscn.xiaojun.domain.Parent;
import com.gclasscn.xiaojun.service.ParentService;
import com.gclasscn.xiaojun.uitls.PageList;
import com.gclasscn.xiaojun.uitls.PageParam;

@Controller
public class ParentContoller {
	@Autowired 
	public ParentService parentService;
	
	
	@RequestMapping(value="/parent", method=RequestMethod.GET)
	public String index(Model model){
		return "parent/parent";
    }
	
	@RequestMapping(value="/parents", method=RequestMethod.GET)
	public @ResponseBody PageList<Parent> parents(Model model,Integer start, Integer limit, String query){
		PageParam page = new PageParam(start, limit);
		Integer count = parentService.countParents(query);
		PageList<Parent> result = new PageList<Parent>(count);
		if(count>page.getStart()){
			List<Parent> p = parentService.findParents(page.getStart(),page.getLimit(),query);
			result.setList(p);
		}
		return result;
    }
	
}
