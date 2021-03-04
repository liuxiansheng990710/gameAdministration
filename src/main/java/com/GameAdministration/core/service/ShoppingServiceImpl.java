package com.GameAdministration.core.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GameAdministration.core.dao.ShoppingDao;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService{
	
	@Autowired
	ShoppingDao shoppingDao;

	@Override
	public List<Map<String, Object>> allCommodity() {
		List<Map<String,Object>> list = shoppingDao.allCommodity();
		return list;
	}

	@Override
	public boolean offCommodity(BigInteger id) {
		int offCommodity = shoppingDao.offCommodity(id);
		if(offCommodity>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addSaleTime(BigInteger id) {
		int addSaleTime = shoppingDao.addSaleTime(id);
		if(addSaleTime>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getCommodity(String str) {
		List<Map<String,Object>> commodityByName = shoppingDao.getCommodityByName(str);
		if(commodityByName != null  && commodityByName.size() >0){
			return commodityByName;
		}
		List<Map<String,Object>> commodityById = shoppingDao.getCommodityById(BigInteger.valueOf(Long.parseLong(str)));
		return commodityById;
	}

}
