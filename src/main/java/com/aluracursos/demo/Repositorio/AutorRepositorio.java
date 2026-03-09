package com.aluracursos.demo.Repositorio;

import com.aluracursos.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND (a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento >= :fecha)")
    List<Autor> buscarAutoresVivosEnDeterminadaFecha(Integer fecha);

    List<Autor> findByFechaDeNacimiento(Integer fecha);

    Optional<Autor> findByNombreAutorContainsIgnoreCase(String nombreAutor);
}
