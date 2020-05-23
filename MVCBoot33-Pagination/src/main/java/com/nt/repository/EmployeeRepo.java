package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
