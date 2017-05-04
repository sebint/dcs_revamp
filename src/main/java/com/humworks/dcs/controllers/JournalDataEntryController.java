package com.humworks.dcs.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.JsonDesignRequest;
import com.humworks.dcs.entities.NonProgressiveJournalDesign;
import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.CommonService;
import com.humworks.dcs.service.NonProgressiveJournalDesignService;
import com.humworks.dcs.service.NonProgressiveJournalService;

@Controller
@RequestMapping("/assessment/journal-entry")
public class JournalDataEntryController {

	private final String page = "auth/assessment/journal_data_entry";
	private final String entry = "auth/assessment/journal_data_entry_page";
	
	@Autowired
	private NonProgressiveJournalService nonProgressiveService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private NonProgressiveJournalDesignService nonProgressiveJournalDesignService;

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		ArrayList<Long> ids = nonProgressiveJournalDesignService.selectUnique();
		if(ids.size()>0){
			model.addAttribute("nonProgressiveList", nonProgressiveService.findByIds(ids));
		}
		return page;
	}
	
	@GetMapping("{journalUrl}")
	public String design(@PathVariable("journalUrl") String journalUrl, Model model)throws Exception{
		Integer journalMasterId = commonService.getIdFromUrl(journalUrl);
		String journalName = commonService.getNameFromUrl(journalUrl);
		final NonProgressiveJournalMaster journal = nonProgressiveService.findById(journalMasterId);
		if(journal==null){
			throw new ResourceNotFoundException(journalName);
		}
		final ArrayList<NonProgressiveJournalDesign> listDesign = nonProgressiveJournalDesignService.findByJournalId(journal.getNonProgressiveMasterId());
		ArrayList<JsonDesignRequest> jsonDesignRequest = new ArrayList<JsonDesignRequest>();
		for(NonProgressiveJournalDesign list : listDesign) {
			JsonDesignRequest jdr = new JsonDesignRequest();
			jdr.setConfig_no(list.getNonPrgvDesignId());
			jdr.setFormula(list.getFormula());
			jdr.setHeader(list.getColHeaderText());
			jdr.setLookup_id(list.getLookupMasterId());
			jdr.setNon_progressive_link(list.getNonPrgvLinkId());
			jdr.setOrder(list.getColOrder());
			jdr.setProgressive_link(list.getPrgvLinkId());
			jdr.setReadonly((list.getIsReadOnly()==1)? true : false);
			jdr.setType(list.getColType());
			jdr.setUom(list.getUomId());
			jdr.setValidate_pending(list.getIsValidPending());
			jdr.setValidate_revision(list.getValidRevision());
			jdr.setWidth(list.getColHeaderWidth());
			jsonDesignRequest.add(jdr);
		}
		//Used for Handson table
		model.addAttribute("design", commonService.arrayListtoJson(jsonDesignRequest));
		model.addAttribute("journalData", "[]");
		model.addAttribute("lookup", "[]");
		model.addAttribute("hotLock", false);
		model.addAttribute("hotObject", null);
		//
		
		model.addAttribute("nonprogressive", journal);
		model.addAttribute("journalName",journalName);
		return entry;
	}
	

}