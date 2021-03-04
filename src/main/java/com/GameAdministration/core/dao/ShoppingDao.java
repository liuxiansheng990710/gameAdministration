package com.GameAdministration.core.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface ShoppingDao {
	
	//获取所有商城在售商品
	public List<Map<String,Object>> allCommodity();
	
	//下架在售商品
	public int offCommodity(BigInteger id);
	
	//延长发售时间
	public int addSaleTime(BigInteger id);
	
	//根据id获取商城在售商品
	public List<Map<String,Object>> getCommodityById(BigInteger id);
	
	//根据商品名获取商品
	public List<Map<String,Object>> getCommodityByName(String name);

}
