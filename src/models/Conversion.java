package models;

public class Conversion {

    private String baseCoin;
    private String targetCoin;
    private double value;
    private double newValue;
    private double tax;

    public Conversion(String baseCoin, String targetCoin, double value) {
        this.baseCoin = baseCoin;
        this.targetCoin = targetCoin;
        this.value = value;
    }

    public String getBaseCoin() {
        return baseCoin;
    }

    public String getTargetCoin() {
        return targetCoin;
    }

    public double getValue() {
        return value;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void makeConversion(){
        this.newValue = this.value * this.tax;
    }

    @Override
    public String toString() {
        return  String.format("Conversion of %.2f %s to %s with tax of %f is %.2f",
                value, baseCoin, targetCoin, tax, newValue);
    }
}
