package com.nt.service;

import java.util.List;

import org.springframework.lang.NonNull;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public  @NonNull List<EmployeeDTO> fetchEmpsByDesgs(@NonNull String desg1,@NonNull String desg2)throws Exception;

}
