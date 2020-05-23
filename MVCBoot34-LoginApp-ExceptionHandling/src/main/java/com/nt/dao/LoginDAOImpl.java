package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST1 WHERE UNAME=? AND PWD=? ";
	@Autowired
	private  JdbcTemplate  jt;

	@Override
	public int validate(UserBO bo) {
	  int count=0;
	  count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}

}
