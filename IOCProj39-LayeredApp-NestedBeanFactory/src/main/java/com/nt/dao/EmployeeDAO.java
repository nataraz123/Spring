package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public  List<EmployeeBO>  getEmpsByDesgs(String desg1,String desg2)throws Exception;

}
