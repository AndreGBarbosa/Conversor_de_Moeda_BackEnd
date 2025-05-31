import java.util.Map;


public record ExchangeRateApi(
        String base_code, // Moeda base da consulta
        Map<String, Double> conversion_rates // Mapa com as taxas de conversão
) {
}