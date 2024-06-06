import java.util.Scanner;

public class exe02 {
    public static void main(String[] args) {

        EntradaSaida entradaSaida = new EntradaSaida();

        Calcular calcular = new Calcular();

        double salarioBruto = entradaSaida.solicitarSalarioBruto();

        while (!Validacao.validarSalario(salarioBruto)) {

            System.out.println("Salário inválido. O salário deve estar entre 500 e 30000 reais.");

            salarioBruto = entradaSaida.solicitarSalarioBruto();
        }

        double descontoINSS = calcular.calculaDescontoINSS(salarioBruto);

        double descontoIRPF = calcular.calculaDescontoIRPF(salarioBruto);

        double descontoPlanoSaude = calcular.calculaDescontoPlanoSaude(salarioBruto);

        int horasExtras = entradaSaida.solicitarHorasExtras();

        double acrescimoHorasExtras = calcular.calculaAcrescimoHorasExtras(horasExtras, salarioBruto);

        double salarioLiquido = calcular.calculaSalarioLiquido(salarioBruto, descontoINSS, descontoIRPF, descontoPlanoSaude, acrescimoHorasExtras);

        entradaSaida.mostrarFolhaPagamento(salarioBruto, descontoINSS, descontoIRPF, descontoPlanoSaude, acrescimoHorasExtras, salarioLiquido);
    }
}

class Calcular {
    public double calculaDescontoINSS(double salarioBruto) {
        return salarioBruto * 0.20;
    }

    public double calculaDescontoIRPF(double salarioBruto) {
        return salarioBruto * 0.10;
    }

    public double calculaDescontoPlanoSaude(double salarioBruto) {
        return salarioBruto * 0.05;
    }

    public double calculaAcrescimoHorasExtras(int horasExtras, double salarioBruto) {

        double valorHoraNormal = salarioBruto / 160;

        double valorHoraExtra = valorHoraNormal * 1.5;

        return horasExtras * valorHoraExtra;
    }

    public double calculaSalarioLiquido(double salarioBruto, double descontoINSS, double descontoIRPF, double descontoPlanoSaude, double acrescimoHorasExtras) {

        return salarioBruto - descontoINSS - descontoIRPF - descontoPlanoSaude + acrescimoHorasExtras;

    }
}

class Validacao {
    public static boolean validarSalario(double salarioBruto) {
        return salarioBruto >= 500 && salarioBruto <= 30000;
    }
}

class EntradaSaida {
    private Scanner scanner;

    public EntradaSaida() {
        this.scanner = new Scanner(System.in);
    }

    public double solicitarSalarioBruto() {

        System.out.print("Digite o salário bruto: ");

        return scanner.nextDouble();
    }

    public int solicitarHorasExtras() {

        System.out.print("Digite a quantidade de horas extras realizadas: ");

        return scanner.nextInt();
    }

    public void mostrarFolhaPagamento(double salarioBruto, double descontoINSS, double descontoIRPF, double descontoPlanoSaude, double acrescimoHorasExtras, double salarioLiquido) {

        System.out.println("\nFolha do Pagamento:");

        System.out.println("Salário Bruto: R$" + salarioBruto);

        System.out.println("Desconto INSS: R$" + descontoINSS);

        System.out.println("Desconto IRPF: R$" + descontoIRPF);

        System.out.println("Desconto Plano de Saúde: R$" + descontoPlanoSaude);

        System.out.println("Acréscimo Horas Extras: R$" + acrescimoHorasExtras);

        System.out.println("Salário Líquido: R$" + salarioLiquido);

    }
}
