package com.imsc.controllers;
import com.imsc.entities.Citoyen;
import com.imsc.services.CentreVaccinationService;
import com.imsc.services.CitoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citoyens")
public class CitoyenController {

    @Autowired
    private CitoyenService citoyenService;

    @Autowired
    private CentreVaccinationService centreVaccinationService;

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("citoyen", new Citoyen());
        model.addAttribute("centres", centreVaccinationService.getAllCentres());
        return "ajouterCitoyen";
    }

    @PostMapping("/ajouter")
    public String ajouterCitoyen(@ModelAttribute Citoyen citoyen, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("centres", centreVaccinationService.getAllCentres());
            return "ajouterCitoyen";
        }

        // Check for specific error cases and handle accordingly
        if (citoyenService.citizenExists(citoyen.getNom())) {
            result.rejectValue("nom", "citizen.exists", "Citizen with the same name already exists");
            model.addAttribute("centres", centreVaccinationService.getAllCentres());
            return "ajouterCitoyen";
        }

        citoyenService.saveCitoyen(citoyen);
        return "redirect:/citoyens/afficherCitoyens";
    }

    @GetMapping("/afficherCitoyens")
    public String afficherCitoyens(Model model) {
        model.addAttribute("citoyens", citoyenService.getAllCitizens());
        return "afficherCitoyens";
    }

    @GetMapping("/afficherCentres")
    public String afficherCentres(Model model) {
        // Add logic to retrieve and display centres
        return "afficherCentres";
    }
}
