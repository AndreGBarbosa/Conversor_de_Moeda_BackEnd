import java.util.Scanner;


public class ConversorMoedas {
    public static void main(String[] args) {
        ConsultaValor novaConsulta = new ConsultaValor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n***** CONVERSOR DE MOEDAS  *****");

            System.out.println("1 - Real --> Dolar");
            System.out.println("2 - Real --> Euro");
            System.out.println("3 - Real --> Libra");
            System.out.println("4 - Real --> Iene");
            System.out.println("5 - Real --> Franco Suíço");
            System.out.println("6 - Sair");
            System.out.println("De acordo com o menu acima, escolha uma opção:");

            int escolha = -1;
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                continue; // Volta para o início do loop
            }
            scanner.nextLine(); // Limpar o buffer do scanner após ler o inteiro

            switch (escolha) {
                case 1:
                    realizarConversao(novaConsulta, "USD");
                    break;
                case 2:
                    realizarConversao(novaConsulta, "EUR");
                    break;
                case 3:
                    realizarConversao(novaConsulta, "GBP");
                    break;
                case 4:
                    realizarConversao(novaConsulta, "JPY");
                    break;
                case 5:
                    realizarConversao(novaConsulta, "CHF");
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    scanner.close(); // Fechar o Scanner
                    return; // Sai do método main e encerra o programa
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void realizarConversao(ConsultaValor consulta, String moedaDestino) {
        // A moeda base é BRL (Real Brasileiro)
        ExchangeRateApi consultaMoeda = consulta.consultaValor("BRL");

        if (consultaMoeda != null && consultaMoeda.conversion_rates() != null) { // Ajustado para record
            Double taxaDeCambio = consultaMoeda.conversion_rates().get(moedaDestino);

            if (taxaDeCambio != null) {
                double valorEmReais;
                Scanner scanner = new Scanner(System.in); // Scanner local para esta função

                System.out.println("Digite o valor em BRL que você deseja converter para " + moedaDestino + ": ");
                if (scanner.hasNextDouble()) {
                    valorEmReais = scanner.nextDouble();
                    double valorConvertido = valorEmReais * taxaDeCambio;
                    System.out.printf("O valor de %.2f BRL convertido para %s é de: %.2f %s%n",
                            valorEmReais, moedaDestino, valorConvertido, moedaDestino);
                    System.out.println("\n********************************");
                } else {
                    System.out.println("Valor inválido inserido.");
                    scanner.nextLine(); // Limpar entrada inválida
                }
                // Não feche o scanner aqui se ele for System.in e usado em loop,
                // mas como criamos um novo, podemos considerar fechá-lo.
                // No entanto, é melhor usar o scanner global ou passá-lo como parâmetro.
                // Para este exemplo, vamos manter um scanner local e o scanner global no main.
            } else {
                System.out.println("Taxa de câmbio para " + moedaDestino + " não disponível na resposta da API.");
                System.out.println("\n********************************");
            }
        } else {
            System.out.println("Erro ao obter as taxas de câmbio. Verifique sua chave de API e conexão com a internet.");
            System.out.println("\n********************************");
        }
    }
}