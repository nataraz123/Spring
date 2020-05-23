package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public final class EmployeeMgmtServiceImpl  implements EmployeeMgmtService{
	   @Autowired
		private  EmployeeDAO dao;
		
	

	@Override
	public @NonNull List<EmployeeDTO> fetchEmpsByDesgs(@NonNull String desg1,@NonNull String desg2) throws Exception {
		List<EmployeeDTO> listDTO=new ArrayList();
		List<EmployeeBO> listBO=null;
		//use DAO
		listBO=dao.getEmpsByDesgs(desg1, desg2);
		//copy listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}//class
