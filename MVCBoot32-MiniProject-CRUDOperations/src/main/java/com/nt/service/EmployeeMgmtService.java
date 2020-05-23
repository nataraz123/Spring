package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public  List<EmployeeDTO>  fetchAllEmps();
	public  EmployeeDTO   fetchEmpByNo(int no);
	public  String   modifyEmpByNo(EmployeeDTO dto);
	public   String   removeEmpByNo(int no);

}
