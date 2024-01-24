package com.coraft.project.model.dto;

public class PayDTO implements java.io.Serializable {
    private String id;
    private int lecCode;

    public PayDTO() {}

    public PayDTO(String id, int lecCode) {
        this.id = id;
        this.lecCode = lecCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLecCode() {
        return lecCode;
    }

    public void setLecCode(int lecCode) {
        this.lecCode = lecCode;
    }

    @Override
    public String toString() {
        return "RegistDTO{" +
                "id='" + id + '\'' +
                ", lecCode=" + lecCode +
                '}';
    }
}
