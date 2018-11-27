package BaiduMap;

/*
 * 用来查询基于百度地图坐标的
 * 
 * 2018年11月27日19:32:24 
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduMapPoint {
	
	private BaiduMapValue bmv;
	private BaiduMapInfo bmi;
	
	public String printXY(String X , String Y) //返回查询后的坐标内容
	{
		bmv = new BaiduMapValue();
		bmi = new BaiduMapInfo();
		bmv.newURL = bmv.baiduMapXYLink+"&x="+X+"&y="+Y+bmv.baiduMapXYdis;
		bmv.str = bmv.getCode(bmv.newURL);
		Matcher m1 = Pattern.compile("addr\":\"(.+?\")").matcher(bmv.str);
		Matcher m2 = Pattern.compile("\"tag\":\"(.+?\")").matcher(bmv.str);
		Matcher m3 = Pattern.compile("\"business\":\"(.+?\")").matcher(bmv.str);
		Matcher m4 = Pattern.compile("\"country\":\"(.+?\")").matcher(bmv.str);
		if(m1.find() &&m2.find() &&m3.find() &&m4.find())
		{
			bmi.setAddress(m1.group(0).replaceAll("addr\":\"|\"", ""));//地址
			bmi.setTag(m2.group().replaceAll("\"tag\":\"|\"", ""));//标签
			bmi.setAlias(m3.group().replaceAll("\"business\":\"|\"", ""));//商业
			bmi.setAddress_norm(m4.group().replaceAll("\"country\":\"|\"", ""));//国家
			bmv.tmp = "所属国家: "+bmi.getAddress_norm()+"\n目标地址: "+bmi.getAddress() + "\n目标标签: "+bmi.getTag()+"\n类型: "+bmi.getAlias()+"\n";
		}
		return bmv.tmp;
	}
	
	public String[] printXYArray(String X , String Y)
	{
		String s[] = new String[4];
		bmv = new BaiduMapValue();
		bmi = new BaiduMapInfo();
		bmv.newURL = bmv.baiduMapXYLink+"&x="+X+"&y="+Y+bmv.baiduMapXYdis;
		bmv.str = bmv.getCode(bmv.newURL);
		Matcher m1 = Pattern.compile("addr\":\"(.+?\")").matcher(bmv.str);
		Matcher m2 = Pattern.compile("\"tag\":\"(.+?\")").matcher(bmv.str);
		Matcher m3 = Pattern.compile("\"business\":\"(.+?\")").matcher(bmv.str);
		Matcher m4 = Pattern.compile("\"country\":\"(.+?\")").matcher(bmv.str);
		if(m1.find() &&m2.find() &&m3.find() &&m4.find())
		{
			bmi.setAddress(m1.group(0).replaceAll("addr\":\"|\"", ""));//地址
			bmi.setTag(m2.group().replaceAll("\"tag\":\"|\"", ""));//标签
			bmi.setAlias(m3.group().replaceAll("\"business\":\"|\"", ""));//商业
			bmi.setAddress_norm(m4.group().replaceAll("\"country\":\"|\"", ""));//国家
//			bmv.tmp = "所属国家: "+bmi.getAddress_norm()+"\n目标地址: "+bmi.getAddress() + "\n目标标签: "+bmi.getTag()+"\n商业类型: "+bmi.getAlias()+"\n";
			s[0] = bmi.getAddress_norm();
			s[1] = bmi.getAddress();
			s[2] = bmi.getTag();
			s[3] = bmi.getAlias();
		}
		return s;
	}
	
	
}
