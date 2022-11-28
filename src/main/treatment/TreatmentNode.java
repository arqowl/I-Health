package main.treatment;

public class TreatmentNode {
	// Atributos
    private Treatment info;
    private TreatmentNode next;
// M�todo construtor      
    public TreatmentNode(Treatment value) {
        this.info = value;
    }
// M�todos SET
    public void setInfo(Treatment value) {
        this.info = value;
    }
    public void setNext(TreatmentNode newNext) {
        this.next = newNext;
    }
// M�todos GET
    public Treatment getInfo() {
        return this.info;
    }
    public TreatmentNode getNext() {
        return this.next;
    }
}
