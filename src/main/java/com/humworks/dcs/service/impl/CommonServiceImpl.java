package com.humworks.dcs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.service.CommonService;

@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {

	@Override
	public Integer getIdFromUrl(String url) {
		try{
			String fProc = url.substring(url.lastIndexOf("-") + 1).trim();
			return Integer.parseInt(fProc.substring(3, fProc.length()));
		}catch(Exception ex){
			return 0;
		}
	}

	@Override
	public String getNameFromUrl(String url) {
		try{
			return url.substring(0,url.lastIndexOf("-")).trim();
		}catch(Exception ex){
			return "";
		}
	}

	@Override
	public Integer getPatternFromUrl(String pattern) {
		try{
			return Integer.parseInt(pattern.substring(3, pattern.length()));
		}catch(Exception ex){
			return 0;
		}
	}

}
