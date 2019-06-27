package org.BaiduMap.utils;
/**
* <p>创建时间：2019年6月27日 上午9:18:37
* <p>项目名称：BaiduMap
* 
* <p>类说明：
*保存基本信息
* @version 1.0
* @since JDK 1.8
* 文件名称：BaiduMapInfo.java
* */
public class BaiduMapInfo {
	private String address , addressNorm , areaID , areaName , cityID , cityName , detailPointX ,detailPointY , detailTag ;
	/**</p>获取地址*/
	public String getAddress() {
		return address;
	}
	/**</p>获取地址范围*/
	public String getAddressNorm() {
		return addressNorm;
	}
	/**</p>获取区号*/
	public String getAreaID() {
		return areaID;
	}
	/**</p>获取区号名称*/
	public String getAreaName() {
		return areaName;
	}
	/**</p>获取城市ID*/
	public String getCityID() {
		return cityID;
	}
	/**</p>获取城市名称*/
	public String getCityName() {
		return cityName;
	}
	/**</p>获取X坐标*/
	public String getDetailPointX() {
		return detailPointX;
	}
	/**</p>获取Y坐标*/
	public String getDetailPointY() {
		return detailPointY;
	}
	/**</p>获取信息标签*/
	public String getDetailTag() {
		return detailTag;
	}
	
	/**</p>设置地址*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**</p>设置地址范围*/
	public void setAddressNorm(String addressNorm) {
		this.addressNorm = addressNorm;
	}
	/**</p>设置区号*/
	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}
	/**</p>设置区号名称*/
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**</p>设置城市ID*/
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	/**</p>设置城市名称*/
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**</p>设置X坐标*/
	public void setDetailPointX(String detailPointX) {
		this.detailPointX = detailPointX;
	}
	/**</p>设置Y坐标*/
	public void setDetailPointY(String detailPointY) {
		this.detailPointY = detailPointY;
	}
	/**</p>设置信息标签*/
	public void setDetailTag(String detailTag) {
		this.detailTag = detailTag;
	}
	
}
