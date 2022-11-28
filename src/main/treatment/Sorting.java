package main.treatment;

import main.exceptions.*;
import main.person.*;

public class Sorting {
	private ManagePatients patients;
	private ManageHealthcareProfessional professionals;
	private ManageTreatment treatments;
	
    public Sorting(ManagePatients patients, ManageHealthcareProfessional professionals, ManageTreatment treatments) {
		this.patients = patients;
		this.professionals = professionals;
		this.treatments = treatments;
	}

	public void searchPatient(Patient patient) throws Exception{
    	PatientNode aux;
    	aux = this.patients.getFirst();
    	boolean validatePatient=false;
    	while(aux != null&&validatePatient==false) {
    		if(aux.getInfo().compareTo(patient) == 0) {
    			validatePatient=true;
    		} else {
    			aux = aux.getNext();
    		}
    	}
    	if(validatePatient == false) {
        	 throw new PatientNotFoundException();
         }
    }
    
    public void searchHealthcareProfessional(HealthcareProfessional healthcareProfessional) throws Exception{
    	HealthcareProfessionalNode aux;
    	aux = this.professionals.getFirst();
    	boolean validateHealthcareProfessional=false;
    	while(aux != null&&validateHealthcareProfessional==false) {
    		if(aux.getInfo().compareTo(healthcareProfessional) == 0) {
    			validateHealthcareProfessional=true;
    		} else {
    			aux = aux.getNext();
    		}
    	}
    	if(validateHealthcareProfessional == false) {
       	 throw new HealthcareProfessionalNotFoundException();
        }
   }

   public ManageTreatment addValidTreatment(Patient pat,HealthcareProfessional hp,String treatmentID) throws Exception{
		Treatment treat = new Treatment(this.patients.search(pat).getInfo(), this.professionals.search(hp).getInfo(), treatmentID);
		this.treatments.insertTreatment(treat);
		return this.treatments;
   }

	public ManagePatients getPatients() {
		return this.patients;
	}
	public ManageHealthcareProfessional getProfessionals() {
		return this.professionals;
	}

	@Override
	public String toString() {
		return "Sorting [patients=" + patients + ", professionals=" + professionals + ", treatments=" + treatments
				+ "]";
	}

   
	
	

}
