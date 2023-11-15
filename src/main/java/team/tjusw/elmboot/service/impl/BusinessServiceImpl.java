package team.tjusw.elmboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tjusw.elmboot.mapper.BusinessMapper;
import team.tjusw.elmboot.po.Business;
import team.tjusw.elmboot.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessMapper businessMapper;
	
	
	@Override
	public Business getBusinessById(Integer businessId) {
		return businessMapper.getBusinessById(businessId);
	}
	
	
	@Override
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
		return businessMapper.listBusinessByOrderTypeId(orderTypeId);
	}

	

	

}
