package br.insper.carteira.titulos;

import jakarta.persistence.*;

@Entity
public class Titulos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String identificador;

    private String tipo;

    public Titulos() {

    }

    public Titulos(String nome, String identificador, String tipo) {
        this.nome = nome;
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
