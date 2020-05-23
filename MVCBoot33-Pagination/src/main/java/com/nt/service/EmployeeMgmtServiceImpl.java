package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeRepo  empRepo;
	

	@Override
	public int getPagesCount(int pageSize) {
		int pagesCount=0;
		long recordsCount=0;
		
		recordsCount=empRepo.count();
		pagesCount=(int) (recordsCount/pageSize);
		if(recordsCount%pageSize!=0)
			pagesCount++;
		return pagesCount;
	}

	@Override
	public List<EmployeeDTO> getPageData(int pageNo,int pageSize) {
		Pageable pageable=null;
		Page<Employee> page=null;
		List<Employee> listEntities=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//create Pageable object
		pageable=PageRequest.of(pageNo, pageSize,Sort.by("ename").ascending());
		//get Page object
		page=empRepo.findAll(pageable);
		//listEntities=page.getContent();
		//covert to listEntities
		listEntities=page.get().collect(Collectors.toList());  //java8 stream api
		//convert listEntities to listDTO
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

}//class
