package br.insper.carteira.investidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestidorController {

    @Autowired
    private InvestidorService investidorService;

    @GetMapping("/investidor")
    public List<Investidor> getInvestidores(@RequestParam(required = false) String perfilInvestidor) {
        return investidorService.listarInvestidores(perfilInvestidor);
    }

    @PostMapping("/investidor")
    @ResponseStatus(HttpStatus.CREATED)
    public Investidor salvarInvestidor(@RequestBody Investidor investidor) {
        return investidorService.cadastrarInvestidor(investidor);
    }

    @DeleteMapping("/investidor/{id}")
    public void deletarInvestidor(@PathVariable Integer id) {
        investidorService.deletarInvestidor(id);
    }

}
