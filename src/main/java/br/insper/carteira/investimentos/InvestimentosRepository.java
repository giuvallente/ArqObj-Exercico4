package br.insper.carteira.investimentos;

import br.insper.carteira.investidor.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestimentosRepository extends JpaRepository<Investimentos, Integer> {

    public List<Investimentos> findByInvestidor(Investidor investidor);
}
