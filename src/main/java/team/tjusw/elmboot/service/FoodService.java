package team.tjusw.elmboot.service;

import java.util.List;

import team.tjusw.elmboot.po.Food;

public interface FoodService {
	public List<Food> listFoodByBusinessId(Integer businessId);

}
