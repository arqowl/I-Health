package exceptions;

public class HealthcareProfessionalNotFoundException extends Exception{
	private String certificate;

	public HealthcareProfessionalNotFoundException(String certificate) {
		super("Paciente não encontrado por conta do certificado profissional "+certificate+" não existir");
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
