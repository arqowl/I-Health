package main.person;

public class PatientNode {
	// Atributos
    private Patient info;
    private PatientNode next;
// M�todo construtor      
    public PatientNode(Patient value) {
        this.info = value;
    }
// M�todos SET
    public void setInfo(Patient value) {
        this.info = value;
    }
    public void setNext(PatientNode newNext) {
        this.next = newNext;
    }
// M�todos GET
    public Patient getInfo() {
        return this.info;
    }
    public PatientNode getNext() {
        return this.next;
    }
}
