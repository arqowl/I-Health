package main.person;

public class PatientWithInsurance extends Patient{
	private String healthPlan;

	public PatientWithInsurance(String cpf) {
		super(cpf);
	}
	
	public PatientWithInsurance(String cpf, String fullName, String healthPlan) {
		super(cpf, fullName);
		this.healthPlan = healthPlan;
	}

	public String getHealthPlan() {
		return healthPlan;
	}

	public void setHealthPlan(String healthPlan) {
		this.healthPlan = healthPlan;
	}

	@Override
	public String toString() {
		return "PatientWithInsurance [cpf=" + cpf + ", fullName=" + fullName + ", healthPlan=" + healthPlan + "]";
	}
	
	

}
