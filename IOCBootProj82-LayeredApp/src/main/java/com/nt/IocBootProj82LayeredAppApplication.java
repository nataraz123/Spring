package com.nt;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

@SpringBootApplication
public class IocBootProj82LayeredAppApplication {
	
	

	public static void main(String[] args) {
		ConfigurableApplicationContext  ctx=null;
		MainController controller=null;
		StudentVO vo=null;
		String result=null;
		//Boot Strapping 
		ctx=SpringApplication.run(IocBootProj82LayeredAppApplication.class, args);
		//get IOC container
		controller =ctx.getBean("controller",MainController.class);
		//create vo class object
		vo=new StudentVO();
		vo.setSname("raja"); vo.setSadd("hyd"); vo.setM1("90"); vo.setM2("80"); vo.setM3("80");
		//invoke method
		try{
			result=controller.handleStudent(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		ctx.close();
	}

}
