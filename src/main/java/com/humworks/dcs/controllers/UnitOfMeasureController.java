package com.humworks.dcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.UnitMeasure;
import com.humworks.dcs.service.UnitMeasureService;

@Controller
@RequestMapping("/manage/unit-measure/")
public class UnitOfMeasureController {
	
	@Autowired
	private UnitMeasureService unitMeasureService;

	private final String page = "auth/administrator/unit_of_measure";

	@GetMapping(value={"/","list"})
	public String list(Model model){
		return page;
	}
	
	@ModelAttribute("unit")
	public UnitMeasure getUnit(){
		return new UnitMeasure();
	}
	
	@ModelAttribute("unitList")
	public List<UnitMeasure> getUnitList(){
		return unitMeasureService.selectAll();
	}
	
	
}
