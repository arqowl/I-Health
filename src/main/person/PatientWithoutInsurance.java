package main.person;

import main.financial.CreditCard;

public class PatientWithoutInsurance extends Patient{
	private CreditCard patientCreditCard;

	public PatientWithoutInsurance(String cpf, String fullName, CreditCard patienCreditCard) {
		super(cpf, fullName);
		this.patientCreditCard = patienCreditCard;

	}

	@Override
	public String toString() {
		return "PatientWithoutInsurance [cpf="+cpf+ ", fullName="
				+ fullName+", patientCreditCard=" + patientCreditCard  + "]";
	}

	
	
	

}
