package com.cgd.test;

public class ZhuangZaiData {
	private String title;
	private String hrefData;
	private Boolean isHadExist;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHrefData() {
		return hrefData;
	}
	public void setHrefData(String hrefData) {
		this.hrefData = hrefData;
	}
	
	public Boolean getIsHadExist() {
		return isHadExist;
	}
	public void setIsHadExist(Boolean isHadExist) {
		this.isHadExist = isHadExist;
	}
	@Override
	public String toString() {
		
		return "title:"+title+"  hrefData:"+hrefData;
	}
}
