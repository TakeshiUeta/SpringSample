package com.Example.demothimeleaf.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class UserApplicationService {
	/**性別のMAPを生成する*/
	public Map<String, Integer> getGenderMap(){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("男性",1);
		genderMap.put("女性",2);
		return genderMap;
	}
}
