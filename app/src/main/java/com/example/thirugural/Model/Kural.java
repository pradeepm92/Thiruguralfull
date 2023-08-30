package com.example.thirugural.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kural {
    @SerializedName("Number")
    @Expose
    private Integer number;
    @SerializedName("Line1")
    @Expose
    private String line1;
    @SerializedName("Line2")
    @Expose
    private String line2;
    @SerializedName("Translation")
    @Expose
    private String translation;
    @SerializedName("mv")
    @Expose
    private String mv;
    @SerializedName("sp")
    @Expose
    private String sp;
    @SerializedName("mk")
    @Expose
    private String mk;
    @SerializedName("explanation")
    @Expose
    private String explanation;
    @SerializedName("couplet")
    @Expose
    private String couplet;
    @SerializedName("transliteration1")
    @Expose
    private String transliteration1;
    @SerializedName("transliteration2")
    @Expose
    private String transliteration2;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getCouplet() {
        return couplet;
    }

    public void setCouplet(String couplet) {
        this.couplet = couplet;
    }

    public String getTransliteration1() {
        return transliteration1;
    }

    public void setTransliteration1(String transliteration1) {
        this.transliteration1 = transliteration1;
    }

    public String getTransliteration2() {
        return transliteration2;
    }

    public void setTransliteration2(String transliteration2) {
        this.transliteration2 = transliteration2;
    }

}
