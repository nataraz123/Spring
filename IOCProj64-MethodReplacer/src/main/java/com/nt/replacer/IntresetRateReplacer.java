package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class IntresetRateReplacer implements MethodReplacer {
	private  float  rate;
	
	public  void setRate(float rate) {
		this.rate=rate;
	}

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("IntresetRateReplacer.reimplement(-,-,-)----> new logic");
		System.out.println(obj.getClass()+"  "+method.getName()+"  "+Arrays.deepToString(args));
		float pAmt=0.0f;
		float time=0.0f;
		pAmt=(float)args[0];
		time=(float)args[1];
		return (pAmt*rate*time)/100.0f;
		
		
	}

}
