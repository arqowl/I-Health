package main.person;
public abstract class Person{
    protected String cpf;
    protected String rg;
    protected String fullName;
    protected String address;
    protected String birthdate;
    
    public Person(String cpf, String rg, String fullName, String address, String birthdate) {
        this.cpf = cpf;
        this.rg = rg;
        this.fullName = fullName;
        this.address = address;
        this.birthdate = birthdate;
    }
    
    
    protected Person() {

	}


	public Person(String cpf, String fullName) {
		this.cpf = cpf;
		this.fullName = fullName;
	}
	
    
    public Person(String cpf) {
    	this.cpf = cpf;
    }

	public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthdate() {
        return birthdate;
    }

}
