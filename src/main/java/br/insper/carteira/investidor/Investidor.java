package br.insper.carteira.investidor;

import jakarta.persistence.*;

@Entity
public class Investidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    private String perfilInvestidor;

    public Investidor() {
    }

    public  Investidor(String nome, String cpf, String perfilInvestidor) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfilInvestidor = perfilInvestidor;
    }

    public Integer getId() {return id;}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPerfilInvestidor() {
        return perfilInvestidor;
    }

    public void setPerfilInvestidor(String perfilInvestidor) {
        this.perfilInvestidor = perfilInvestidor;
    }
}
