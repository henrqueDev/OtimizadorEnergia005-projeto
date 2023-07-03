package model;

public class Docente {

    private Integer id;
    private String nome;

    public Docente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

}
