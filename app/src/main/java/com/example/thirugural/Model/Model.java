package com.example.thirugural.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Model {

    @SerializedName("kural")
    @Expose
    private List<Kural> kural = null;
    @SerializedName("repo")
    @Expose
    private String repo;

    public List<Kural> getKural() {
        return kural;
    }

    public void setKural(List<Kural> kural) {
        this.kural = kural;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

}
