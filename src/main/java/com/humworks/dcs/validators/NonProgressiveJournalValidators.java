package com.humworks.dcs.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.service.NonProgressiveJournalService;

@Component
public class NonProgressiveJournalValidators implements Validator {

	@Autowired
	private NonProgressiveJournalService nonProgressiveService;
	
	@Override
	public boolean supports(Class<?> journal) {
		// TODO Auto-generated method stub
		return NonProgressiveJournalMaster.class.equals(journal);
	}

	@Override
	public void validate(Object journal, Errors errors) {
		NonProgressiveJournalMaster journalMaster = (NonProgressiveJournalMaster) journal;
		NonProgressiveJournalMaster jrnal = nonProgressiveService.findByName(journalMaster.getJournalName());
		if(journalMaster.getNonProgressiveMasterId()==null){
			if(jrnal!=null){
				errors.rejectValue("journalName", "journal.exist");
			}
		}else{
			if(jrnal!=null){
				if(jrnal.getNonProgressiveMasterId() != journalMaster.getNonProgressiveMasterId()){
					errors.rejectValue("journalName", "journal.exist");
				}
			}
		}

	}

}
