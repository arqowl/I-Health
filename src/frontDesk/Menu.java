package frontDesk;
import java.util.Scanner;

import exceptions.*;
import financial.*;
import person.*;
import treatment.*;


public class Menu {


public static void main(String[] args) throws Exception {
	int op,key;
	Scanner in = new Scanner(System.in);
	ManagePatients patients = new ManagePatients();
	ManageHealthcareProfessional professionals = new ManageHealthcareProfessional();
	ManageTreatment atendimentos = new ManageTreatment();
	Treatment atend = null;
	Patient pat = null;
	HealthcareProfessional hp = null;
	String cpf, name, healthPlan, treatmentID;
	String cardNumber,expirationDate,cvcCode;
	String certificate;
	Sorting triagem=null;
	Specialization specialization;
	CreditCard creditCard;
	char checkHealthPlan;

    do{
	    showMenu();
	    op= in.nextInt(); in.nextLine();
    
        switch (op) {
            case 1:
            	System.out.println("Informe o CPF do paciente: ");
            	cpf = in.next(); in.nextLine();
            	System.out.println("Informe o nome do paciente: ");
            	name = in.next(); in.nextLine();
            	System.out.println("O paciente possui plano de sa�de? S/N");
            	checkHealthPlan = in.next().charAt(0); in.nextLine();
            	if(Character.toLowerCase(checkHealthPlan) == 's') {
            		System.out.println("Informe o Plano de sa�de do paciente: ");
            		healthPlan = in.next(); in.nextLine();
            		pat = new PatientWithInsurance(cpf, name,healthPlan);
            	}  else {
            		System.out.println("Informe o n�mero do Cart�o de cr�dito do paciente: ");
            		cardNumber = in.next(); in.nextLine();
            		System.out.println("Informe a data de expira��o do cart�o de cr�dito do paciente: ");
            		expirationDate = in.next(); in.nextLine();
            		System.out.println("Informe o c�digo CVC do cart�o do paciente: ");
            		cvcCode = in.next(); in.nextLine();
            		creditCard = new CreditCard(cardNumber, expirationDate, cvcCode);
            		pat = new PatientWithoutInsurance(cpf, name, creditCard);
            	}
            	patients.insertPatient(pat);
                break;
            case 2:
            	patients.showAll();
                break;
            case 3:
            	System.out.println("Informe o certificado do Profissional de sa�de: ");
            	certificate = in.next(); in.nextLine();
            	System.out.println("Informe a especialidade do Profissional de sa�de: ");
            	showSpecialization();
                key= in.nextInt(); in.nextLine();
            	switch (key) {
					case 1:
						specialization = Specialization.Physiotherapist;
						break;
					case 2:
						specialization = Specialization.Doctor;
						break;
					case 3:
						specialization = Specialization.Nurse;
						break;
					case 4:
						specialization = Specialization.Nutritionist;
						break;
					default:
						System.out.println("Sem especialidade");
						specialization = Specialization.Intern;
						break;
				}
            	System.out.println("Informe o nome do Profissional de sa�de: ");
            	name = in.next(); in.nextLine();
            	hp = new HealthcareProfessional(certificate, specialization, name);
            	professionals.insertHealthcareProfessional(hp);
                break;
            case 4:
            	professionals.showAll();
                break;
            case 5:
            	System.out.println("Informe o CPF do paciente: ");
            	cpf = in.next(); in.nextLine();
            	pat = new Patient(cpf);
            	System.out.println("Informe o certificado do Profissional de sa�de: ");
            	certificate = in.next(); in.nextLine();
            	hp = new HealthcareProfessional(certificate);
            	try {
            		triagem.searchHealthcareProfessional(professionals, hp);
            		triagem.searchPatient(patients, pat);
					
				} catch (PatientNotFoundException e) {
					showMenu();
					break;
				} catch (HealthcareProfessionalNotFoundException e) {
					showMenu();
					break;
				} catch (NullPointerException e) {
					showMenu();
				}
            	System.out.println("Informe o treatmentID do atendimento que est� sendo criado: ");
            	treatmentID = in.next(); in.nextLine();
            	try {
                	atend = new Treatment(patients.search(pat).getInfo(), professionals.search(hp).getInfo(), treatmentID);
            	} catch(NullPointerException e) {
            		showMenu();
            		break;
            	}

            	atendimentos.insertTreatment(atend);
                break;
            case 6:
            	atendimentos.showAll();
                break;
            case 7:
            	System.out.println("Informe o CPF do paciente que voc� deseja remover: ");
            	cpf = in.next(); in.nextLine();
            	patients.remove(cpf);
                break;
            case 8:
            	System.out.println("Informe o certificado do Profissional de sa�de que voc� deseja remover: ");
            	certificate = in.next(); in.nextLine();
            	professionals.remove(certificate);
            	break;
            case 9:
            	System.out.println("Informe o treatmentID do atendimento que est� sendo removido: ");
            	treatmentID = in.next(); in.nextLine();
            	atendimentos.remove(treatmentID);
            	break;
            case 0:
            	System.out.println("Bye bye!!");
                break;
            default:
                break;
        
    
        }
    }
    while(op!= 0);
    }      
      
        public static void showMenu(){
	        System.out.println(	"1 - Cadastrar um novo paciente \n" +
				                "2 - Mostrar todos os pacientes \n" +
				                "3 - Cadastrar um novo profissional de sa�de \n" +
				                "4 - Mostrar todos os profissionais de sa�de \n" +
				                "5 - Cadastrar um novo atendimento \n" +
				                "6 - Mostrar todos os atendimentos pendentes \n" +
				                "7 - Remover um paciente \n" +
				                "8 - Remover um Profissional de Sa�de \n" +
				                "8 - Remover um atendimento \n" +
				                "0 - Sair do programa");
	        System.out.print("choice: ");
        }
        
        public static void showSpecialization() {
        	System.out.println("1 - Fisioterapeuta");
        	System.out.println("2 - M�dico");
        	System.out.println("3 - Enfermeira");
        	System.out.println("4 - Nutricionista");
        	System.out.println("");
        	System.out.println("Escolha: ");
        }

}