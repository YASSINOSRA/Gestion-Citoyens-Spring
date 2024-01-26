package com.imsc.services;

import com.imsc.entities.Citoyen;
import com.imsc.repositories.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitoyenService {

    @Autowired
    private CitoyenRepository citoyenRepository;

    public List<Citoyen> getAllCitizens() {
        return citoyenRepository.findAll();
    }

    public List<Citoyen> getCitizensByNom(String nom) {
        return citoyenRepository.findByNom(nom);
    }

    @Transactional
    public void saveCitoyen(Citoyen citoyen) {
        citoyenRepository.save(citoyen);
    }

    public boolean citizenExists(String nom) {
        List<Citoyen> existingCitizens = citoyenRepository.findByNom(nom);
        return !existingCitizens.isEmpty();
    }
}
