package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<Date> {
	private int year;
	private int month;
	private  int day;
	
public DateFactoryBean() {
	System.out.println("DateFactoryBean.DateFactoryBean()");
}
	

	public void setYear(int year) {
		System.out.println("DateFactoryBean.setYear()");
		this.year = year;
	}

	
	public void setMonth(int month) {
		System.out.println("DateFactoryBean.setMonth()");
		this.month = month;
	}

	

	public void setDay(int day) {
		System.out.println("DateFactoryBean.setDay()");
		this.day = day;
	}

	@Override
	public Date getObject() throws Exception {
		System.out.println("DateFactoryBean.getObject()");
		return new Date((year-1900),month-1,day);
	}

	@Override
	public Class<?> getObjectType() {
	System.out.println("DateFactoryBean.getObjectType()");
		return Date.class;
	}
	
	@Override
	public boolean isSingleton() {
		System.out.println("DateFactoryBean.isSingleton()");
		return false;
	}

}
