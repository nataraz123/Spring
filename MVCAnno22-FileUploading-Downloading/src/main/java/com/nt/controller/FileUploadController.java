package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.UploadCommand;
import com.nt.service.DownloadOperationsService;

@Controller
public class FileUploadController {
	@Autowired
	private DownloadOperationsService service;
	
	@GetMapping("/upload.htm")  //initial phase request
	public String  showForm(@ModelAttribute("uplCmd") UploadCommand cmd) {
		return "file_upload";
	}
	
	
	@PostMapping("/upload.htm")
	public     String  uploadForm(Map<String,Object> map,
			                                                @ModelAttribute("uplCmd") UploadCommand cmd,
			                                                HttpServletRequest req,
			                                                BindingResult errors) throws Exception{
		ServletContext sc=null;
		String location=null;
		File file=null;
		String resumefile=null,photofile=null;
		InputStream ris=null,pis=null;
		OutputStream ros=null,pos=null;
		// get acess to Servletcontext object
		sc=req.getServletContext();
		// read context param value
		location=sc.getInitParameter("uploadFolder");
		//check the folder availability, if not available create it
		file=new File(location);
		if(!file.exists())
			file.mkdir();
		// get the names of the uploaded files 
		 resumefile=cmd.getEresume().getOriginalFilename();
		 photofile=cmd.getEphoto().getOriginalFilename();
		//get Inputstreams representing uploaded files content
		ris=cmd.getEresume().getInputStream();
		pis=cmd.getEphoto().getInputStream();
		//create OuputStreams pointing empty destination files on the server machine file system
		ros=new FileOutputStream(location+"/"+resumefile);
		pos=new FileOutputStream(location+"/"+photofile);
		//complete file copy operation
		IOUtils.copy(ris,ros);
		IOUtils.copy(pis,pos);
		//close streams
		ris.close();
		ros.close();
		pis.close();
		pos.close();
		// keep the names of uploaded files as the model attributes
		map.put("filename1",resumefile);
		map.put("filename2",photofile);
		//return lvn
		return "success_upload";
	}
	
	
	@RequestMapping("/list_files.htm")
	public  String   listUploadedFiles(Map<String,Object> map,HttpServletRequest req) {
		 ServletContext sc=null;
		 String uploadDir=null;
		 List<String> filesList=null;
		//get Access to ServletContext object
		 sc=req.getServletContext();
		uploadDir=sc.getInitParameter("uploadFolder");
		//use service
		filesList=service.fetchFiles(uploadDir);
		//model attribute
		map.put("filesList", filesList);
		//return lvn
		return "show_files";
	}
	
	@RequestMapping("/download.htm")
	public String   downloadFile(HttpServletRequest req,HttpServletResponse res) throws Exception{
		 ServletContext sc=null;
		 String fname=null;
		 File file=null;
		 String mimeType=null;
		 InputStream is=null;
		 OutputStream os=null;
		//get Access to ServletContext object
		 sc=req.getServletContext();
		 //read addtional req param value to get filename to be downloaded
		 fname=req.getParameter("fileName");
		 // Locate the file
		 file=new File(sc.getInitParameter("uploadFolder")+"/"+fname);
		 //get Length of the file and make it as response content length
		 res.setContentLengthLong(file.length());
		 //get the MIME type of the file and make it as response content type
		 mimeType=sc.getMimeType(file.getAbsolutePath());
		 res.setContentType(mimeType!=null?mimeType:"application/octet-stream");		 
		 // get InputStream pointing to the file
		 is=new FileInputStream(file);
		 //create OutputStream pointing to response object
		 os=res.getOutputStream();
		 //Instruct browser to make recieved output as downloadable file
		 res.addHeader("Content-Disposition","attachment;fileName="+fname);
		 //copy File content to response object
		 IOUtils.copy(is, os);
		 //close the streams
		 is.close();
		 os.close();
		 
		return null;
	}

}
