package br.insper.carteira.investimentos;

import br.insper.carteira.investidor.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos, Integer> {

    public List<Investimentos> findByInvestidor(Investidor investidor);
}
