import static utils.ES.*;
import banco.ContaEspecial;
import banco.ContaBancaria;

public class AppBanco3 {

    private static ContaBancaria c1 = new ContaBancaria ("Ana",1000.00);
    private static ContaBancaria c2= new ContaBancaria ("Charles",450.00);


    private static ContaEspecial[] contas =
    {
        new ContaEspecial("Bob", 800.00,550.00),
    };

    public static void main(String[] args) {
        print("## BANCO v3");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Mostrar informações das contas");
            print("(2) Depositar em todas");
            print("(3) Sacar em todas");
            print("(4) Aumentar limite de todas");
            print("(5) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoMostrarInfo();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            } 
            else if (opcao == 4) {
                opcaoAumentarLim();
            }
            else if (opcao == 5) {
                sair = true;
            } 
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    
    }

        private static void opcaoMostrarInfo() {
            print("\n## Informações das contas:");
            for (int i=0; i<contas.length; i++) {
                print(contas[i].toString());
                print(c1.toString());
                print(c2.toString());
            }
        }
        
        private static void opcaoDepositar() {
            double v = inputDouble("\n## Valor para depósito:");
            for (int i=0; i<contas.length; i++) {
                contas[i].depositar(v);
                c1.depositar(v);
                c2.depositar(v);
                print("\n## Depósito efetuado na conta de  " 
                    + contas[i].getNomeCorrentista() + "!"); 
                print("\n## Depósito efetuado na conta de  " 
                    + c1.getNomeCorrentista()+ "!"); 
                print("\n## Depósito efetuado na conta de  " 
                    + c2.getNomeCorrentista()+ "!"); 
            }
            
        }
    
        private static void opcaoSacar() {
            double v = inputDouble("\n## Valor para saque:");
            for (int i=0; i<contas.length; i++) {
                if (contas[i].sacar(v)) {
                    print("\n## Saque efetuado na conta de "
                        + contas[i].getNomeCorrentista() + "!");        
                }
                if (c1.sacar(v)) {
                    print("\n## Saque efetuadona conta de  " 
                    + c1.getNomeCorrentista()+ "!");       
                }
                if (c2.sacar(v)) {
                    print("\n## Saque efetuado na conta de  " 
                    + c2.getNomeCorrentista()+ "!");        
                }
                else {
                    print("\n## Saldo insuficiente para efetuar o saque na conta de"
                        + contas[i].getNomeCorrentista() + "!");
                }
            }
    }

        private static void opcaoAumentarLim(){
            double v = inputDouble("\n## Valor a ser adicionado ao limite de todas:");
        for (int i=0; i<contas.length; i++) {
            contas[i].adicionar(v);
            print("\n## Limite adiconado nas contas de " 
                + contas[i].getNomeCorrentista() + "!");        
        }
        }
    
}