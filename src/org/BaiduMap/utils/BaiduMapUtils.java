package org.BaiduMap.utils;
/**
* <p>创建时间：2019年6月27日 上午9:19:17
* <p>项目名称：BaiduMap
* 
* <p>类说明：
*地图核心实现部分
* @version 1.0
* @since JDK 1.8
* 文件名称：BaiduMapUtils.java
* */

import java.util.ArrayList;
import java.util.List;

import com.ToolBox.net.SRequest;
import com.ToolBox.util.StringTool;

public class BaiduMapUtils {
	private final static String BaiduMapLinkHead = "https://map.baidu.com/?newmap=1&reqflag=pcmap&biz=1&from=webmap&da_par=direct&pcevaname=pc4.1&qt=s&da_src=shareurl&wd=" , BaiduMapLinkEnd = "&c=350&src=0&pn=0&sug=0&l=13&from=webmap";

	private final static String BaiduMapXYLinkHead = "https://api.map.baidu.com/?qt=rgc&" , BaiduMapXYLinkEnd = "&dis_poi=100&poi_num=10&latest_admin=1&ie=utf-8&oue=1&fromproduct=jsapi&res=api";
	
	
	private final static StringTool st = new StringTool();
	/**<p>返回json数组内容*/
	public String getByJsonData(String addressName) {
		return st.UnicodeToString(new SRequest(BaiduMapLinkHead+st.urlencode(addressName)+BaiduMapLinkEnd).getPage());
	}
	/**<p>返回存有BaiduMapInfo的List集合*/
	public List<BaiduMapInfo> getAll(String addressName){
		ArrayList<BaiduMapInfo> mapList = new ArrayList<>();
		for(String jsonData : st.getByAllString(getByJsonData(addressName), "\"acc_flag\":(.+?\"ext)(.+?\\},(.+?\"))", "").split("\n")) {
			BaiduMapInfo bmi = new BaiduMapInfo();
			bmi.setAddress(st.getByJson(jsonData, "addr").replaceAll("\\s+", ""));
			bmi.setAddressNorm(st.getByJson(jsonData, "address_norm").replaceAll("\\s+", ""));
			bmi.setCityName(st.getByJson(jsonData, "city_name").replaceAll("\\s+", ""));
			bmi.setCityID(st.getByString(jsonData, "\"city_id\":(.+?,)", "\"|,|city_id|:").replaceAll("\\s+", ""));
			bmi.setAreaID(st.getByString(jsonData, "\"area_id\":(.+?,)", "\"|,|area_id|:").replaceAll("\\s+", ""));
			bmi.setAreaName(st.getByJson(jsonData, "area_name").replaceAll("\\s+", ""));
			bmi.setDetailPointX(st.getByString(jsonData, "\"diPointX\":(.+?,)", "\"|,|diPointX|:").replaceAll("\\s+", ""));
			bmi.setDetailPointY(st.getByString(jsonData, "\"diPointY\":(.+?,)", "\"|,|diPointY|:").replaceAll("\\s+", ""));
			bmi.setDetailTag(st.getByJson(jsonData, "di_tag").replaceAll("\\s+", ""));
			mapList.add(bmi);
		}
		return mapList;
	}
	/**<p>获取xy坐标地址名称*/
	public String getAddressXY(String x , String y) {
		return st.getByJson(new SRequest(BaiduMapXYLinkHead+"x="+x+"&y="+y+BaiduMapXYLinkEnd).getPage(), "address");
	}
	
}
