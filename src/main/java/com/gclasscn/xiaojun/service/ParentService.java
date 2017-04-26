package com.gclasscn.xiaojun.service;

import java.util.List;

import com.gclasscn.xiaojun.domain.Parent;

import retrofit.http.GET;
import retrofit.http.Query;

public interface ParentService {
	
	@GET("/v1/parents")
    public List<Parent> findParents(@Query("start")Integer start, @Query("limit")Integer limit, @Query("query")String query);
	
	@GET("/v1/count/parents")
    public Integer countParents(@Query("query")String query);
	
}
