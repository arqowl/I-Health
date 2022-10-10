package person;

public class ManageHealthcareProfessional {
	// Atributo

    private HealthcareProfessionalNode first;

// Métodos públicos
    public boolean isEmpty() {
        // Testa se a lista está vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertHealthcareProfessional(HealthcareProfessional healthcareProfessional) {
        HealthcareProfessionalNode newNode;
        // Verifica, usando a função "search" se o HealthcareProfessional já é cadastrado
        HealthcareProfessionalNode result = this.search(healthcareProfessional);
        if (result != null) {
            System.out.println("HealthcareProfessional já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o HealthcareProfessional que foi passado como parâmetro
            newNode = new HealthcareProfessionalNode(healthcareProfessional);
            // Insere um newNode HealthcareProfessional no início da lista de HealthcareProfessionals
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inserção efetuada!");
        }
    }

    public void insertHealthcareProfessionalEnd(HealthcareProfessional healthcareProfessional) {
        HealthcareProfessionalNode newNode, aux;
        // Verifica, usando a função "search" se o HealthcareProfessional já é cadastrado
        HealthcareProfessionalNode result = this.search(healthcareProfessional);
        if (result != null) {
            System.out.println("HealthcareProfessional já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o HealthcareProfessional que foi passado como parâmetro
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
            System.out.println("Inserção efetuada!");
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
                System.out.println("Remoção efetuada");
            } else {
            	
                System.out.println("HealthcareProfessional não encontrado!");
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
