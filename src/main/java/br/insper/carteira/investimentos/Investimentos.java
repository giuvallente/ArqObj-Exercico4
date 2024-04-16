package br.insper.carteira.investimentos;

import br.insper.carteira.investidor.Investidor;
import br.insper.carteira.titulos.Titulos;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Investimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "investidor_id")
    private Investidor investidor;

    @ManyToOne
    @JoinColumn(name = "titulo_id")
    private Titulos titulo;

    private Double valorInvestido;

    private LocalDateTime dataInvestimento;

    public Investimentos() {
    }

    public Investimentos(Investidor investidor, Titulos titulo, Double valorInvestido) {
        this.investidor = investidor;
        this.titulo = titulo;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Titulos getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulos titulo) {
        this.titulo = titulo;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public LocalDateTime getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(LocalDateTime dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }
}
