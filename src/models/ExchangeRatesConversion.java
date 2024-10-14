package models;

import java.util.Map;

public record ExchangeRatesConversion(String baseCode,
                                      String targetCode,
                                      double conversionRate,
                                      double conversionValue,
                                      Map<String, Double> conversionRates) {
}
