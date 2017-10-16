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
		System.out.println("Entrega parcial. Crud de usuários");
		System.out.println("###### MENU ######");
		System.out.println("1 - Inserir Usuário");
		System.out.println("2 - Alterar Usuário");
		System.out.println("3 - Deletar Usuários");		
		System.out.println("4 - Listar Usuários");				
		
		menuControl = Leitor.readInt("Selecione uma opção (1, 2, 3, 4)");
		
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
			System.out.println("Opção inválida");
			menuControl = Leitor.readInt("Selecione uma opção (1, 2, 3, 4)");
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
		System.out.println("##I AM THE LAW - Criação de Usuário ##");
		System.out.println("# 1 - Qual seu nome?");

		// Se não for alfabetico, faça de novo. Se for, break the loop
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

		// Se não for email, faça de novo. Se for, break the loop
		do {
			UserEmail = Leitor.readString();
			if (Validador.validarEmail(UserEmail)) {
				break;
			} else {
				System.out.println("Email inválido.");
				System.out.println("Digite seu email novamente.");
			}
		} while (Validador.validarEmail(UserEmail) == false);

		// Valida se é advogado ou não

		System.out.println("# 3 - Você é Advogado? (S/N)");

		String UserLaywerString = Leitor.readString();

		switch (UserLawyer) {
		case 1:
			UserLaywerString = "S";
			break;
		case 2:
			UserLaywerString = "N";
			break;
		default:
			System.out.println("Opção Inválida.");
			System.out.println("Digite a opção desejada(S ou N):");
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
		System.out.println("##I AM THE LAW - Alteração de Usuário ##");
		

		System.out.println("# 1 - Qual ID do usuário?");
		UserId = Leitor.readInt();
		
		
		System.out.println("# 2 - Qual o nome novo?");

		// Se não for alfabetico, faça de novo. Se for, break the loop
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

		// Se não for email, faça de novo. Se for, break the loop
		do {
			UserEmail = Leitor.readString();
			if (Validador.validarEmail(UserEmail)) {
				break;
			} else {
				System.out.println("Email inválido.");
				System.out.println("Digite seu email novamente.");
			}
		} while (Validador.validarEmail(UserEmail) == false);

		// Valida se é advogado ou não

		System.out.println("# 3 - Usuário é Advogado? (S/N)");

		String UserLaywerString = Leitor.readString();

		switch (UserLawyer) {
		case 1:
			UserLaywerString = "S";
			break;
		case 2:
			UserLaywerString = "N";
			break;
		default:
			System.out.println("Opção Inválida.");
			System.out.println("Digite a opção desejada(S ou N):");
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
		System.out.println("##I AM THE LAW - Deleção de Usuário ##");
		

		System.out.println("# 1 - Qual ID do usuário?");
		UserId = Leitor.readInt();
					UserController.delete(UserId);
			menu();
							
		
	}
	
	public void searchUsers() {
		
		UserController UserController = new UserController();
		List<User> ListaUsuarios = UserController.search();
		
		System.out.println("# - Pesquisa de Usuários");
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
