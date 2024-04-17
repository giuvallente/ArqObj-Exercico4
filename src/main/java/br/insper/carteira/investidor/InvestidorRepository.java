package br.insper.carteira.investidor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, Integer> {
    public List<Investidor> findByPerfilInvestidor(String perfilInvestidor);

    public Investidor findByCpf(String cpf);
}
