package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public final class StudentDAOImpl implements StudentDAO {
	private  String os;
	private String javaVendor;
	private String pathVal;
	
	private static final String 
	INSERT_STUDENT_QUERY="INSERT INTO SPRING_LAYERED_STUDENT(SNAME,SADD,TOTAL,AVG,RESULT) VALUES(?,?,?,?,?)";
			
	private DataSource ds;
	
	public StudentDAOImpl(DataSource ds) {
	   System.out.println("StudentDAOImpl:: 1-param constructor");
		this.ds = ds;
	}
	
	public void setOs(String os) {
		System.out.println("StudentDAOImpl.setOs(-)");
		this.os = os;
	}

	public void setJavaVendor(String javaVendor) {
		System.out.println("StudentDAOImpl.setJavaVendor(-)");
		this.javaVendor = javaVendor;
	}
	
	public void setPathVal(String pathVal) {
		this.pathVal = pathVal;
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		System.out.println("system properties ::"+os +"    "+javaVendor+"         "+pathVal);
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled JDBC con object  using the injected DataSource object
		con=ds.getConnection();
		//create JDBC PreparedStatement object having preCompiled SQL Query
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		//set values to query param by gathering  BO class object
		ps.setString(1,bo.getSname());
		ps.setString(2,bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		//execute the pre-compiled SQL Query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}
