package com.gclasscn.xiaojun.service;


import com.gclasscn.xiaojun.domain.TypedFile;
import com.gclasscn.xiaojun.domain.UploadResponse;

import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;

public interface FileService {
	
	@Multipart
	@POST("/v1/files")
	public UploadResponse uploadFile(@Part("rawFile") TypedFile file);

	@GET("/v1/files/images/{imageId}/{width}/{height}")
	public String preview(@Path("imageId") String imageId, @Path("width") Integer width, @Path("height") Integer height);

}
