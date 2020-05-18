package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("irr")
@PropertySource("classpath:com/nt/commons/info.properties")
public class IntresetRateReplacer implements MethodReplacer {
	@Value("${intr.rate}")
	private  float  rate;
	
	
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
