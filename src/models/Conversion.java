package models;

import java.util.HashMap;
import java.util.Map;


public class Conversion {

    private String baseCode;
    private String targetCode;
    private double value;
    private double newValue;
    private double tax;
    private Map<String, Double> conversionRates;

    public Conversion(String baseCoin) {
        this.baseCode = baseCoin;
    }

    public Conversion(String baseCode, String targetCode, double value) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.value = value;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getValue() {
        return value;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void listConversionRates(){
        Double value;
        for (String key : conversionRates.keySet()) {
            value = conversionRates.get(key);
            System.out.println("  -> " + key + ": " + value);
        }
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = new HashMap<>(conversionRates);
    }

    public void makeConversion(){
        this.newValue = this.value * this.tax;
    }

    @Override
    public String toString() {
        return  String.format("Conversão de %.2f %s para %s com taxa de %f é %.2f",
                value, baseCode, targetCode, tax, newValue);
    }
}
