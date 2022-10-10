package person;

public class ManagePatients {
	// Atributo

    private PatientNode first;

// Métodos públicos
    public boolean isEmpty() {
        // Testa se a lista está vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertPatient(Patient patient) {
        PatientNode newNode;
        // Verifica, usando a função "search" se o Patient já é cadastrado
        PatientNode result = this.search(patient);
        if (result != null) {
            System.out.println("Patient já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o Patient que foi passado como parâmetro
            newNode = new PatientNode(patient);
            // Insere um newNode Patient no início da lista de Patients
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inserção efetuada!");
        }
    }

    public void insertPatientEnd(Patient patient) {
        PatientNode newNode, aux;
        // Verifica, usando a função "search" se o Patient já é cadastrado
        PatientNode result = this.search(patient);
        if (result != null) {
            System.out.println("Patient já existe na lista!");
        } else {
            // Cria e preenche um newNode nó com o Patient que foi passado como parâmetro
            newNode = new PatientNode(patient);
            // Insere um newNode Patient no End da lista de Patients
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

    public PatientNode search(Patient patient) {
        PatientNode aux;
        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.first;
            while (aux != null) {
                if (aux.getInfo().compareTo(patient) == 0) {
                    return aux;
                } else {
                    aux = aux.getNext();
                }
            }
            return null;
        }
    }
    
    public void remove(String cpf) {
        Patient wanted = new Patient(cpf);
        PatientNode atual, anterior;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else if (this.first.getNext() == null) {
            if (wanted.compareTo(this.first.getInfo()) == 0) {
                this.first = null;
                System.out.println("Remoção efetuada");
            } else {
                System.out.println("Patient não encontrado!");
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
    
    

    public PatientNode getFirst() {
		return first;
	}

	public void setFirst(PatientNode first) {
		this.first = first;
	}

	public void showAll() {
        // Exibe o conteúdo de todos os nós da lista
        PatientNode aux;
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
