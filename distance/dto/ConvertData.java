package ru.itcsolutions.currencies.dto;

public class ConvertData {
    private String code;
    private Double amount;

    public ConvertData (String code, Double result) {
        this.code=code;
        this.amount= result;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
