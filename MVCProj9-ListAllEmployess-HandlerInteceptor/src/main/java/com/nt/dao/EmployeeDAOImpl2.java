package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;

public class EmployeeDAOImpl2 implements EmployeeDAO {
	private static final String  GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ";
	private JdbcTemplate jt;

	public EmployeeDAOImpl2(JdbcTemplate jt) {
			this.jt = jt;
	}

	@Override
	public List<EmployeeBO> getAllEmps() {
		List<EmployeeBO> listBO1=null;
		listBO1=jt.query(GET_ALL_EMPS, 
				      					 rs->{
						List<EmployeeBO> listBO=null;
						EmployeeBO bo=null;
						// copy ResultSet object records BO class objects and add them to List Collection
						listBO=new ArrayList();
						while(rs.next()) {
							//copy each record to BO class object
							bo=new EmployeeBO();
							bo.setEmpNo(rs.getInt(1));
							bo.setEname(rs.getString(2));
							bo.setJob(rs.getString(3));
							bo.setSal(rs.getFloat(4));
							bo.setDeptNo(rs.getInt(5));
							//add each BO class object to List Collection
							listBO.add(bo);
						}//while
						
						return listBO;
					}//inner class
		);
		return listBO1;
	}
	
	

}//outer class
