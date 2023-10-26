package br.edu.ifpe.tads.pdm.allansfreitas.pratica06.model;
import java.lang.annotation.Annotation;

/**
 * Created by allan on 27/12/17.
 */

//@IgnoreExtraProperties
public class Message {
    private final String name;
    private final String text;
    public Message() {
        this.name = null;
        this.text = null;
    }
    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }
    public String getName() {
        return name;
    }
    public String getText() {
        return text;
    }
}
