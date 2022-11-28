package main.treatment;

import main.person.*;

public class Treatment implements Comparable<Treatment>{
	protected Patient patient;
	protected HealthcareProfessional healthcareProfessional;
	protected String treatmentID;
	
	public Treatment(Patient patient, HealthcareProfessional healthcareProfessional, String treatmentID) {
		this.patient = patient;
		this.healthcareProfessional = healthcareProfessional;
		this.treatmentID = treatmentID;
	}

	public Treatment(String treatmentID) {
		this.treatmentID = treatmentID;
	}
	


	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public HealthcareProfessional getHealthcareProfessional() {
		return healthcareProfessional;
	}
	public void setHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
		this.healthcareProfessional = healthcareProfessional;
	}
	public String getTreatmentID() {
		return treatmentID;
	}
	public void setTreatmentID(String treatmentID) {
		this.treatmentID = treatmentID;
	}
	
	@Override
	public int compareTo(Treatment treatment) {
		int result;
		result = this.getTreatmentID().compareTo(treatment.getTreatmentID());
		return result;
	}

	@Override
	public String toString() {
		return "Treatment [patient=" + patient + ", healthcareProfessional=" + healthcareProfessional + ", treatmentID="
				+ treatmentID + "]";
	}
	
	
	

}
