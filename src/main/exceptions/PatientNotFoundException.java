package main.exceptions;

public class PatientNotFoundException extends Exception{
	private String cpf;

	public PatientNotFoundException(String cpf) {
		super("Paciente nao encontrado por conta do CPF "+cpf+" nao existir");
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
