package main.frontDesk;
import java.util.Scanner;

public class Menu {


public static void main(String[] args) throws Exception {
	int op;
	Scanner in = new Scanner(System.in);
	Filter facade= new Filter();

    do{
	    showMenu();
	    op= in.nextInt(); in.nextLine();
    
        switch (op) {
            case 1:
            	facade.registerNewPatient();
                break;
            case 2:
				facade.showAllPatients();
                break;
            case 3:
				facade.registerNewHP();
                break;
            case 4:
				facade.showAllHP();
                break;
            case 5:
				facade.registerNewService();
                break;
            case 6:
				facade.showAllPendingServices();
				break;
            case 7:
				facade.removePatient();
                break;
            case 8:
				facade.removeHP();
            	break;
            case 9:
				facade.removeService();
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
	        System.out.println(	"\n1 - Cadastrar um novo paciente \n" +
				                "2 - Mostrar todos os pacientes \n" +
				                "3 - Cadastrar um novo profissional de sa�de \n" +
				                "4 - Mostrar todos os profissionais de sa�de \n" +
				                "5 - Cadastrar um novo atendimento \n" +
				                "6 - Mostrar todos os atendimentos pendentes \n" +
				                "7 - Remover um paciente \n" +
				                "8 - Remover um Profissional de Sa�de \n" +
				                "9 - Remover um atendimento \n" +
				                "0 - Sair do programa");
	        System.out.print("choice: ");
        }
    
}