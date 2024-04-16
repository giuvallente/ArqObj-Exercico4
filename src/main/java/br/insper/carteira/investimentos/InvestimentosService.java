package br.insper.carteira.investimentos;

import br.insper.carteira.investidor.Investidor;
import br.insper.carteira.investidor.InvestidorService;
import br.insper.carteira.titulos.Titulos;
import br.insper.carteira.titulos.TitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentosService {

    @Autowired
    private InvestimentosRepository investimentosRepository;

    @Autowired
    private InvestidorService investidorService;

    @Autowired
    private TitulosService titulosService;

    public Investimentos cadastrarInvestimento(Investimentos investimento) {

        Investidor investidor = investidorService.getInvestidor(investimento.getInvestidor().getId());
        if (investidor == null) {
            throw new RuntimeException("Investidor não encontrado!");
        }

        Titulos titulo = titulosService.getTitulo(investimento.getTitulo().getId());
        if (titulo == null) {
            throw new RuntimeException("Titulo não encontrado!");
        }

        if (investidor.getPerfilInvestidor().equals("Conservador") && titulo.getTipo().equals("Ação")) {
            throw new RuntimeException("Investidor conservador não pode investir em ações!");
        }

        if (investidor.getPerfilInvestidor().equals("Moderado")) {
            List<Investimentos> investimentos = investimentosRepository.findByInvestidor(investidor);
            Double valorTotalInvestido = 0.0;
            Double valorTotalAcoes = 0.0;

            for (Investimentos inv : investimentos) {
                Double valorInvestido = inv.getValorInvestido();
                if (inv.getTitulo().getTipo().equals("Ação")) {
                    valorTotalAcoes += valorInvestido;
                }

                valorTotalInvestido += valorInvestido;
            }

            if (valorTotalAcoes / valorTotalInvestido == 0.5) {
                throw new RuntimeException("Investidor moderado não pode investir mais de 50% em ações!");
            }

            if (valorTotalAcoes / valorTotalInvestido + investimento.getValorInvestido() / (valorTotalInvestido + investimento.getValorInvestido()) > 0.5) {
                throw new RuntimeException("Investidor moderado não pode investir mais de 50% em ações!");
            }
        }

        return investimentosRepository.save(investimento);
    }

    public List<Investimentos> listarInvestimentos(String cpf) {
        Investidor investidor = investidorService.getInvestidorCpf(cpf);

        if (investidor == null) {
            throw new RuntimeException("Investidor não encontrado!");
        }

        return investimentosRepository.findByInvestidor(investidor);
    }


}
