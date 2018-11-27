package BaiduMap;

/*
 * 这个是一个封装好的主要类
 * 可以直接通过这个类调用一些方法
 * 当然你也可以调用其他的类
 * 效果都是一样的
 * 
 * 需要设置city属性，因为不设置city属性的话，会造成空指针异常，程序也无法正常运行
 * 
 * 2018年11月27日19:31:02
 * */

import java.util.List;

public class BaiduMap {
	
	private String str[] = null;
	private String city;
	private BaiduMapValue bmv = new BaiduMapValue();
	private List<BaiduMapInfo> list = null;
	private BaiduMapPoint bmp = new BaiduMapPoint();
	
	public String getCity() //获取输入的地区名称
	{
		return city;
	}
	
	public void setCity(String city) //设置地区名称 
	{
		this.city = city;
	}
	
	private void fuck() //输出报错信息
	{
		System.err.println("请设置城市名字");
		System.err.println("please set city name");
		return;
	}
	
	public void isNull() //判断是否符合要求
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
				throw new Exception("please set city name || 请设置您的城市");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public String[] getAddress() //返回一个数组类型的地址
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
	
	public String[] getAddressNorm() //返回一个数组类型的地址范数
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
	
	public String[] getAreaNum() //返回一个数组类型的地区号码
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
	
	public String[] getAreaName() //返回一个数组类型的地区名称
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
	
	public String[] getPointXY() //返回一个数组类型的地址坐标
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
	
	public String[] getAlias() //返回一个数组类型的地址别名
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
	
	public String[] getTag() //返回一个数组类型的标签
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
	
	public String[] getAllArray() //返回一个数组类型的所有内容
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
	
	public void getAll() //输出获取到的所有内容
	{
		isNull();
		bmv.getAll(city);
	}
	
	public List<BaiduMapInfo> getAllList() //返回一个带BaiduMapInfo的list类型
	{
		isNull();
		return bmv.getAllList(city);
	}
	
	public void getAddressXY(String X , String Y) //获取坐标地址信息
	{
		System.out.println(bmp.printXY(X, Y));
	}
	
	public String[] getAddressXYArray(String X , String Y) //返回一个数组类型的坐标地址信息
	{
		return bmp.printXYArray(X, Y);
	}
	
}
