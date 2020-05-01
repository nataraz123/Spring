package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public  List<EmployeeBO>  getAllEmps();
	public EmployeeBO  getEmpByNo(int eno);
	public  int   updateEmpByNo(EmployeeBO bo);
	public  int  deleteEmpByNo(int no);

}
