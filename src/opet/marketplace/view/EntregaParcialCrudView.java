package opet.marketplace.view;

import java.util.Date;
import java.util.List;

import opet.marketplace.controller.UserController;
import opet.marketplace.util.Leitor;
import opet.marketplace.util.Validador;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

public class EntregaParcialCrudView {
	
	public EntregaParcialCrudView(){
		System.out.println("Bem Vindo!");
	}
	
	public void menu(){
		
		int menuControl;
	
		System.out.flush();
		System.out.println("Entrega parcial. Crud de usu�rios");
		System.out.println("###### MENU ######");
		System.out.println("1 - Inserir Usu�rio");
		System.out.println("2 - Alterar Usu�rio");
		System.out.println("3 - Deletar Usu�rios");		
		System.out.println("4 - Listar Usu�rios");				
		
		menuControl = Leitor.readInt("Selecione uma op��o (1, 2, 3, 4)");
		
		switch (menuControl) {
		case 1:
			insertUser();
			break;
		case 2:
			updateUser();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			searchUsers();
			break;
			
			
		default:
			System.out.println("Op��o inv�lida");
			menuControl = Leitor.readInt("Selecione uma op��o (1, 2, 3, 4)");
		}
		
	}

	public void insertUser() {

		UserController UserController = new UserController();
		String UserName;
		String UserPass;
		String UserEmail;
		Date Date = new Date();
		int UserLawyer = 0;

		System.out.flush();
		System.out.println("##I AM THE LAW - Cria��o de Usu�rio ##");
		System.out.println("# 1 - Qual seu nome?");

		// Se n�o for alfabetico, fa�a de novo. Se for, break the loop
		do {
			UserName = Leitor.readString();
			if (Validador.alfabetico(UserName)) {
				break;
			} else {
				System.out.println("Digitar apenas caracteres alfabeticos.");
				System.out.println("Digite seu nome novamente.");
			}
		} while (Validador.alfabetico(UserName) == false);

		System.out.println("# 2 - Escolha uma senha.");

		UserPass = Leitor.readString();

		System.out.println("# 2 - Qual seu e-mail?");

		// Se n�o for email, fa�a de novo. Se for, break the loop
		do {
			UserEmail = Leitor.readString();
			if (Validador.validarEmail(UserEmail)) {
				break;
			} else {
				System.out.println("Email inv�lido.");
				System.out.println("Digite seu email novamente.");
			}
		} while (Validador.validarEmail(UserEmail) == false);

		// Valida se � advogado ou n�o

		System.out.println("# 3 - Voc� � Advogado? (S/N)");

		String UserLaywerString = Leitor.readString();

		switch (UserLawyer) {
		case 1:
			UserLaywerString = "S";
			break;
		case 2:
			UserLaywerString = "N";
			break;
		default:
			System.out.println("Op��o Inv�lida.");
			System.out.println("Digite a op��o desejada(S ou N):");
			UserLaywerString = Leitor.readString();
		}

		if (UserLawyer == 1) {

			User NewUser = new Lawyer(1, UserName, UserPass, UserEmail, Date);
			UserController.create(NewUser);
			menu();
			
		} else {

			User NewUser = new Client(1, UserName, UserPass, UserEmail, Date);
			UserController.create(NewUser);
			menu();
		}
		
		
	}

	public void updateUser() {

		UserController UserController = new UserController();
		int UserId;
		String UserName;
		String UserPass;
		String UserEmail;
		Date Date = new Date();
		int UserLawyer = 0;

		System.out.flush();
		System.out.println("##I AM THE LAW - Altera��o de Usu�rio ##");
		

		System.out.println("# 1 - Qual ID do usu�rio?");
		UserId = Leitor.readInt();
		
		
		System.out.println("# 2 - Qual o nome novo?");

		// Se n�o for alfabetico, fa�a de novo. Se for, break the loop
		do {
			UserName = Leitor.readString();
			if (Validador.alfabetico(UserName)) {
				break;
			} else {
				System.out.println("Digitar apenas caracteres alfabeticos.");
				System.out.println("Digite seu nome novamente.");
			}
		} while (Validador.alfabetico(UserName) == false);

		System.out.println("# 2 - Escolha uma senha nova.");

		UserPass = Leitor.readString();

		System.out.println("# 2 - Qual novo e-mail?");

		// Se n�o for email, fa�a de novo. Se for, break the loop
		do {
			UserEmail = Leitor.readString();
			if (Validador.validarEmail(UserEmail)) {
				break;
			} else {
				System.out.println("Email inv�lido.");
				System.out.println("Digite seu email novamente.");
			}
		} while (Validador.validarEmail(UserEmail) == false);

		// Valida se � advogado ou n�o

		System.out.println("# 3 - Usu�rio � Advogado? (S/N)");

		String UserLaywerString = Leitor.readString();

		switch (UserLawyer) {
		case 1:
			UserLaywerString = "S";
			break;
		case 2:
			UserLaywerString = "N";
			break;
		default:
			System.out.println("Op��o Inv�lida.");
			System.out.println("Digite a op��o desejada(S ou N):");
			UserLaywerString = Leitor.readString();
		}

		if (UserLawyer == 1) {

			User NewUser = new Lawyer(UserId, UserName, UserPass, UserEmail, Date);
			UserController.update(NewUser);
			menu();
			
		} else {

			User NewUser = new Client(UserId, UserName, UserPass, UserEmail, Date);
			UserController.update(NewUser);
			menu();
		}
		
		
	}

	public void deleteUser() {

		UserController UserController = new UserController();
		int UserId;
		
		System.out.flush();
		System.out.println("##I AM THE LAW - Dele��o de Usu�rio ##");
		

		System.out.println("# 1 - Qual ID do usu�rio?");
		UserId = Leitor.readInt();
					UserController.delete(UserId);
			menu();
							
		
	}
	
	public void searchUsers() {
		
		UserController UserController = new UserController();
		List<User> ListaUsuarios = UserController.search();
		
		System.out.println("# - Pesquisa de Usu�rios");
		for (User user : ListaUsuarios) {
			System.out.println("---------------");
			System.out.println("ID: " + user.getUserId());
			System.out.println("Nome: " + user.getUserName());
			System.out.println("Senha: " + user.getUserPass());
			System.out.println("Email: " + user.getUserEmail());
			if(user instanceof Lawyer){
				System.out.println("Tipo: Advogado");
			}else{
				System.out.println("Tipo: Cliente");
			}
			System.out.println("---------------");
		}
	}

	
}
