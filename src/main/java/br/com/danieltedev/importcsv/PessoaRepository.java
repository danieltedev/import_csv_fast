package br.com.danieltedev.importcsv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PessoaRepository
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    
}