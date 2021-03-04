package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface ShoppingService {
	
	//获取所有商城在售商品
	public List<Map<String,Object>> allCommodity();
			
	//下架在售商品
	public boolean offCommodity(BigInteger id);
			
	//延长发售时间
	public boolean addSaleTime(BigInteger id);
	
	//搜索框
	public List<Map<String,Object>> getCommodity(String str);

}
