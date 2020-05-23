package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtSeviceImpl implements EmployeeMgmtService {
	@Autowired
	@Qualifier("empDAO")
	private  EmployeeDAO  dao;

	

	@Override
	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method



	@Override
	public EmployeeDTO fetchEmpByNo(int no) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmpByNo(no);
		//convet bo to dto
		 dto=new EmployeeDTO();
		 BeanUtils.copyProperties(bo, dto);
		return dto;
	}



	@Override
	public String modifyEmpByNo(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.updateEmpByNo(bo);
		
		return (count==0)?"Employee updation failed" : "Employee updation succedded";
	}
	
	@Override
	public String removeEmpByNo(int no) {
		int count=0;
		//use DAO
		count=dao.deleteEmpByNo(no);
		return (count==0)?"Employee deletion failed" : "Employee deletion succedded";
	}

}//class
