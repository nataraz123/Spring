package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.nt.external.ExternalICCScoreCompImpl;
import com.nt.external.ExternalIccScoreComp;

@Component("locator")
public class IccScoreCompServiceLocator implements FactoryBean<ExternalIccScoreComp> {

	@Override
	public ExternalIccScoreComp getObject() throws Exception {
		ExternalIccScoreComp extComp=null;
		//Actually here we should written jndi lookup code.. Since we have Extenal comp as
		// ordinary java class.. we are going create and return object manually
		extComp=new ExternalICCScoreCompImpl();
		return extComp;
	}

	@Override
	public Class<?> getObjectType() {
	
		return ExternalICCScoreCompImpl.class;
	}
	
	@Override
	public boolean isSingleton() {
	  return true;
	}

}
