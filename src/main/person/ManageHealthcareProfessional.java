package main.person;

public class ManageHealthcareProfessional implements Manage{
	// Atributo

    private HealthcareProfessionalNode first;

// M�todos p�blicos
    public boolean isEmpty() {
        // Testa se a lista est� vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
        HealthcareProfessionalNode newNode;
        // Verifica, usando a fun��o "search" se o HealthcareProfessional j� � cadastrado
        HealthcareProfessionalNode result = this.search(healthcareProfessional);
        if (result != null) {
            System.out.println("HealthcareProfessional j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o HealthcareProfessional que foi passado como par�metro
            newNode = new HealthcareProfessionalNode(healthcareProfessional);
            // Insere um newNode HealthcareProfessional no in�cio da lista de HealthcareProfessionals
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inser��o efetuada!");
        }
    }

    public void insertHealthcareProfessionalEnd(HealthcareProfessional healthcareProfessional) {
        HealthcareProfessionalNode newNode, aux;
        // Verifica, usando a fun��o "search" se o HealthcareProfessional j� � cadastrado
        HealthcareProfessionalNode result = this.search(healthcareProfessional);
        if (result != null) {
            System.out.println("HealthcareProfessional j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o HealthcareProfessional que foi passado como par�metro
            newNode = new HealthcareProfessionalNode(healthcareProfessional);
            // Insere um newNode HealthcareProfessional no End da lista de HealthcareProfessionals
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

    public HealthcareProfessionalNode search(HealthcareProfessional healthcareProfessional) {
        HealthcareProfessionalNode aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.first;
            while (aux != null) {
                if (aux.getInfo().compareTo(healthcareProfessional) == 0) {
                    return aux;
                } else {
                    aux = aux.getNext();
                }
            }
            return null;
        }
    }
    
    
    
    public HealthcareProfessionalNode getFirst() {
		return first;
	}

	public void setFirst(HealthcareProfessionalNode first) {
		this.first = first;
	}

	public void remove(String certificate) {
        HealthcareProfessional wanted = new HealthcareProfessional(certificate);
        HealthcareProfessionalNode atual, anterior;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else if (this.first.getNext() == null) {
            if (wanted.compareTo(this.first.getInfo()) == 0) {
                this.first = null;
                System.out.println("Remo��o efetuada");
            } else {
            	
                System.out.println("HealthcareProfessional n�o encontrado!");
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
        HealthcareProfessionalNode aux;
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
