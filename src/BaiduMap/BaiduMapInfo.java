package BaiduMap;

/*
 * 用于存放百度地图相关内容的
 * 
 * 2018年11月27日19:32:29
 * */

public class BaiduMapInfo {
	private String address , address_norm , area_name ,area_num, pointX , pointY , alias  , tag;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_norm() {
		return address_norm;
	}

	public void setAddress_norm(String address_norm) {
		this.address_norm = address_norm;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getPointX() {
		return pointX;
	}

	public void setPointX(String pointX) {
		this.pointX = pointX;
	}

	public String getPointY() {
		return pointY;
	}

	public void setPointY(String pointY) {
		this.pointY = pointY;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getArea_num() {
		return area_num;
	}

	public void setArea_num(String area_num) {
		this.area_num = area_num;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getPointXY()
	{
		return getPointX() + ","+getPointY();
	}
	
	public String getAll()
	{
		return "地址: "+getAddress()+"\n地址范数: "+getAddress_norm()+"\n地址别名: "+getAlias()+"\n地区号码: "+getArea_num()+"\n地区名称: "+getArea_name()+"\n地理坐标: "+getPointXY()+"\n标签: "+getTag()+"\n";
	}
	
}
