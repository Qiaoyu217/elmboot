package team.tjusw.elmboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.tjusw.elmboot.mapper.UserMapper;
import team.tjusw.elmboot.po.User;
import team.tjusw.elmboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Object getUserByIdByPass(User user) {
		User ret = userMapper.getUserByIdByPass(user);
		if(ret==null)
			return "null";
		return ret;
					
	}
	
	@Override
	public int getUserById(String userId) {
		return userMapper.getUserById(userId);
	}
	
	@Override
	public int saveUser(User user) {
		return userMapper.saveUser(user);
	}

	
	

	
}
