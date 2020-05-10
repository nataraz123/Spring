package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("downloadService")
public class DownloadOperationsServiceImpl implements DownloadOperationsService {

	@Override
	public List<String> fetchFiles(String uploadDir) {
		File uplDir=null;
		File files[]=null;
		List<String>  listFiles=null;
		//get all file names from uploaded folder store
		uplDir=new File(uploadDir);
		files=uplDir.listFiles();
		listFiles=new ArrayList();
		for(File file:files) {
			if(!file.isDirectory())
               listFiles.add(file.getName());
		}
		
	   return listFiles;
	}

}
