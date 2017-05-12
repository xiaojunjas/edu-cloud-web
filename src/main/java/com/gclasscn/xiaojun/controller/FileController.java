package com.gclasscn.xiaojun.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.gclasscn.xiaojun.config.CommonPropertyConfiguration;
import com.gclasscn.xiaojun.domain.TypedFile;
import com.gclasscn.xiaojun.service.FileService;

@Controller
public class FileController { 
	
private Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileService fileService;
	@Autowired
	private CommonPropertyConfiguration config;
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 文件上传
	 */
	@RequestMapping(value="/files", method=RequestMethod.POST)
	public @ResponseBody void uploadFile(MultipartFile file) throws IOException{
		TypedFile typedFile = new TypedFile(file.getOriginalFilename(), file.getContentType(), file.getInputStream());
		fileService.uploadFile(typedFile);
    }
	
	/**
	 * 原始图片预览
	 */
	@RequestMapping(value="/files/images/{imageId}", method=RequestMethod.GET)
	public void preview(@PathVariable("imageId") String imageId, HttpServletResponse response){
		fileHandler(response, config.getFileUrl() + config.getImagePreviewUrl() + imageId);
	}
	
	/**
	 * 缩略图预览
	 *//*
	@RequestMapping(value="/files/images/{imageId}/{width}/{height}", method=RequestMethod.GET)
	public String preview(@PathVariable("imageId") String imageId, @PathVariable("width") Integer width, @PathVariable("height") Integer height){
		return fileService.preview(imageId, width, height);
	}
	
	*//**
	 * 单文件下载
	 *//*
	@RequestMapping(value="/files/id/{id}", method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("id") String fileId){
		fileHandler(response, config.getFileUrl() + config.getFileDownloadUrl() + fileId);
	}
	
	*//**
	 * 多文件下载
	 *//*
	@RequestMapping(value="/files/ids", method=RequestMethod.GET)
	public void downloadFiles(HttpServletResponse response, String[] fileIds){
		fileHandler(response, config.getFileUrl() + config.getFilesDownloadUrl() + "?fileIds=" + String.join("&fileIds=", fileIds));
	}*/
	
	private void fileHandler(HttpServletResponse response, String path){
		URI uri = URI.create(path);
		URLConnection connection;
		try {
			connection = uri.toURL().openConnection();
			setHeaders(response, connection);
		} catch (IOException e) {
			logger.error("打开URL连接失败: {}", e.getMessage(), e);
		}
		RequestCallback requestCallback = callback -> callback.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
		ResponseExtractor<Void> responseExtractor = extractor -> {
			IOUtils.copy(extractor.getBody(), response.getOutputStream());
		    return null;
		};
		restTemplate.execute(uri, HttpMethod.GET, requestCallback, responseExtractor);
	}
	
	private void setHeaders(HttpServletResponse response, URLConnection connection){
		response.setHeader("Content-Length", connection.getHeaderField("Content-Length"));
		response.setHeader("Content-Type", connection.getHeaderField("Content-Type"));
		response.setHeader("Content-Disposition", connection.getHeaderField("Content-Disposition"));
	}
	
}