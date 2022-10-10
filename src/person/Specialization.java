package person;

public enum Specialization {
    Physiotherapist("Responsável pela terapia física dos pacientes"),
    Doctor("Responsável por prescrever o tratamento dos pacientes"),
    Nurse("Responsável por realizar a triagem dos pacientes"),
    Nutritionist("Responsável por passar a dieta dos pacientes"),
	Intern("Sem especialidade");
    
    private String description;
    
	private Specialization(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

    
    
    
}


