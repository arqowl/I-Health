package main.person;

public class Patient extends Person implements Comparable <Patient>{
    
    protected String bloodType;
    protected String allergy;
    protected String symptoms;
    protected String weight;
    protected String height;

    public Patient(String cpf, String rg, String fullName, String address, String birthdate, String bloodType, String allergy, String symptoms, String weight, String height) {
        super(cpf, rg, fullName, address, birthdate);
        this.bloodType = bloodType;
        this.allergy = allergy;
        this.symptoms = symptoms;
        this.weight = weight;
        this.height = height;
    }
    
    public Patient(String cpf, String fullName) {
        super(cpf, fullName);
    }
    
    public Patient(String cpf) {
    	super(cpf);
    }

    
	@Override
	public String toString() {
		return "Patient [cpf=" + cpf + ", fullName=" + fullName + "]";
	}
    
	public int compareTo(Patient patient) {
		int result;
		result = this.getCpf().compareTo(patient.getCpf());
		return result;
	}
    
    /*
	@Override
	public String toString() {
		return "Patient [fullName="+fullName+", cpf="+cpf+", rg="+rg+", address="+address+", birthdate"+birthdate
				+", bloodType=" + bloodType + ", allergy=" + allergy + ", symptoms=" + symptoms + ", healthPlan="
				+ healthPlan + ", weight=" + weight + ", height=" + height + "]";
	}*/
    
    


    
    
}
