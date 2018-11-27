package BaiduMap;

/*
 * ������ѯ���ڰٶȵ�ͼ�����
 * 
 * 2018��11��27��19:32:24 
 * */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiduMapPoint {
	
	private BaiduMapValue bmv;
	private BaiduMapInfo bmi;
	
	public String printXY(String X , String Y) //���ز�ѯ�����������
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
			bmi.setAddress(m1.group(0).replaceAll("addr\":\"|\"", ""));//��ַ
			bmi.setTag(m2.group().replaceAll("\"tag\":\"|\"", ""));//��ǩ
			bmi.setAlias(m3.group().replaceAll("\"business\":\"|\"", ""));//��ҵ
			bmi.setAddress_norm(m4.group().replaceAll("\"country\":\"|\"", ""));//����
			bmv.tmp = "��������: "+bmi.getAddress_norm()+"\nĿ���ַ: "+bmi.getAddress() + "\nĿ���ǩ: "+bmi.getTag()+"\n����: "+bmi.getAlias()+"\n";
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
			bmi.setAddress(m1.group(0).replaceAll("addr\":\"|\"", ""));//��ַ
			bmi.setTag(m2.group().replaceAll("\"tag\":\"|\"", ""));//��ǩ
			bmi.setAlias(m3.group().replaceAll("\"business\":\"|\"", ""));//��ҵ
			bmi.setAddress_norm(m4.group().replaceAll("\"country\":\"|\"", ""));//����
//			bmv.tmp = "��������: "+bmi.getAddress_norm()+"\nĿ���ַ: "+bmi.getAddress() + "\nĿ���ǩ: "+bmi.getTag()+"\n��ҵ����: "+bmi.getAlias()+"\n";
			s[0] = bmi.getAddress_norm();
			s[1] = bmi.getAddress();
			s[2] = bmi.getTag();
			s[3] = bmi.getAlias();
		}
		return s;
	}
	
	
}
