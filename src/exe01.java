import java.util.Scanner;

public class exe01 {
    public static void main(String[] args) {

        double[] notas = MetodosEntradaSaida.lerNotas();

        System.out.print("Qual média deseja voce deseja calcular? (aritmética ou ponderada):");

        String opcao = MetodosEntradaSaida.scanner.nextLine();

        if (opcao.equalsIgnoreCase("aritmetica")) {

            double media = Calculo.calcularMediaAritmetica(notas[0], notas[1]);

            Resultado.mostrarResultado(media);

        } else if (opcao.equalsIgnoreCase("ponderada")) {

            double[] pesos = MetodosEntradaSaida.lerPesos();

            double media = Calculo.calcularMediaPonderada(notas[0], notas[1], pesos[0], pesos[1]);

            Resultado.mostrarResultado(media);

        } else {

            System.out.println("Opção inválida meu caro amigo. Tenta Novamente.....");

        }
    }
}

class MetodosEntradaSaida {
    static Scanner scanner = new Scanner(System.in);

    static double lerNota(int numeroNota) {

        double nota;

        do {

            System.out.print("Digite a nota " + numeroNota + " (0 a 10): ");

            nota = Double.parseDouble(scanner.nextLine());

        } while (!validarNota(nota));

        return nota;
    }

    static double[] lerNotas() {

        double[] notas = new double[2];

        notas[0] = lerNota(1);

        notas[1] = lerNota(2);

        return notas;
    }

    static double[] lerPesos() {

        double[] pesos = new double[2];

        for (int i = 0; i < pesos.length; i++) {

            System.out.print("Digite o peso da nota " + (i + 1) + ": ");

            pesos[i] = scanner.nextDouble();

        }

        return pesos;

    }

    static boolean validarNota(double nota) {

        return nota >= 0 && nota <= 10;
    }

}

class Calculo {

    static double calcularMediaAritmetica(double nota1, double nota2) {

        return (nota1 + nota2) / 2;

    }

    static double calcularMediaPonderada(double nota1, double nota2, double peso1, double peso2) {

        return (nota1 * peso1 + nota2 * peso2) / (peso1 + peso2);
    }
}

class Resultado {
    static void mostrarResultado(double media) {

        if (media > 7) {

            System.out.println("O aluno foi aprovado !! ");

        } else {

            System.out.println("Infelizmente o aluno foi reprovado ");
        }
    }
}