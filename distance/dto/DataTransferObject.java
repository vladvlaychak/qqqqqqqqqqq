package ru.itcsolutions.currencies.dto;

// Откуда эти переменные взялись

public class DataTransferObject {
    private Double course;
    private int codeNum;
    private String code;

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public int getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
