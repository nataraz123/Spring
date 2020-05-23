package com.nt.dao;

import java.util.List;

import org.springframework.lang.NonNull;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public @NonNull List<EmployeeBO>  getEmpsByDesgs(@NonNull String desg1,@NonNull String desg2)throws Exception;

}
