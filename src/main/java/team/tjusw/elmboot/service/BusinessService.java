package team.tjusw.elmboot.service;

import java.util.List;

import team.tjusw.elmboot.po.Business;

public interface BusinessService {
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

	public Business getBusinessById(Integer businessId);
}
