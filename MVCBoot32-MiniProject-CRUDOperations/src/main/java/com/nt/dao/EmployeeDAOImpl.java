package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ";
	private  static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private  static final String UPDATE_EMP_BY_NO="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	private  static final String DELETE_EMP_BY_NO="DELETE  FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	
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


	@Override
	public EmployeeBO getEmpByNo(int eno) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_NO, (rs,index)->{
			  EmployeeBO bo1=null;
			  //copy ResultSet object record to  BO class object
			  bo1=new EmployeeBO();
			  bo1.setEmpNo(rs.getInt(1));
			  bo1.setEname(rs.getString(2));
			  bo1.setJob(rs.getString(3));
			  bo1.setSal(rs.getFloat(4));
			  bo1.setDeptNo(rs.getInt(5));
			  return bo1;
			
		}, eno);
		
		return bo;
		
	}//method


	@Override
	public int updateEmpByNo(EmployeeBO bo) {
		int count=0;
		count=jt.update(UPDATE_EMP_BY_NO, bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo(),bo.getEmpNo());
		return count;
	}


	@Override
	public int deleteEmpByNo(int no) {
		int  count=0;
		
		count=jt.update(DELETE_EMP_BY_NO,no);
		return count;
	}
	
	

}//outer class
