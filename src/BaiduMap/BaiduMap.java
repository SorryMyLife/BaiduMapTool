package BaiduMap;

/*
 * �����һ����װ�õ���Ҫ��
 * ����ֱ��ͨ����������һЩ����
 * ��Ȼ��Ҳ���Ե�����������
 * Ч������һ����
 * 
 * ��Ҫ����city���ԣ���Ϊ������city���ԵĻ�������ɿ�ָ���쳣������Ҳ�޷���������
 * 
 * 2018��11��27��19:31:02
 * */

import java.util.List;

public class BaiduMap {
	
	private String str[] = null;
	private String city;
	private BaiduMapValue bmv = new BaiduMapValue();
	private List<BaiduMapInfo> list = null;
	private BaiduMapPoint bmp = new BaiduMapPoint();
	
	public String getCity() //��ȡ����ĵ�������
	{
		return city;
	}
	
	public void setCity(String city) //���õ������� 
	{
		this.city = city;
	}
	
	private void fuck() //���������Ϣ
	{
		System.err.println("�����ó�������");
		System.err.println("please set city name");
		return;
	}
	
	public void isNull() //�ж��Ƿ����Ҫ��
	{
		try {
			if(city.equals(""))
			{
				fuck();
			}else if(city.length() < 1 )
			{
				fuck();
			}else if(city.equals(null))
			{
				fuck();
			}else if(city == null)
			{
				fuck();
			}else if(city.isEmpty())
			{
				fuck();
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				throw new Exception("please set city name || ���������ĳ���");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public String[] getAddress() //����һ���������͵ĵ�ַ
	{
		isNull();
		list=bmv.getAllList(city);
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getAddress();
		}
		return str;
	}
	
	public String[] getAddressNorm() //����һ���������͵ĵ�ַ����
	{
		isNull();
		list=bmv.getAllList(city);
		
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getAddress_norm();
		}
		return str;
	}
	
	public String[] getAreaNum() //����һ���������͵ĵ�������
	{
		isNull();
		list=bmv.getAllList(city);
		
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getArea_num();
		}
		return str;
	}
	
	public String[] getAreaName() //����һ���������͵ĵ�������
	{
		isNull();
		list=bmv.getAllList(city);
		
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getArea_name();
		}
		return str;
	}
	
	public String[] getPointXY() //����һ���������͵ĵ�ַ����
	{
		isNull();
		list=bmv.getAllList(city);
		
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getPointXY();
		}
		return str;
	}
	
	public String[] getAlias() //����һ���������͵ĵ�ַ����
	{
		isNull();
		list=bmv.getAllList(city);
		
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getAlias();
		}
		return str;
	}
	
	public String[] getTag() //����һ���������͵ı�ǩ
	{
		isNull();
		list=bmv.getAllList(city);
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getTag();
		}
		return str;
	}
	
	public String[] getAllArray() //����һ���������͵���������
	{
		isNull();
		list=bmv.getAllList(city);
		bmv.size = list.size();
		str = new String[bmv.size];
		for(int i = 0;i<bmv.size;i++)
		{
			str[i] = list.get(i).getAll();
		}
		return str;
	}
	
	public void getAll() //�����ȡ������������
	{
		isNull();
		bmv.getAll(city);
	}
	
	public List<BaiduMapInfo> getAllList() //����һ����BaiduMapInfo��list����
	{
		isNull();
		return bmv.getAllList(city);
	}
	
	public void getAddressXY(String X , String Y) //��ȡ�����ַ��Ϣ
	{
		System.out.println(bmp.printXY(X, Y));
	}
	
	public String[] getAddressXYArray(String X , String Y) //����һ���������͵������ַ��Ϣ
	{
		return bmp.printXYArray(X, Y);
	}
	
}
