package com.imsc.repositories;

import com.imsc.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {
    List<Citoyen> findByNom(String nom);
}
