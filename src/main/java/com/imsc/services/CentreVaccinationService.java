package com.imsc.services;

import com.imsc.entities.CentreVaccination;
import com.imsc.repositories.CentreVaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CentreVaccinationService {

    @Autowired
    private CentreVaccinationRepository centreVaccinationRepository;

    @Transactional(readOnly = true)
    public List<CentreVaccination> getAllCentres() {
        return centreVaccinationRepository.findAll();
    }

    @Transactional
    public void saveCentre(CentreVaccination centre) {
        centreVaccinationRepository.save(centre);
    }
}
