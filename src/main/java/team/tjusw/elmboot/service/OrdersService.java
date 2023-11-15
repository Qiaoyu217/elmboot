package team.tjusw.elmboot.service;

import java.util.List;

import team.tjusw.elmboot.po.Orders;

public interface OrdersService {
	public int createOrders(Orders orders);

	public Orders getOrdersById(Integer orderId);

	public List<Orders> listOrdersByUserId(String userId);
}
