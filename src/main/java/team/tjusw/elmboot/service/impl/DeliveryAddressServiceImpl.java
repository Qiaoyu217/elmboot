package team.tjusw.elmboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tjusw.elmboot.mapper.DeliveryAddressMapper;
import team.tjusw.elmboot.po.DeliveryAddress;
import team.tjusw.elmboot.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

	@Autowired
	private DeliveryAddressMapper deliveryAddressMapper;


	@Override
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
		return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
	}
	
	
	@Override
	public DeliveryAddress getDeliveryAddressById(Integer daId) {
		return deliveryAddressMapper.getDeliveryAddressById(daId);
	}
	
	@Override
	public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
		return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
	}
	
	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
	}

	
	

	@Override
	public int removeDeliveryAddress(Integer daId) {
		return deliveryAddressMapper.removeDeliveryAddress(daId);
	}
	
	
	


	

}
