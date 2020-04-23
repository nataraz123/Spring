package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;


public final class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN(?,?)";
	private DataSource ds;
	

	public EmployeeDAOImpl(DataSource ds) {
		
		this.ds = ds;
	}


	@Override
	public List<EmployeeBO> getEmpsByDesgs(String desg1, String desg2) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet  rs=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		try {
			//get Pooled JDBC con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(GET_EMPS_BY_DESGS);
			//set query param values
			ps.setString(1,desg1);
			ps.setString(2,desg2);
			//execute the query
			rs=ps.executeQuery();
			//copy RS records  to Listof BO objects
			listBO=new ArrayList();
			while(rs.next()) {
				//copy each record of RS to BO class object
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgr(rs.getInt(6));
				//add each BO class object to listBO
				listBO.add(bo);
			}//while
			
		}//try
		/*catch(SQLException se) {
			se.printStackTrace();
			throw se;  //exceptio rethrowing...
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}*/
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
	   
		
		return listBO;
	}//method

}//class
