package com.infy.validator;

import java.time.LocalDate;

import com.infy.model.Candidate;

public class Validator {
	//calls the validation methods for individual inputs
	//if any method returns false, then the String value correspondingly
	public String validate(Candidate candidate) {	
		
		if(!Boolean.TRUE.equals(this.isValidCandidateId(candidate.getCandidateId()))) {
			return "The entered candidate ID is invalid.";
		}
		
		if(!Boolean.TRUE.equals(this.isValidCandidateName(candidate.getCandidateName()))) {
			return "The entered candidate name is invalid.";
		}
		
		if(!Boolean.TRUE.equals(this.isValidExamMarks(candidate))) {
			return "The entered exam marks are invalid.";
		}
		
		if(Boolean.FALSE.equals(this.isValidResult(candidate.getResult()))) {
			return "The entered result is invalid.";
		}
		
		if(Boolean.FALSE.equals(this.isValidDepartment(candidate.getDepartment()))) {
			return "The entered Department name is invalid.";
		}
		
		if(Boolean.FALSE.equals(this.isValidExamDate(candidate.getExamDate()))) {
			return "The entered Department name is invalid.";
		}
		return null;
	}	

	// The entered candidate name should contain only alphabets. Cannot have
	// special characters and only spaces
	public Boolean isValidCandidateName(String candidateName) {
		String regex = "^[A-Za-z]+$";
		
		if(candidateName.matches(regex)) {
			return true;
		}
		
		return false;
	}

	// The entered candidate ID should be of size 5
	public Boolean isValidCandidateId(Integer candidateId) {
		
		if(candidateId >= 10000 && candidateId <= 99999) {
			return true;
		}
		return false;
	}

	// The entered Department name should be one among the given departments
	// (ECE, CSE, IT, EEE)
	public Boolean isValidDepartment(String department) {
		if("ECE".equals(department) || "CSE".equals(department) || "IT".equals(department) || "EEE".equals(department)) {
			return true;
		}
		return false;
	}

	// exam date cannot be today or after todays date
	public Boolean isValidExamDate(LocalDate examDate) {
		if(examDate.isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}
	
	//Checking if marks are not equal to "0"
	public Boolean isValidExamMarks(Candidate candidateTO) {
		
		if(candidateTO.getMark1() >= 0 && candidateTO.getMark2() >= 0 && candidateTO.getMark3() >= 0) {
			return true;
		}
		return false;
	}
	
	//Checking if result set is either 'P' or 'F' only
	public Boolean isValidResult(Character result) {
		
		if(result == 'P' || result == 'F') {
			return true;
		}
		return false;
	}


}
