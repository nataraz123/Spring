package com.nt.service;

import com.nt.external.ExternalIccScoreComp;
import com.nt.locator.IccScoreCompServiceLocator;

public class CrickScoreCompServiceImpl implements CrickScoreMgmtService {
    private ExternalIccScoreComp extComp;
	
    public CrickScoreCompServiceImpl(ExternalIccScoreComp extComp) {
	
		this.extComp = extComp;
	}

	@Override
	public String findScore(int mid) {
		String score=null;
		//use extenal comp ref
		score=extComp.getScore(mid);
		return score;
	}

}
