package opet.marketplace.view;

import java.util.Date;

import opet.marketplace.controller.UserController;
import opet.marketplace.util.Leitor;
import opet.marketplace.util.Validador;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

public class EntregaParcialCrudView
{
  public EntregaParcialCrudView()
  {
/*  16 */     System.out.println("Bem Vindo!");
  }



  public void menu()
  {
/*  23 */     System.out.flush();
/*  24 */     System.out.println("Entrega parcial. Crud de usu�rios");
/*  25 */     System.out.println("###### MENU ######");
/*  26 */     System.out.println("1 - Inserir Usu�rio");
/*  27 */     System.out.println("2 - Alterar Usu�rio");
/*  28 */     System.out.println("3 - Deletar Usu�rios");
/*  29 */     System.out.println("4 - Listar Usu�rios");

/*  31 */     int menuControl = Leitor.readInt("Selecione uma op��o (1, 2, 3, 4)");

/*  33 */     switch (menuControl) {
    case 1:
/*  35 */       insertUser();
/*  36 */       break;
    case 2:
/*  38 */       updateUser();
/*  39 */       break;
    case 3:
/*  41 */       deleteUser();
/*  42 */       break;
    case 4:
/*  44 */       searchUsers();
/*  45 */       break;


    default:
/*  49 */       System.out.println("Op��o inv�lida");
/*  50 */       menuControl = Leitor.readInt("Selecione uma op��o (1, 2, 3, 4)");
    }

  }

  public void insertUser()
  {
/*  57 */     UserController UserController = new UserController();



/*  61 */     Date Date = new Date();
/*  62 */     int UserLawyer = 0;

/*  64 */     System.out.flush();
/*  65 */     System.out.println("##I AM THE LAW - Cria��o de Usu�rio ##");
/*  66 */     System.out.println("# 1 - Qual seu nome?");
    String UserName;
    do
    {
/*  70 */       UserName = Leitor.readString();
/*  71 */       if (Validador.alfabetico(UserName)) {
        break;
      }
/*  74 */       System.out.println("Digitar apenas caracteres alfabeticos.");
/*  75 */       System.out.println("Digite seu nome novamente.");
    }
/*  77 */     while (!Validador.alfabetico(UserName));

/*  79 */     System.out.println("# 2 - Escolha uma senha.");

/*  81 */     String UserPass = Leitor.readString();

/*  83 */     System.out.println("# 2 - Qual seu e-mail?");
    String UserEmail;
    do
    {
/*  87 */       UserEmail = Leitor.readString();
/*  88 */       if (Validador.validarEmail(UserEmail)) {
        break;
      }
/*  91 */       System.out.println("Email inv�lido.");
/*  92 */       System.out.println("Digite seu email novamente.");
    }
/*  94 */     while (!Validador.validarEmail(UserEmail));



/*  98 */     System.out.println("# 3 - Voc� � Advogado? (S/N)");

/* 100 */     String UserLaywerString = Leitor.readString();

/* 102 */     switch (UserLawyer) {
    case 1:
/* 104 */       UserLaywerString = "S";
/* 105 */       break;
    case 2:
/* 107 */       UserLaywerString = "N";
/* 108 */       break;
    default:
/* 110 */       System.out.println("Op��o Inv�lida.");
/* 111 */       System.out.println("Digite a op��o desejada(S ou N):");
/* 112 */       UserLaywerString = Leitor.readString();
    }

/* 115 */     if (UserLawyer == 1)
    {
/* 117 */       User NewUser = new Lawyer(1, UserName, UserPass, UserEmail, Date);
/* 118 */       UserController.create(NewUser);
/* 119 */       menu();
    }
    else
    {
/* 123 */       User NewUser = new Client(1, UserName, UserPass, UserEmail, Date);
/* 124 */       UserController.create(NewUser);
/* 125 */       menu();
    }
  }



  public void updateUser()
  {
/* 133 */     UserController UserController = new UserController();




/* 138 */     Date Date = new Date();
/* 139 */     int UserLawyer = 0;

/* 141 */     System.out.flush();
/* 142 */     System.out.println("##I AM THE LAW - Altera��o de Usu�rio ##");


/* 145 */     System.out.println("# 1 - Qual ID do usu�rio?");
/* 146 */     int UserId = Leitor.readInt();


/* 149 */     System.out.println("# 2 - Qual o nome novo?");
    String UserName;
    do
    {
/* 153 */       UserName = Leitor.readString();
/* 154 */       if (Validador.alfabetico(UserName)) {
        break;
      }
/* 157 */       System.out.println("Digitar apenas caracteres alfabeticos.");
/* 158 */       System.out.println("Digite seu nome novamente.");
    }
/* 160 */     while (!Validador.alfabetico(UserName));

/* 162 */     System.out.println("# 2 - Escolha uma senha nova.");

/* 164 */     String UserPass = Leitor.readString();

/* 166 */     System.out.println("# 2 - Qual novo e-mail?");
    String UserEmail;
    do
    {
/* 170 */       UserEmail = Leitor.readString();
/* 171 */       if (Validador.validarEmail(UserEmail)) {
        break;
      }
/* 174 */       System.out.println("Email inv�lido.");
/* 175 */       System.out.println("Digite seu email novamente.");
    }
/* 177 */     while (!Validador.validarEmail(UserEmail));



/* 181 */     System.out.println("# 3 - Usu�rio � Advogado? (S/N)");

/* 183 */     String UserLaywerString = Leitor.readString();

/* 185 */     switch (UserLawyer) {
    case 1:
/* 187 */       UserLaywerString = "S";
/* 188 */       break;
    case 2:
/* 190 */       UserLaywerString = "N";
/* 191 */       break;
    default:
/* 193 */       System.out.println("Op��o Inv�lida.");
/* 194 */       System.out.println("Digite a op��o desejada(S ou N):");
/* 195 */       UserLaywerString = Leitor.readString();
    }

/* 198 */     if (UserLawyer == 1)
    {
/* 200 */       User NewUser = new Lawyer(UserId, UserName, UserPass, UserEmail, Date);
/* 201 */       UserController.update(NewUser);
/* 202 */       menu();
    }
    else
    {
/* 206 */       User NewUser = new Client(UserId, UserName, UserPass, UserEmail, Date);
/* 207 */       UserController.update(NewUser);
/* 208 */       menu();
    }
  }



  public void deleteUser()
  {
/* 216 */     UserController UserController = new UserController();


/* 219 */     System.out.flush();
/* 220 */     System.out.println("##I AM THE LAW - Dele��o de Usu�rio ##");


/* 223 */     System.out.println("# 1 - Qual ID do usu�rio?");
/* 224 */     int UserId = Leitor.readInt();
/* 225 */     UserController.delete(UserId);
/* 226 */     menu();
  }



  public void searchUsers()
  {
/* 233 */     UserController UserController = new UserController();
/* 234 */     java.util.List<User> ListaUsuarios = UserController.search();

/* 236 */     System.out.println("# - Pesquisa de Usu�rios");
/* 237 */     for (User user : ListaUsuarios) {
/* 238 */       System.out.println("---------------");
/* 239 */       System.out.println("ID: " + user.getUserId());
/* 240 */       System.out.println("Nome: " + user.getUserName());
/* 241 */       System.out.println("Senha: " + user.getUserPass());
/* 242 */       System.out.println("Email: " + user.getUserEmail());
/* 243 */       if ((user instanceof Lawyer)) {
/* 244 */         System.out.println("Tipo: Advogado");
      } else {
/* 246 */         System.out.println("Tipo: Cliente");
      }
/* 248 */       System.out.println("---------------");
    }
  }
}