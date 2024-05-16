import java.util.Scanner;

public class exe03 {
    public static void main(String[] args) {

        EntradaSaidas entradaSaidas = new EntradaSaidas();

        Emprestimo emprestimo = new Emprestimo();

        double salarioAtual = entradaSaidas.solicitarSalarioAtual();

        double valorEmprestimo = entradaSaidas.solicitarValorEmprestimo();

        if (emprestimo.verificarViabilidadeDoEmprestimo(salarioAtual, valorEmprestimo)) {

            double valorParcela = emprestimo.calcularValorParcela(valorEmprestimo);

            double valorTotalPago = emprestimo.calcularValorTotalPago(valorEmprestimo);

            entradaSaidas.mostrarInformacoesEmprestimo(valorParcela, valorTotalPago);

        } else {

            System.out.println("O empréstimo não é viável. O valor da parcela ultrapassa 15% do salário atual.");

        }
    }
}

class Emprestimo {
    private static final double taxa_juros = 0.35;    // Variável constante para armazenar o valor de alguma constante específica.
    private static final double max_emprestimo = 2000000; // Constante que define o valor máximo de empréstimo permitido.

    public boolean verificarViabilidadeDoEmprestimo(double salarioAtual, double valorEmprestimo) {

        double valorParcela = calcularValorParcela(valorEmprestimo);

        double limiteParcela = salarioAtual * 0.15;

        return valorParcela <= limiteParcela && valorEmprestimo <= max_emprestimo;
    }

    public double calcularValorParcela(double valorEmprestimo) {

        double valorTotalComJuros = valorEmprestimo * (1 + taxa_juros);

        return valorTotalComJuros / 24;

    }

    public double calcularValorTotalPago(double valorEmprestimo) {

        return valorEmprestimo * (1 + taxa_juros);
    }

}

class EntradaSaidas {

    private Scanner scanner;

    public EntradaSaidas () {

        this.scanner = new Scanner(System.in);

    }

    public double solicitarSalarioAtual() {

        System.out.print("Digite seu salário atual: ");

        return scanner.nextDouble();

    }

    public double solicitarValorEmprestimo() {

        System.out.print("Digite o valor que deseja emprestar: ");

        return scanner.nextDouble();

    }

    public void mostrarInformacoesEmprestimo(double valorParcela, double valorTotalPago) {

        System.out.println("\nDetalhes do Empréstimo:");

        System.out.println("Valor da Parcela: R$" + valorParcela);

        System.out.println("Valor Total a Pagar: R$" + valorTotalPago);

    }

}