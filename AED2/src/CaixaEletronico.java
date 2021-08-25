import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double value;
        int qt50, qt10, qt2;
        value = input.nextDouble();
        while (value < 0 || value % 2 != 0) {
            System.out.println("Valor Invalido");
            value = input.nextDouble();
        }
        input.close();
        qt50 = (int) (value / 50);
        qt10 = (int) (value % 50) / 10;
        qt2 = (int) (((value % 50) % 10) / 2);
        System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2", qt50, qt10, qt2);
    }
}
