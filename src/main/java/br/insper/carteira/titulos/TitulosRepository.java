package br.insper.carteira.titulos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TitulosRepository extends JpaRepository<Titulos, Integer> {

    public List<Titulos> findByTipo(String tipo);
    public Titulos getById(Integer id);
}
