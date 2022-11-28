package main.exceptions;

public class HealthcareProfessionalNotFoundException extends Exception{
	private String certificate;

	public HealthcareProfessionalNotFoundException(String certificate) {
		super("Paciente n�o encontrado por conta do certificado profissional "+certificate+" n�o existir");
		this.certificate = certificate;
	}
	
	public HealthcareProfessionalNotFoundException() {
		super();
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String cpf) {
		this.certificate = cpf;
	}
	
	

}
