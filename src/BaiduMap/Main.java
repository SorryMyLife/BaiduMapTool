package BaiduMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试用的类，没有太大意义，
		//2018年11月27日19:32:40
		
		BaiduMap bm = new BaiduMap();
		bm.setCity("北京站");
		bm.getAll();
		bm.getAddressXY("1296146423", "482512326");
		
		
	}

}
