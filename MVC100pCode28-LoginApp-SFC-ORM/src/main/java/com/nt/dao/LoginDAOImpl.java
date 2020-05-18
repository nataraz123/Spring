package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final String HQL_AUTH_QUERY="SELECT COUNT(*) FROM UserBO WHERE username=:un AND password=:pwd ";
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public long validate(UserBO bo) {
		List<?> list=null;
		long  count=0;
	   list=ht.findByNamedParam(HQL_AUTH_QUERY, new String[] {"un","pwd"},
			                                             new Object[] {bo.getUsername(),bo.getPassword()});
	   count=(long) list.get(0);
	   return count;
	}

}
