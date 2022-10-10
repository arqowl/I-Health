package treatment;

import exceptions.*;
import person.*;

public class Sorting {
	
    public void searchPatient(ManagePatients managePatients, Patient patient) throws Exception{
    	PatientNode aux;
    	aux = managePatients.getFirst();
    	boolean validatePatient=false;
    	while(aux != null) {
    		if(aux.getInfo().compareTo(patient) == 0) {
    			System.out.println("Paciente encontrado");
    			validatePatient=true;
    		} else {
    			aux = aux.getNext();
    		}
    	}
    	if(validatePatient == false) {
        	 throw new PatientNotFoundException();
         }
    }
    
    public void searchHealthcareProfessional(ManageHealthcareProfessional manageHealthcareProfessional, HealthcareProfessional healthcareProfessional) throws Exception{
    	HealthcareProfessionalNode aux;
    	aux = manageHealthcareProfessional.getFirst();
    	boolean validateHealthcareProfessional=false;
    	while(aux != null) {
    		if(aux.getInfo().compareTo(healthcareProfessional) == 0) {
    			System.out.println("Profissional de Saúde encontrado");
    			validateHealthcareProfessional=true;
    		} else {
    			aux = aux.getNext();
    		}
    	}
    	if(validateHealthcareProfessional == false) {
       	 throw new HealthcareProfessionalNotFoundException();
        }
   }
	
	
	

}
