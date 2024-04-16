package br.insper.carteira.titulos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitulosService {

    @Autowired
    private TitulosRepository titulosRepository;

    public Titulos cadastrarTitulo(Titulos titulo) {
        if (titulo.getNome().equals("")) {
            return null;
        } else {
            return titulosRepository.save(titulo);
        }
    }

    public List<Titulos> listarTitulos(String tipo) {
        if (tipo != null) {
            return titulosRepository.findByTipo(tipo);
        }

        return titulosRepository.findAll();
    }

    public Titulos getTitulo(Integer id) {
        return titulosRepository.getById(id);
    }


}
