package main.person;

public enum Specialization {
    Physiotherapist("Respons�vel pela terapia f�sica dos pacientes"),
    Doctor("Respons�vel por prescrever o tratamento dos pacientes"),
    Nurse("Respons�vel por realizar a triagem dos pacientes"),
    Nutritionist("Respons�vel por passar a dieta dos pacientes"),
	Intern("Sem especialidade");
    
    private String description;
    
	private Specialization(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

    
    
    
}


