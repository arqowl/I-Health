package treatment;

public class ManageTreatment {
	// Atributo

    private TreatmentNode first;

// Métodos públicos
    public boolean isEmpty() {
        // Testa se a lista está vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertTreatment(Treatment treatment) {
        TreatmentNode newNode;
        // Verifica, usando a função "search" se o Treatment já é cadastrado
        TreatmentNode result = this.search(treatment);
        if (result != null) {
            System.out.println("Treatment já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o Treatment que foi passado como parâmetro
            newNode = new TreatmentNode(treatment);
            // Insere um newNode Treatment no início da lista de Treatments
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inserção efetuada!");
        }
    }

    public void insertTreatmentEnd(Treatment treatment) {
        TreatmentNode newNode, aux;
        // Verifica, usando a função "search" se o Treatment já é cadastrado
        TreatmentNode result = this.search(treatment);
        if (result != null) {
            System.out.println("Treatment já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o Treatment que foi passado como parâmetro
            newNode = new TreatmentNode(treatment);
            // Insere um newNode Treatment no End da lista de Treatments
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                aux = this.first;
                while (aux.getNext() != null) {
                    aux = aux.getNext();
                }
                aux.setNext(newNode);
            }
            System.out.println("Inserção efetuada!");
        }
    }

    private TreatmentNode search(Treatment treatment) {
        TreatmentNode aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.first;
            while (aux != null) {
                if (aux.getInfo().compareTo(treatment) == 0) {
                    return aux;
                } else {
                    aux = aux.getNext();
                }
            }
            return null;
        }
    }
    
    public void remove(String treatmentID) {
        Treatment wanted = new Treatment(treatmentID);
        TreatmentNode atual, anterior;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else if (this.first.getNext() == null) {
            if (wanted.compareTo(this.first.getInfo()) == 0) {
                this.first = null;
                System.out.println("Remoção efetuada");
            } else {
                System.out.println("Treatment não encontrado!");
            }
        } else { // lista com mais de um nó
            if (wanted.compareTo(this.first.getInfo()) == 0) { // remoção do first
                this.first = this.first.getNext();
                System.out.println("Remoção efetuada");
            } else {
                anterior = null;
                atual = this.first;
                while (atual != null) {
                   if (atual.getInfo().compareTo(wanted) != 0 ) {
                    anterior = atual;
                    atual = atual.getNext();
                   }
                   else {
                       break; // achou!!!
                   }
                }
                if (atual == null) {
                    System.out.println("Valor não pertence a lista!");
                }
                else {
                    anterior.setNext(atual.getNext());
                    System.out.println("Remoção efetuada!");
                }
            }
        }
     }

    public void showAll() {
        // Exibe o conteúdo de todos os nós da lista
        TreatmentNode aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            aux = this.first;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getNext();
            }
        }
    }
}
