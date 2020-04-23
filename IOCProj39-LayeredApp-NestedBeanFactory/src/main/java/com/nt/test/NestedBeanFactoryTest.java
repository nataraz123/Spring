package com.nt.test;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory pFactory=null,cFactory=null;
		XmlBeanDefinitionReader pReader=null,cReader=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create Parent IOC container
		pFactory=new DefaultListableBeanFactory();
		pReader=new XmlBeanDefinitionReader(pFactory);
		pReader.loadBeanDefinitions("com/nt/cfgs/business-tier-beans.xml");
		//create child IOC container
		cFactory=new DefaultListableBeanFactory(pFactory);
		cReader=new XmlBeanDefinitionReader(cFactory);
		cReader.loadBeanDefinitions("com/nt/cfgs/presentation-tier-beans.xml");
		//get Controller class object
		controller=cFactory.getBean("controller",MainController.class);
		//invoke methods
		try {
			listDTO=controller.fetchEmpsByDesgs("CLERK", "MANAGER");
			listDTO.forEach(dto->{
				System.out.println(dto);
				
			});
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("hello...");
		}
	}//main
}//class
