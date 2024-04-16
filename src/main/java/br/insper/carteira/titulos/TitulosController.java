package br.insper.carteira.titulos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TitulosController {

    @Autowired
    private TitulosService titulosService;

    @GetMapping("/titulos")
    public List<Titulos> getTitulos(@RequestParam(required = false) String tipo) {
        return titulosService.listarTitulos(tipo);
    }

    @PostMapping("/titulos")
    @ResponseStatus(HttpStatus.CREATED)
    public Titulos salvarTitulo(@RequestBody Titulos titulo) {
        return titulosService.cadastrarTitulo(titulo);
    }

}
