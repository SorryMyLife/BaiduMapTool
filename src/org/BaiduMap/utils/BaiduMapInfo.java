package org.BaiduMap.utils;
/**
* <p>����ʱ�䣺2019��6��27�� ����9:18:37
* <p>��Ŀ���ƣ�BaiduMap
* 
* <p>��˵����
*���������Ϣ
* @version 1.0
* @since JDK 1.8
* �ļ����ƣ�BaiduMapInfo.java
* */
public class BaiduMapInfo {
	private String address , addressNorm , areaID , areaName , cityID , cityName , detailPointX ,detailPointY , detailTag ;
	/**</p>��ȡ��ַ*/
	public String getAddress() {
		return address;
	}
	/**</p>��ȡ��ַ��Χ*/
	public String getAddressNorm() {
		return addressNorm;
	}
	/**</p>��ȡ����*/
	public String getAreaID() {
		return areaID;
	}
	/**</p>��ȡ��������*/
	public String getAreaName() {
		return areaName;
	}
	/**</p>��ȡ����ID*/
	public String getCityID() {
		return cityID;
	}
	/**</p>��ȡ��������*/
	public String getCityName() {
		return cityName;
	}
	/**</p>��ȡX����*/
	public String getDetailPointX() {
		return detailPointX;
	}
	/**</p>��ȡY����*/
	public String getDetailPointY() {
		return detailPointY;
	}
	/**</p>��ȡ��Ϣ��ǩ*/
	public String getDetailTag() {
		return detailTag;
	}
	
	/**</p>���õ�ַ*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**</p>���õ�ַ��Χ*/
	public void setAddressNorm(String addressNorm) {
		this.addressNorm = addressNorm;
	}
	/**</p>��������*/
	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}
	/**</p>������������*/
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**</p>���ó���ID*/
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	/**</p>���ó�������*/
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**</p>����X����*/
	public void setDetailPointX(String detailPointX) {
		this.detailPointX = detailPointX;
	}
	/**</p>����Y����*/
	public void setDetailPointY(String detailPointY) {
		this.detailPointY = detailPointY;
	}
	/**</p>������Ϣ��ǩ*/
	public void setDetailTag(String detailTag) {
		this.detailTag = detailTag;
	}
	
}
