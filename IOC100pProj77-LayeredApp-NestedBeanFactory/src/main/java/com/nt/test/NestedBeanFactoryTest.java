package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		ApplicationContext parentCtx=null,childCtx=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create parent IOC container
		parentCtx=new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create child IOC container
		childCtx=new AnnotationConfigApplicationContext(PresentationConfig.class);
		//set parent
		((AnnotationConfigApplicationContext)childCtx).setParent(parentCtx);
		
		
		//get Controller class object
		controller=childCtx.getBean("controller",MainController.class);
		//invoke methods
		try {
			listDTO=controller.fetchEmpsByDesgs("CLERK", "MANAGER");
			listDTO.forEach(dto->{
				System.out.println(dto);
				
			});
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
		
		}
		
		//close the container
		((AbstractApplicationContext) childCtx).close();
		((AbstractApplicationContext) parentCtx).close();
	}//main
}//class
