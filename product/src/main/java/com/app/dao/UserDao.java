package com.app.dao;

import pojos.User;

public interface UserDao {
	User validateUser(String user_id,String password);

}
