package main.person;

public class HealthcareProfessionalNode {
	// Atributos
    private HealthcareProfessional info;
    private HealthcareProfessionalNode next;
// M�todo construtor      
    public HealthcareProfessionalNode(HealthcareProfessional value) {
        this.info = value;
    }
// M�todos SET
    public void setInfo(HealthcareProfessional value) {
        this.info = value;
    }
    public void setNext(HealthcareProfessionalNode newNext) {
        this.next = newNext;
    }

    
// M�todos GET
    public HealthcareProfessional getInfo() {
        return this.info;
    }
    public HealthcareProfessionalNode getNext() {
        return this.next;
    }
}
