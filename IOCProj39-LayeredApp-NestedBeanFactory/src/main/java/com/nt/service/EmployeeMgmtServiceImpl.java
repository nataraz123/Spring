package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public final class EmployeeMgmtServiceImpl  implements EmployeeMgmtService{
		private  EmployeeDAO dao;
		
	public EmployeeMgmtServiceImpl(EmployeeDAO dao,String type) {
			this.dao = dao;
			System.out.println("Container :::"+type);
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2) throws Exception {
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
