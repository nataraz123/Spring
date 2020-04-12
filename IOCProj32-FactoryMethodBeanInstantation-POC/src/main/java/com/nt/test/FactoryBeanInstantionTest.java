package com.nt.test;

import java.util.Calendar;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;



public class FactoryBeanInstantionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Class clazz=null;
		Calendar cal=null;
		String s2=null;
		String s3=null;
	//create IOC container
		factory=new DefaultListableBeanFactory();
		 reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 //get Target bean class object
		 clazz=factory.getBean("c1",Class.class);
		 System.out.println("clazz obj class name::"+clazz.getClass()+"    data::::"+clazz.toString());
		 System.out.println("...........................................");
		cal=factory.getBean("cal",Calendar.class);
		System.out.println("cal obj class name::"+cal.getClass()+"   data:::"+cal.toString());
		System.out.println("..........................................");
		s2=factory.getBean("s2",String.class);
		System.out.println("s2 obect class name::"+s2.getClass()+" data:::"+s2.toString());
		System.out.println("................................................................");
		s3=factory.getBean("s3",String.class);
		System.out.println("s3 obect class name::"+s3.getClass()+" data:::"+s3.toString());
		
		
	}

}
