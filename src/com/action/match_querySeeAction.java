package com.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.*;
import com.opensymphony.xwork2.ActionSupport;
import com.po.*;
import com.vo.*;
public class match_querySeeAction {
	private ModelBean service;
	private List<matchPO> matchAll; 
	public Match match;

	public List<matchPO> getmatchAll() {
		return matchAll;
	}

	public void setmatchAll(List<matchPO> matchAll) {
		this.matchAll = matchAll;
	}
	
	public Match getmatch() {
		return match;
	}

	public void setmatch(Match match) {
		this.match = match;
	}

	public String execute() 
	{
		try
		{
			service = new ModelBean();
			matchAll = new ArrayList<matchPO>();
			matchAll = service.Seematch(match,"全部");
			
			if (matchAll != null) 
			{
				return  "success";  //成功
			}
			else
			{
				return "input";     //不成功						
			}
		}catch(SQLException e)
			{
				return  "input";     //不成功	
			}
		 catch(ClassNotFoundException ne)
		 {
		 	return  "input";     //不成功	
		 }
	}

}
