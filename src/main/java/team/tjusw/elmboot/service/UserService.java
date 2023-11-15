package team.tjusw.elmboot.service;

import team.tjusw.elmboot.po.User;

public interface UserService {
	public Object getUserByIdByPass(User user);



	public int saveUser(User user);
	
	public int getUserById(String userId);
}
