package br.insper.carteira.investidor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestidorRepository extends JpaRepository<Investidor, Integer> {
    public List<Investidor> findByPerfilInvestidor(String perfilInvestidor);

    public Investidor findByCpf(String cpf);
}
