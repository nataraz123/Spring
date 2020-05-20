package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("langService")
public class FetchLanguagesServiceImpl implements FetchLanguagesService {

	@Override
	public List<String> fetchAllLanguages() {
		Locale locales[]=null;
		List<String> langList=null;
		//get All Locales
		locales=Locale.getAvailableLocales();
		// get all languges
		langList=new ArrayList();
		for(Locale l:locales) {
			langList.add(l.getDisplayLanguage());
		}
		return langList;
	}

}
