package org.BaiduMap;

/**
* <p>创建时间：2019年6月27日 下午3:22:20
* <p>项目名称：BaiduMap
* 
* <p>类说明：
*测试功能用
* @version 1.0
* @since JDK 1.8
* 文件名称：Main.java
* */
public class Main {
	public static void main(String[] args) {
		BaiduMap bm = new BaiduMap();
		System.err.println(bm.getByJsonData("北京站"));
	}
}
