 package opet.marketplace.view;

 import java.util.Date;

import opet.marketplace.controller.UserController;
import opet.marketplace.util.Leitor;
import opet.marketplace.util.Validador;


 public class LoginView
 {
   public LoginView()
   {
/*  14 */     System.out.println("##I AM THE LAW - LOGIN ##");
/*  15 */     System.out.println("# 1 - J� sou cadastrado");
/*  16 */     System.out.println("# 2 - Fazer cadastro");
/*  17 */     System.out.println("# 9 - Sair");
/*  18 */     System.out.println("#########################");
/*  19 */     System.out.println("Digite a op��o desejada(1 ou 2):");

/*  21 */     int optionInt = Leitor.readInt();

/*  23 */     switch (optionInt)
     {
     case 1:
       break;
     case 2:
       break;

     case 9:
       break;

     default:
/*  34 */       System.out.println("Op��o Inv�lida.");
/*  35 */       System.out.println("Digite a op��o desejada(1 ou 2):");
/*  36 */       optionInt = Leitor.readInt();
     }

   }

   public void CreateNewUser()
   {
/*  43 */     UserController UserController = new UserController();



/*  47 */     Date Date = new Date();
/*  48 */     int UserLawyer = 0;

/*  50 */     System.out.flush();
/*  51 */     System.out.println("##I AM THE LAW - Cria��o de Usu�rio ##");
/*  52 */     System.out.println("# 1 - Qual seu nome?");
     String UserName;
     do
     {
/*  56 */       UserName = Leitor.readString();
/*  57 */       if (Validador.alfabetico(UserName)) {
         break;
       }

/*  61 */       System.out.println("Digitar apenas caracteres alfabeticos.");
/*  62 */       System.out.println("Digite seu nome novamente.");

     }
/*  65 */     while (!Validador.alfabetico(UserName));

/*  67 */     System.out.println("# 2 - Escolha uma senha.");

/*  69 */     String UserPass = Leitor.readString();


/*  72 */     System.out.println("# 2 - Qual seu e-mail?");
     String UserEmail;
     do
     {
/*  76 */       UserEmail = Leitor.readString();
/*  77 */       if (Validador.validarEmail(UserEmail)) {
         break;
       }

/*  81 */       System.out.println("Email inv�lido.");
/*  82 */       System.out.println("Digite seu email novamente.");

     }
/*  85 */     while (!Validador.validarEmail(UserEmail));



/*  89 */     System.out.println("# 3 - Voc� � Advogado? (S/N)");

/*  91 */     String UserLaywerString = Leitor.readString();

/*  93 */     switch (UserLawyer) {
/*  94 */     case 1:  UserLaywerString = "S";
/*  95 */       break;
/*  96 */     case 2:  UserLaywerString = "N";
/*  97 */       break;
     default:
/*  99 */       System.out.println("Op��o Inv�lida.");
/* 100 */       System.out.println("Digite a op��o desejada(S ou N):");
/* 101 */       UserLaywerString = Leitor.readString();
     }
   }
 }
