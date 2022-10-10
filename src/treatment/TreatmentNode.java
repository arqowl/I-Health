package treatment;

public class TreatmentNode {
	// Atributos
    private Treatment info;
    private TreatmentNode next;
// Método construtor      
    public TreatmentNode(Treatment value) {
        this.info = value;
    }
// Métodos SET
    public void setInfo(Treatment value) {
        this.info = value;
    }
    public void setNext(TreatmentNode newNext) {
        this.next = newNext;
    }
// Métodos GET
    public Treatment getInfo() {
        return this.info;
    }
    public TreatmentNode getNext() {
        return this.next;
    }
}
