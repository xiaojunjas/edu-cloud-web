package com.gclasscn.xiaojun.jsoup.ke;

public class Course {
	private String linkHref;
	private String linkText;
	public String getLinkHref() {
		return linkHref;
	}
	public void setLinkHref(String linkHref) {
		this.linkHref = linkHref;
	}
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	@Override
	public String toString() {
		return "Course [linkHref=" + linkHref + ", linkText=" + linkText + "]";
	}
}
