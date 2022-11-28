package main.treatment;

import main.person.Manage;

public class ManageTreatment implements Manage{
	// Atributo

    private TreatmentNode first;

// M�todos p�blicos
    public boolean isEmpty() {
        // Testa se a lista est� vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertTreatment(Treatment treatment) {
        TreatmentNode newNode;
        // Verifica, usando a fun��o "search" se o Treatment j� � cadastrado
        TreatmentNode result = this.search(treatment);
        if (result != null) {
            System.out.println("Treatment j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o Treatment que foi passado como par�metro
            newNode = new TreatmentNode(treatment);
            // Insere um newNode Treatment no in�cio da lista de Treatments
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inser��o efetuada!");
        }
    }

    public void insertTreatmentEnd(Treatment treatment) {
        TreatmentNode newNode, aux;
        // Verifica, usando a fun��o "search" se o Treatment j� � cadastrado
        TreatmentNode result = this.search(treatment);
        if (result != null) {
            System.out.println("Treatment j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o Treatment que foi passado como par�metro
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
            System.out.println("Inser��o efetuada!");
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
                System.out.println("Remo��o efetuada");
            } else {
                System.out.println("Treatment n�o encontrado!");
            }
        } else { // lista com mais de um n�
            if (wanted.compareTo(this.first.getInfo()) == 0) { // remo��o do first
                this.first = this.first.getNext();
                System.out.println("Remo��o efetuada");
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
                    System.out.println("Valor n�o pertence a lista!");
                }
                else {
                    anterior.setNext(atual.getNext());
                    System.out.println("Remo��o efetuada!");
                }
            }
        }
     }

    public void showAll() {
        // Exibe o conte�do de todos os n�s da lista
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
