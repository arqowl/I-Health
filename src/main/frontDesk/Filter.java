package main.frontDesk;

import java.util.Scanner;

import main.exceptions.*;
import main.financial.*;
import main.person.*;
import main.treatment.*;

public class Filter extends Menu {// facade
	Scanner in = new Scanner(System.in);
	private int key;
	ManagePatients patients = new ManagePatients();
	ManageHealthcareProfessional professionals = new ManageHealthcareProfessional();
	ManageTreatment atendimentos = new ManageTreatment();
	Treatment atend = null;
	Patient pat = null;
	HealthcareProfessional hp = null;
	String cpf, name, healthPlan, treatmentID;
	String cardNumber, expirationDate, cvcCode;
	String certificate;
	Sorting triagem = null;
	Specialization specialization;
	CreditCard creditCard;
	char checkHealthPlan;

	public void registerNewPatient() {
		System.out.println("Informe o CPF do paciente: ");
		cpf = in.next();
		in.nextLine();
		System.out.println("Informe o nome do paciente: ");
		name = in.next();
		in.nextLine();
		System.out.println("O paciente possui plano de sa�de? S/N");
		checkHealthPlan = in.next().charAt(0);
		in.nextLine();
		if (Character.toLowerCase(checkHealthPlan) == 's') {
			System.out.println("Informe o Plano de sa�de do paciente: ");
			healthPlan = in.next();
			in.nextLine();
			pat = new PatientWithInsurance(cpf, name, healthPlan);
		} else {
			System.out.println("Informe o n�mero do Cart�o de cr�dito do paciente: ");
			cardNumber = in.next();
			in.nextLine();
			System.out.println("Informe a data de expira��o do cart�o de cr�dito do paciente: ");
			expirationDate = in.next();
			in.nextLine();
			System.out.println("Informe o c�digo CVC do cart�o do paciente: ");
			cvcCode = in.next();
			in.nextLine();
			creditCard = new CreditCard(cardNumber, expirationDate, cvcCode);
			pat = new PatientWithoutInsurance(cpf, name, creditCard);
		}
		patients.insertPatient(pat);
	}

	protected void showAllPatients() {
		patients.showAll();
	}

	protected void registerNewHP() {
		System.out.println("Informe o certificado do Profissional de sa�de: ");
		certificate = in.next();
		in.nextLine();
		System.out.println("Informe a especialidade do Profissional de sa�de: ");
		showSpecialization();
		key = in.nextInt();
		in.nextLine();
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
		name = in.next();
		in.nextLine();
		hp = new HealthcareProfessional(certificate, specialization, name);
		professionals.insertHealthcareProfessional(hp);
	}

	protected void showAllHP() {
		professionals.showAll();
	}

	protected void registerNewService() throws Exception {
		System.out.println("Informe o CPF do paciente: ");
		cpf = in.next();
		in.nextLine();
		pat = new Patient(cpf);
		System.out.println("Informe o certificado do Profissional de sa�de: ");
		certificate = in.next();
		in.nextLine();
		hp = new HealthcareProfessional(certificate);
		while (true) {
			try {
				triagem = new Sorting(patients, professionals, atendimentos);
				triagem.searchHealthcareProfessional(hp);
				triagem.searchPatient(pat);
			} catch (PatientNotFoundException e) {
				System.out.println("Paciente nao encontrado");
				showMenu();
				break;
			} catch (HealthcareProfessionalNotFoundException e) {
				System.out.println("Profissional de saude nao encontrado");
				showMenu();
				break;
			}
		}
		System.out.println("Informe o treatmentID do atendimento que est� sendo criado: ");
		treatmentID = in.next();
		in.nextLine();
		atendimentos = triagem.addValidTreatment(pat, hp, treatmentID);
	}

	protected void showAllPendingServices() {
		atendimentos.showAll();
	}

	protected void removePatient() {
		System.out.println("Informe o CPF do paciente que voc� deseja remover: ");
		cpf = in.next();
		in.nextLine();
		patients.remove(cpf);
	}

	protected void removeHP() {
		System.out.println("Informe o certificado do Profissional de sa�de que voc� deseja remover: ");
		certificate = in.next();
		in.nextLine();
		professionals.remove(certificate);
	}

	protected void removeService() {
		System.out.println("Informe o treatmentID do atendimento que est� sendo removido: ");
		treatmentID = in.next();
		in.nextLine();
		atendimentos.remove(treatmentID);
	}

	protected void showSpecialization() {
		System.out.println("1 - Fisioterapeuta");
		System.out.println("2 - M�dico");
		System.out.println("3 - Enfermeira");
		System.out.println("4 - Nutricionista");
		System.out.println("");
		System.out.println("Escolha: ");
	}
}
