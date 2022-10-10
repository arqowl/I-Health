package person;

public class HealthcareProfessionalNode {
	// Atributos
    private HealthcareProfessional info;
    private HealthcareProfessionalNode next;
// Método construtor      
    public HealthcareProfessionalNode(HealthcareProfessional value) {
        this.info = value;
    }
// Métodos SET
    public void setInfo(HealthcareProfessional value) {
        this.info = value;
    }
    public void setNext(HealthcareProfessionalNode newNext) {
        this.next = newNext;
    }
// Métodos GET
    public HealthcareProfessional getInfo() {
        return this.info;
    }
    public HealthcareProfessionalNode getNext() {
        return this.next;
    }
}
