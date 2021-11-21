package com.mycompany.desctopapp_publishing_6.license;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LicenseController {
    @Autowired private LicenseService service;

    @GetMapping("/licenses")
    public String showLicenseList(Model model) {
     List<License> listLicenses = service.listAll();
     model.addAttribute("listLicenses",listLicenses);
     return "licenses";
    }
    @GetMapping("/licenses/new")
    public String showNewForm(Model model){
    model.addAttribute("license",new License());
    model.addAttribute("pageTitle","Add new License");
    return "license_form";
    }

    @PostMapping("/licenses/save")
    public String saveLicense(License license) {
        service.save(license);
        return "redirect:/licenses";
    }

    @GetMapping("/licenses/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){

        try {
            License license = service.get(id);
           model.addAttribute("license",license);
           model.addAttribute("pageTitle","Edit License (ID:"+ id+")");
           return "license_form";
        } catch (LicenseNotFoundExceptionn e) {
            return "redirect:/licenses";
        }

    }
    @GetMapping("/licenses/delete/{id}")
    public String deleteLicense(@PathVariable("id") Integer id ){

        try {
            service.delete(id);
        } catch (LicenseNotFoundExceptionn e) {

        }
        return "redirect:/licenses";
    }
}
