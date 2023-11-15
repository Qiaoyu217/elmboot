package team.tjusw.elmboot.service;

import java.util.List;

import team.tjusw.elmboot.po.Cart;

public interface CartService {
	public List<Cart> listCart(Cart cart);

	public int removeCart(Cart cart);
	
	
	public int saveCart(Cart cart);

	public int updateCart(Cart cart);
}
