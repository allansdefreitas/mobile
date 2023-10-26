package br.edu.ifpe.tads.pdm.allansfreitas.pratica06.model;

/**
 * Created by allan on 27/12/17.
 */


//@IgnoreExtraProperties
public class User {
    private String name;
    private String email;
    public User() {}
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
