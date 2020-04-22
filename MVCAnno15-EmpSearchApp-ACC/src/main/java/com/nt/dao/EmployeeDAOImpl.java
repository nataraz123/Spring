package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;

@Repository("/empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMP_DETAILS="(SELECT EMPNO,ENAME,SAL,JOB,DEPTNO,MGR FROM EMP WHERE (EMPNO IS NOT NULL AND EMPNO=?) or  (ENAME IS NOT NULL  AND ENAME LIKE ?) or (JOB IS NOT NULL  AND JOB LIKE ?)  or   (SAL IS NOT NULL AND SAL >=?))"; 
			
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public List<EmployeeResultBO> find(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO=null;
		listRBO=jt.query(GET_EMP_DETAILS,
				                             rs->{
				                            	 List<EmployeeResultBO> listRBO1=null;
				                            	 EmployeeResultBO rbo=null;
				                            	 listRBO1=new ArrayList();
				                            	 while(rs.next()) {
				                            		 rbo=new EmployeeResultBO();
				                            		 rbo.setEmpno(rs.getInt(1));
				                            		 rbo.setEname(rs.getString(2));
				                            		 rbo.setJob(rs.getString(4));
				                            		 rbo.setSal(rs.getFloat(3));
				                            		 rbo.setDeptno(rs.getInt(5));
				                            		 System.out.println(rbo.getDeptno());
				                            		 rbo.setMgr(rs.getInt(6));
				                            		 listRBO1.add(rbo);
				                            	 }
				                            	 return listRBO1;
				                             },
				                             bo.getEmpno(),bo.getEname(),bo.getJob(),bo.getSal());
		
		return listRBO;
	}//method

}//class
