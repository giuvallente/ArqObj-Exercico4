package br.insper.carteira.investimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestimentosController {

    @Autowired
    private InvestimentosService investimentosService;

    @GetMapping("/investimentos/{cpf}")
    public List<Investimentos> getInvestimentos(@PathVariable String cpf) {
        return investimentosService.listarInvestimentos(cpf);
    }

    @PostMapping("/investimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Investimentos salvarInvestimentos(@RequestBody Investimentos investimentos) {
        return investimentosService.cadastrarInvestimento(investimentos);
    }
}
