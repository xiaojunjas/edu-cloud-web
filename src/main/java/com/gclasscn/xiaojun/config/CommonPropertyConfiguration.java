package com.gclasscn.xiaojun.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class CommonPropertyConfiguration {
	
	/**
	 * rest connection configurations
	 */
	private int connectionTimeout;
	private int readTimeout;
	private int writeTimeout;
	
	/**
	 * rest url configurations
	 */
	private String userUrl;
	private String fileUrl;
//	private String baseUrl;
	
	/**
	 * cas configurations
	 */
	/*private String casServer;
	private String casService;
	private String casLogin;
	private String casLogout;*/
	
	/**
	 * html layout
	 */
	private String layout;
	private String fullLayout;
	
	private String imagePreviewUrl;
	/*private String fileDownloadUrl;
	private String filesDownloadUrl;*/
	
	private Map<String, String> templates;

	public int getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public int getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
	public int getWriteTimeout() {
		return writeTimeout;
	}
	public void setWriteTimeout(int writeTimeout) {
		this.writeTimeout = writeTimeout;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getFullLayout() {
		return fullLayout;
	}
	public void setFullLayout(String fullLayout) {
		this.fullLayout = fullLayout;
	}
/*	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}*/
	public Map<String, String> getTemplates() {
		return templates;
	}
	public void setTemplates(Map<String, String> templates) {
		this.templates = templates;
	}
	public String getImagePreviewUrl() {
		return imagePreviewUrl;
	}
	public void setImagePreviewUrl(String imagePreviewUrl) {
		this.imagePreviewUrl = imagePreviewUrl;
	}
	/*	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}
	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}
	public String getFilesDownloadUrl() {
		return filesDownloadUrl;
	}
	public void setFilesDownloadUrl(String filesDownloadUrl) {
		this.filesDownloadUrl = filesDownloadUrl;
	}
	*/
}
