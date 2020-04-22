package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

public interface EmployeeService {
   public List<EmployeeResultDTO>  search(EmployeeDTO dto);
}
