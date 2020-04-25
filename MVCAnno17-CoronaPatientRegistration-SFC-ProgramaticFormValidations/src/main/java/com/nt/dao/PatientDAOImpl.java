package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PatientBO;
@Repository
public class PatientDAOImpl implements PatientDAO {
	private static final String PATIENT_REGISTRATION_QUERY="INSERT INTO CORONA_PATIENT VALUES(PATID_SEQ.NEXTVAL,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(PatientBO bo) {
		int  count=0;
		count=jt.update(PATIENT_REGISTRATION_QUERY, bo.getPatName(),bo.getAge(),bo.getLocation(),bo.getHospital());
		return count;
	}

}
