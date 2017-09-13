package com.humworks.dcs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.UnitMeasure;
import com.humworks.dcs.service.UnitMeasureService;

@Controller
@RequestMapping("/manage/unit-measure")
public class UnitOfMeasureController {
	
	@Autowired
	private UnitMeasureService unitMeasureService;

	public void setUnitMeasureService(UnitMeasureService unitMeasureService) {
		this.unitMeasureService = unitMeasureService;
	}

	private final String page = "auth/administrator/unit_of_measure";

	@GetMapping(value={"","/","list"})
	public String list(Model model){
		return page;
	}
	
	@PostMapping(value={"/","list"})
	public String add(final RedirectAttributes redirectAttributes, @Valid @ModelAttribute UnitMeasure unit, BindingResult result){
		try{			
			if(result.hasErrors()) {
				return page;
			}
			if(unitMeasureService.save(unit)>0){
				redirectAttributes.addFlashAttribute("message", "Unit of Measure Created Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Create Unit Measure. Try again later.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Create Unit. Try again later.");
			return "redirect:/manage/unit-measure/";
		}
		return "redirect:/manage/unit-measure/";
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
