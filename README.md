# 💰 Conversor de Moedas | Desafio Alura ONE & Oracle ☕

Bem-vindo ao Conversor de Moedas! Este projeto é uma aplicação backend em Java desenvolvida como parte do desafio do programa **ONE (Oracle Next Education) em parceria com a Alura**. O objetivo principal é demonstrar habilidades em desenvolvimento Java, incluindo consumo de APIs externas, manipulação de dados (JSON) e interação com o usuário através do console.

Este conversor permite que os usuários obtenham taxas de câmbio atualizadas e convertam valores do Real Brasileiro (BRL) para diversas moedas estrangeiras populares.

## ✨ Funcionalidades Principais

* Conversão de **Real Brasileiro (BRL)** para:
    * 💵 Dólar Americano (USD)
    * 💶 Euro (EUR)
    * 💷 Libra Esterlina (GBP)
    * 💴 Iene Japonês (JPY)
    * 🇨🇭 Franco Suíço (CHF)
* Utilização de taxas de câmbio em **tempo real** através da API pública [ExchangeRate-API](https://www.exchangerate-api.com).
* Interface de usuário **interativa e amigável** via linha de comando (CLI).
* Código limpo e organizado seguindo boas práticas de programação Java.

## 🛠️ Tecnologias Utilizadas

* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) (JDK 11+)
* ![Gson](https://img.shields.io/badge/Gson-4285F4?style=for-the-badge&logo=google&logoColor=white) (Para parsing eficiente de JSON)
* **API Externa**: [ExchangeRate-API V6](https://www.exchangerate-api.com/docs/standard-requests)
* **IDE de Desenvolvimento**: IntelliJ IDEA (recomendado)
* **Versionamento**: Git & GitHub

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar o conversor de moedas em seu ambiente local:

### Pré-requisitos

* **Java Development Kit (JDK)**: Versão 11 ou superior instalada e configurada.
* **IntelliJ IDEA** (ou outra IDE Java de sua preferência).
* **Biblioteca Gson**: O arquivo `gson-2.10.1.jar` (ou versão compatível) deve estar configurado no classpath do projeto. Se você o adicionou à pasta `lib/` do projeto, configure-o como uma dependência no IntelliJ (Botão direito no JAR > Add as Library...).
* **Chave de API**: Uma chave de API válida da [ExchangeRate-API](https://www.exchangerate-api.com). Eles oferecem um plano gratuito que é suficiente para este projeto.

### Configuração

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/AndreGBarbosa/Conversor_de_Moeda_BackEnd.git](https://github.com/AndreGBarbosa/Conversor_de_Moeda_BackEnd.git)
    cd Conversor_de_Moeda_BackEnd
    ```
2.  **Abra o projeto** na sua IDE (ex: IntelliJ IDEA).
3.  **Configure a Chave da API:**
    * Obtenha sua chave de API no site da [ExchangeRate-API](https://www.exchangerate-api.com) após o cadastro.
    * No projeto, abra o arquivo `src/ConsultaValor.java`.
    * Localize a linha:
        ```java
        private static final String API_KEY = "SUA_CHAVE_DE_API_AQUI";
        ```
    * Substitua `"SUA_CHAVE_DE_API_AQUI"` pela sua chave de API real.

### Execução

1.  Localize a classe `ConversorMoedas.java` dentro do pacote `src` (ou no pacote padrão).
2.  Execute o método `main()` desta classe.
3.  O programa iniciará no console, apresentando o menu de opções para conversão. Siga as instruções exibidas!

## 🖥️ Demonstração da Interface no Console
