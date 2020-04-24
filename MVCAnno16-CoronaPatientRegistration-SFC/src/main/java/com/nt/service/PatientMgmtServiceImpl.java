package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.PatientBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDTO;

@Service
public class PatientMgmtServiceImpl implements PatientMgmtService {
	@Autowired
	private PatientDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(PatientDTO dto) {
		int count=0;
		PatientBO bo=null;
		//convert dto to bo
		bo=new PatientBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
				return count==0?"Patient Registration Failed":"Patient Registration succeded";
	}

}
