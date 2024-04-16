package br.insper.carteira.investidor;

import br.insper.carteira.investimentos.Investimentos;
import br.insper.carteira.investimentos.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private InvestimentosRepository investimentoRepository;

    public Investidor cadastrarInvestidor(Investidor investidor) {
        if (investidor.getNome().equals("")) {
            return null;
        } else {
            return investidorRepository.save(investidor);
        }
    }

    public Investidor getInvestidor(Integer id) {
        return investidorRepository.findById(id).orElse(null);
    }

    public Investidor getInvestidorCpf(String cpf) {return investidorRepository.findByCpf(cpf);}

    public List<Investidor> listarInvestidores(String perfilInvestidor) {
        if (perfilInvestidor != null) {
            return investidorRepository.findByPerfilInvestidor(perfilInvestidor);
        }
        return investidorRepository.findAll();
    }

    public Investidor deletarInvestidor(Integer id) {
        Investidor investidor = investidorRepository.findById(id).orElse(null);
        if (investidor == null) {
            throw new RuntimeException("Investidor não encontrado");
        }

        List<Investimentos> investimentos = investimentoRepository.findByInvestidor(investidor);

        if (investimentos.isEmpty()) {
            investidorRepository.deleteById(id);
        }

        else {
            throw new RuntimeException("Investidor possui investimentos");
        }

        return investidor;
    }



}
