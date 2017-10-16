package opet.marketplace.view;

import java.util.Date;

import opet.marketplace.controller.UserController;
import opet.marketplace.util.Leitor;
import opet.marketplace.util.Validador;
import opet.marketplace.vo.User;

public class LoginView {

	public LoginView() {
		
		System.out.println("##I AM THE LAW - LOGIN ##");
		System.out.println("# 1 - J� sou cadastrado");
		System.out.println("# 2 - Fazer cadastro");
		System.out.println("# 9 - Sair");
		System.out.println("#########################");
		System.out.println("Digite a op��o desejada(1 ou 2):");

		int optionInt = Leitor.readInt();

		switch (optionInt) {
		case 1:

			break;
		case 2:

			break;
		case 9:
			break;

		default:
			System.out.println("Op��o Inv�lida.");
			System.out.println("Digite a op��o desejada(1 ou 2):");
			optionInt = Leitor.readInt();
		}
		

	}
	
	public void CreateNewUser(){
		UserController UserController = new UserController();
		String UserName;
		String UserPass;
		String UserEmail;
		Date Date = new Date();
		int UserLawyer = 0;
		
		System.out.flush();
		System.out.println("##I AM THE LAW - Cria��o de Usu�rio ##");
		System.out.println("# 1 - Qual seu nome?");
		
		//Se n�o for alfabetico, fa�a de novo. Se for, break the loop 
		do{
			UserName = Leitor.readString();
			if(Validador.alfabetico(UserName)){
				break;
			}
			else{
				System.out.println("Digitar apenas caracteres alfabeticos.");
				System.out.println("Digite seu nome novamente.");
			}
		}
		while(Validador.alfabetico(UserName) == false);
		
		System.out.println("# 2 - Escolha uma senha.");
		
		UserPass = Leitor.readString();
		
				
		System.out.println("# 2 - Qual seu e-mail?");
		
		//Se n�o for email, fa�a de novo. Se for, break the loop 
		do{
			UserEmail = Leitor.readString();
			if(Validador.validarEmail(UserEmail)){
				break;
			}
			else{
				System.out.println("Email inv�lido.");
				System.out.println("Digite seu email novamente.");
			}
		}	
		while(Validador.validarEmail(UserEmail) == false);
	
		//Valida se � advogado ou n�o 
		
		System.out.println("# 3 - Voc� � Advogado? (S/N)");
		
		String UserLaywerString = Leitor.readString();

		switch (UserLawyer) {
		case 1: UserLaywerString = "S";
			break;
		case 2: UserLaywerString = "N";
			break;
		default:
			System.out.println("Op��o Inv�lida.");
			System.out.println("Digite a op��o desejada(S ou N):");
			UserLaywerString = Leitor.readString();
		}
		
	//User pUser = new User(1, userName, userPass, );
		
	//	UserController.create(pUser);
		
		
		
	}

}
