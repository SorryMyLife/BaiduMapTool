package BaiduMap;

/*
 *这个是用于存放百度地图相关接口跟功能用的
 *
 *2018年11月27日19:32:19
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


public class BaiduMapValue {
	protected String baiduMapLink = "http://api.map.baidu.com/?qt=s&wd=" , baiduMapXYLink = "http://api.map.baidu.com/?qt=rgc" , baiduMapXYdis="&dis_poi=100&poi_num=10";
	protected String  tmp = " " , str = " " , newURL = " ";
	protected String baiduMap_address = " " , baiduMap_address_norm = " " , baiduMap_area_name = " " , baiduMap_area_num = " " , baiduMap_pointX = " " , baiduMap_pointY = " " , baiduMap_alias = " " , baiduMap_tag = " ";
	protected int size = -1 , len = -1;
	protected BaiduMapInfo bmi;
	
	protected HttpURLConnection check(String url_name) throws Exception //配置网络链接以及配置一些必要参数
	{
		HttpURLConnection con = (HttpURLConnection) new URL(url_name).openConnection();
		if(url_name.indexOf("http") == -1)
		{
			url_name = "https://"+url_name;
		}
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		con.setRequestProperty("Accept-Encoding", "deflate");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Content-Encoding", "gzip");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
		
		return con;
	}
	
	protected String getCode(String url_name) //获取网页源码
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(check(url_name).getInputStream(),"utf-8"));
			while((str = br.readLine()) != null)
			{
				tmp += str +"\n";
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	protected String StringToURLEncode(String s) //这三个都是字符串转码用的
	{
		tmp = s;
		try {
			s = URLEncoder.encode(tmp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	protected String unicodeToString(String str) {
		 
	    Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");    
	    Matcher matcher = pattern.matcher(str);
	    char ch;
	    while (matcher.find()) {
	        ch = (char) Integer.parseInt(matcher.group(2), 16);
	        str = str.replace(matcher.group(1), ch + "");    
	    }
	    return str;
	}
	
	protected String URLEncodeToString(String en)
	{
		tmp = en;
		try {
			en = URLDecoder.decode(tmp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	public void getAllStation(String city_name) //获取一些建筑的必要信息
	{
		newURL = baiduMapLink + StringToURLEncode(city_name);
		str = getCode(newURL);
		Matcher m1 = Pattern.compile("addr\":\"(.+?\")").matcher(str);
		Matcher m2 = Pattern.compile("address_norm\":\"(.+?\")").matcher(str);
		Matcher m3 = Pattern.compile("alias\":(.+?\\])").matcher(str);
		Matcher m4 = Pattern.compile("\"area\":(.+?,)").matcher(str);
		Matcher m5 = Pattern.compile("\"area_name\":(.+?\")").matcher(str);
		Matcher m6 = Pattern.compile("\"diPointX\":(.+?\")").matcher(str);
		Matcher m7 = Pattern.compile("\"diPointY\":(.+?\")").matcher(str);
		Matcher m8 = Pattern.compile("\"di_tag\":(.+?\")").matcher(str);
		while(m1.find() && m2.find() &&m3.find() &&m4.find() &&m5.find() &&m6.find() &&m7.find() &&m8.find())
		{
			bmi = new BaiduMapInfo();
			baiduMap_address = m1.group().replaceAll("addr\":\"|\"", "");
			baiduMap_address_norm = m2.group().replaceAll("address_norm\":\"|\"", "");
			baiduMap_alias = m3.group().replaceAll("alias\":|,\"", "");
			baiduMap_area_num = m4.group().replaceAll("\"area\":|,", "");
			baiduMap_area_name = m5.group().replaceAll("\"area_name\":\"|\"", "");
			baiduMap_pointX = m6.group().replaceAll("\"diPointX\":|,\"", "");
			baiduMap_pointY = m7.group().replaceAll("\"diPointY\":|,\"", "");
			baiduMap_tag = m8.group().replaceAll("\"di_tag\":|\"", "").replaceAll(" ", "-");
			bmi.setAddress(baiduMap_address);
			bmi.setAddress_norm(baiduMap_address_norm);
			bmi.setAlias(baiduMap_alias);
			bmi.setArea_name(baiduMap_area_name);
			bmi.setArea_num(baiduMap_area_num);
			bmi.setPointX(baiduMap_pointX);
			bmi.setPointY(baiduMap_pointY);
			bmi.setTag(baiduMap_tag);
			System.out.println(bmi.getAll());
		}
		
	}
	
	public List<BaiduMapInfo> getAllStationList(String city_name)
	{
		List<BaiduMapInfo> list = new ArrayList<>();
		newURL = baiduMapLink + StringToURLEncode(city_name);
		str = getCode(newURL);
		Matcher m1 = Pattern.compile("addr\":\"(.+?\")").matcher(str);
		Matcher m2 = Pattern.compile("address_norm\":\"(.+?\")").matcher(str);
		Matcher m3 = Pattern.compile("alias\":(.+?\\])").matcher(str);
		Matcher m4 = Pattern.compile("\"area\":(.+?,)").matcher(str);
		Matcher m5 = Pattern.compile("\"area_name\":(.+?\")").matcher(str);
		Matcher m6 = Pattern.compile("\"diPointX\":(.+?\")").matcher(str);
		Matcher m7 = Pattern.compile("\"diPointY\":(.+?\")").matcher(str);
		Matcher m8 = Pattern.compile("\"di_tag\":(.+?\")").matcher(str);
		while(m1.find() && m2.find() &&m3.find() &&m4.find() &&m5.find() &&m6.find() &&m7.find() &&m8.find())
		{
			bmi = new BaiduMapInfo();
			baiduMap_address = m1.group().replaceAll("addr\":\"|\"", "");
			baiduMap_address_norm = m2.group().replaceAll("address_norm\":\"|\"", "");
			baiduMap_alias = m3.group().replaceAll("alias\":|,\"", "");
			baiduMap_area_num = m4.group().replaceAll("\"area\":|,", "");
			baiduMap_area_name = m5.group().replaceAll("\"area_name\":\"|\"", "");
			baiduMap_pointX = m6.group().replaceAll("\"diPointX\":|,\"", "");
			baiduMap_pointY = m7.group().replaceAll("\"diPointY\":|,\"", "");
			baiduMap_tag = m8.group().replaceAll("\"di_tag\":|\"", "").replaceAll(" ", "-");
			bmi.setAddress(baiduMap_address);
			bmi.setAddress_norm(baiduMap_address_norm);
			bmi.setAlias(baiduMap_alias);
			bmi.setArea_name(baiduMap_area_name);
			bmi.setArea_num(baiduMap_area_num);
			bmi.setPointX(baiduMap_pointX);
			bmi.setPointY(baiduMap_pointY);
			bmi.setTag(baiduMap_tag);
			list.add(bmi);
		}
		return list;
	}
	
	public void getAll(String city_name)
	{
		getCity(city_name);
		getAllStation(city_name);
	}
	
	public List<BaiduMapInfo>  getAllList(String city_name)
	{
		List<BaiduMapInfo> l = new ArrayList<>();
		l.addAll(getAllStationList(city_name));
		l.addAll(getCityList(city_name));
		return l;
	}
	
	public void getCity(String city_name) //用来查询城市相关信息用的
	{
		newURL = baiduMapLink + StringToURLEncode(city_name);
		bmi = new BaiduMapInfo();
		str = getCode(newURL);
		Matcher m1 = Pattern.compile("up_province_name\":\"(.+?\")").matcher(str);
		Matcher m2 = Pattern.compile("point\":(.+?\\})").matcher(str);
		Matcher m3 = Pattern.compile("std_tag\":(.+?\")").matcher(str);
		if(m1.find() && m2.find()&&m3.find())
		{
			baiduMap_address = m1.group().replaceAll("up_province_name\":\"|\"", "")+city_name;
			baiduMap_pointX = m2.group().replaceAll("point\":|\\{|\\}", "").split(",")[0].replaceAll("\"|x|:", "");
			baiduMap_pointY = m2.group().replaceAll("point\":|\\{|\\}", "").split(",")[1].replaceAll("\"|y|:", "");
			baiduMap_tag = m3.group().replaceAll("std_tag\":\"|\"", "");
			bmi.setAddress(baiduMap_address);
			bmi.setTag(baiduMap_tag);
			bmi.setPointX(baiduMap_pointX);
			bmi.setPointY(baiduMap_pointY);
		}
		try {
			if(bmi.getAddress() != null)
			{
				System.out.println(bmi.getAll());
			}else
			{
				throw new Exception("您可能填了个县级市或者比地级市低的城市名称,再或者抽风了,请重试");
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				throw new Exception("您可能填了个县级市或者比地级市低的城市名称,再或者抽风了,请重试");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public List<BaiduMapInfo> getCityList(String city_name)
	{
		List<BaiduMapInfo> list = new ArrayList<>();
		newURL = baiduMapLink + StringToURLEncode(city_name);
		bmi = new BaiduMapInfo();
		str = getCode(newURL);
		Matcher m1 = Pattern.compile("up_province_name\":\"(.+?\")").matcher(str);
		Matcher m2 = Pattern.compile("point\":(.+?\\})").matcher(str);
		Matcher m3 = Pattern.compile("std_tag\":(.+?\")").matcher(str);
		if(m1.find() && m2.find()&&m3.find())
		{
			baiduMap_address = m1.group().replaceAll("up_province_name\":\"|\"", "")+city_name;
			baiduMap_pointX = m2.group().replaceAll("point\":|\\{|\\}", "").split(",")[0].replaceAll("\"|x|:", "");
			baiduMap_pointY = m2.group().replaceAll("point\":|\\{|\\}", "").split(",")[1].replaceAll("\"|y|:", "");
			baiduMap_tag = m3.group().replaceAll("std_tag\":\"|\"", "");
			bmi.setAddress(baiduMap_address);
			bmi.setTag(baiduMap_tag);
			bmi.setPointX(baiduMap_pointX);
			bmi.setPointY(baiduMap_pointY);
		}
		try {
			if(bmi.getAddress() != null)
			{
//				System.out.println(bmi.getAll());
				list.add(bmi);
			}else
			{
				throw new Exception("您可能填了个县级市或者比地级市低的城市名称,再或者抽风了,请重试");
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				throw new Exception("您可能填了个县级市或者比地级市低的城市名称,再或者抽风了,请重试");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	
}
