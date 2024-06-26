package com.pat.DAO;

import java.util.List;

import com.pat.modren.user;

public interface userDAO {
	void save(user user);
    user getUserById(int userId);
    List<user> getAll();
    void update(user user);
    void delete(int userId);
    user validateUser(String email, String password) ;
		
}
