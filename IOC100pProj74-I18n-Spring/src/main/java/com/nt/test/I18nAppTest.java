package com.nt.test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;

public class I18nAppTest {

	public static void main(String[] args) {
	    Locale locale=null;
	    String lsno=null,lsname=null,lsadd=null,cap1=null,cap2=null,cap3=null,cap4=null;
	    JFrame frame=null;
	    JLabel lno=null,lname=null,ladd=null;
	    JTextField tno=null,tname=null,tadd=null;
	    JButton btn1=null,btn2=null,btn3=null,btn4=null;
	    ApplicationContext ctx=null;
	    //create Locale object
	    locale=new Locale(args[0],args[1]);
	    //create IOC container
	     ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	    // String Labels by submitting keys
	    lsno=ctx.getMessage("sno.label", new Object[] {"customer"}, "msg1", locale);
	    lsname=ctx.getMessage("sname.label", new Object[] {}, "msg2", locale);
	    lsadd=ctx.getMessage("sadd.label", new Object[] {}, "msg3", locale);
	    cap1=ctx.getMessage("btn1.cap", new Object[] {}, "msg4", locale);
	    cap2=ctx.getMessage("btn2.cap", new Object[] {}, "msg5", locale);
	    cap3=ctx.getMessage("btn3.cap", new Object[] {}, "msg6", locale);
	    cap4=ctx.getMessage("btn4.cap", new Object[] {}, "msg7", locale);
	     String label11=ctx.getMessage("sno.label", new Object[] {"customer", "label11"}, new Locale("hi","IN"));
	     System.out.println(label11);
	    
	    //create  JFRame
	    frame=new JFrame();
	    frame.setLayout(new FlowLayout());
	    frame.setSize(300,300);
	    frame.setBackground(Color.DARK_GRAY);
	    frame.setTitle("I18n App");
	    lno=new JLabel(lsno);
	    frame.add(lno);
	    tno=new JTextField(10);
	    frame.add(tno);
	    
	    lname=new JLabel(lsname);
	    frame.add(lname);
	    tname=new JTextField(10);
	    frame.add(tname);
	    
	    ladd=new JLabel(lsadd);
	    frame.add(ladd);
	    tadd=new JTextField(10);
	    frame.add(tadd);
		
	    btn1=new JButton(cap1);
	    btn2=new JButton(cap2);
	    btn3=new JButton(cap3);
	    btn4=new JButton(cap4);
	    frame.add(btn1); frame.add(btn2); frame.add(btn3);
	    frame.add(btn4);
	    
	    frame.setVisible(true);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
       //close container
	    ((AbstractApplicationContext) ctx).close();
	}//main

}//class
