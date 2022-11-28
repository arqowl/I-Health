package main.person;

public class HealthcareProfessional extends Person implements Comparable <HealthcareProfessional>, IHPDescription{
    
    protected String certificate;
    protected Specialization specialization;

    public HealthcareProfessional(String cpf, String rg, String fullName, String address, String birthdate, String certificate, Specialization specialization) {
        super(cpf, rg, fullName, address, birthdate);
        this.certificate = certificate;
        this.specialization = specialization;
    }
    
	public HealthcareProfessional(String certificate) {
		this.certificate = certificate;
	}
	
	public HealthcareProfessional(String certificate, Specialization specialization, String fullName) {
		this.fullName = fullName;
		this.certificate = certificate;
		this.specialization = specialization;
	}

	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public int compareTo(HealthcareProfessional healthcareProfessional) {
		int result;
		result = this.getCertificate().compareTo(healthcareProfessional.getCertificate());
		return result;
	}

	@Override
	public String toString() {
		return "HealthcareProfessional [certificate=" + certificate + ", specialization=" + specialization
				+ ", fullName=" + fullName + "]";
	}
	
	


    
}
