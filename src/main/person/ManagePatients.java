package main.person;

public class ManagePatients implements Manage{
	// Atributo

    private PatientNode first;

// M�todos p�blicos
    public boolean isEmpty() {
        // Testa se a lista est� vazia
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertPatient(Patient patient) {
        PatientNode newNode;
        // Verifica, usando a fun��o "search" se o Patient j� � cadastrado
        PatientNode result = this.search(patient);
        if (result != null) {
            System.out.println("Patient j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o Patient que foi passado como par�metro
            newNode = new PatientNode(patient);
            // Insere um newNode Patient no in�cio da lista de Patients
            if (this.isEmpty() == true) {
                this.first = newNode;
            } else {
                newNode.setNext(this.first);
                this.first = newNode;
            }
            System.out.println("Inser��o efetuada!");
        }
    }

    public void insertPatientEnd(Patient patient) {
        PatientNode newNode, aux;
        // Verifica, usando a fun��o "search" se o Patient j� � cadastrado
        PatientNode result = this.search(patient);
        if (result != null) {
            System.out.println("Patient j� existe na lista!");
        } else {
            // Cria e preenche um newNode n� com o Patient que foi passado como par�metro
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
            System.out.println("Inser��o efetuada!");
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
                System.out.println("Remo��o efetuada");
            } else {
                System.out.println("Patient n�o encontrado!");
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
    
    

    public PatientNode getFirst() {
		return first;
	}

	public void setFirst(PatientNode first) {
		this.first = first;
	}

	public void showAll() {
        // Exibe o conte�do de todos os n�s da lista
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
