package app;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> lista = new ArrayList<>();

        System.out.print("Der entrada na quantidade de funcionarios: ");
        int quantidadeDeFuncionarios = sc.nextInt();

        for (int i = 1; i <= quantidadeDeFuncionarios; i++){
            System.out.println("Dados do funcionario n " + i + " data:");

            System.out.print("O funcionario é terceirizado? (s/n)");
            char simOuNao = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Quantidade de horas: ");
            int horas = sc.nextInt();

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            if (simOuNao == 's'){
                System.out.print("Cobrança Adicional: ");
                double cobrancaAdicional = sc.nextDouble();
                lista.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, cobrancaAdicional));
            }
            else {
                lista.add(new Funcionario(nome,horas, valorPorHora));
            }
        }

        System.out.println();
        System.out.println("Pagamentos: ");

        for (Funcionario funcionario : lista){
            System.out.println(funcionario.getNome() + " - $ " + String.format("%.2f", funcionario.pagamento()));
        }



        sc.close();
    }
}
