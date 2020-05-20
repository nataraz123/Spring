package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.external.ExternalIccScoreComp;

@Service("cbService")
public class CrickScoreCompServiceImpl implements CrickScoreMgmtService {
	@Autowired
    private ExternalIccScoreComp extComp;
	
    

	@Override
	public String findScore(int mid) {
		String score=null;
		//use extenal comp ref
		score=extComp.getScore(mid);
		return score;
	}

}
