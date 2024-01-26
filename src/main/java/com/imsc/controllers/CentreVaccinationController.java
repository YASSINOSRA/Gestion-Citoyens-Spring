package com.imsc.controllers;
import com.imsc.entities.CentreVaccination;
import com.imsc.services.CentreVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/centres")
public class CentreVaccinationController {

    @Autowired
    private CentreVaccinationService centreVaccinationService;

    @GetMapping("/afficher")
    public String afficherCentres(Model model) {
        model.addAttribute("centres", centreVaccinationService.getAllCentres());
        return "afficherCentres";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjoutCentre(Model model) {
        model.addAttribute("centre", new CentreVaccination());
        return "ajouterCentre";
    }

    @PostMapping("/ajouter")
    public String ajouterCentre(@ModelAttribute CentreVaccination centre, BindingResult result) {
        if (result.hasErrors()) {
            return "ajouterCentre";
        }

        // Check for specific error cases and handle accordingly
        // For example, check if a centre with the same name already exists

        centreVaccinationService.saveCentre(centre);
        return "redirect:/centres/afficher";
    }
}

