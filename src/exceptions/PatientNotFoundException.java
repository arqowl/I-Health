package exceptions;

public class PatientNotFoundException extends Exception{
	private String cpf;

	public PatientNotFoundException(String cpf) {
		super("Paciente n�o encontrado por conta do CPF "+cpf+" n�o existir");
		this.cpf = cpf;
	}
	
	public PatientNotFoundException() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
