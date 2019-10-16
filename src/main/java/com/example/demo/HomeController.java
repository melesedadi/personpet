package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String homepage(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        return "index";
    }
    @RequestMapping("/personlist")
    public String departmentList(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "personlist";

    }

    @GetMapping("/addperson")
    public String personForm(Model model) {
        model.addAttribute("person", new People());
        return "personform";
    }

    @PostMapping("/processperson")
    public String processForm1(@Valid People people,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "personform";
        }
        personRepository.save(people);
        return "redirect:/personlist";
    }
    @RequestMapping("/petlist")
    public String employeeList(Model model){
        model.addAttribute("pets", petRepository.findAll());
        return "petlist";
    }

    @GetMapping("/addpet")
    public String employeeForm(Model model){
        model.addAttribute("pet", new Pet());
        model.addAttribute("persons", personRepository.findAll());
        return "petform";
    }
    @PostMapping("/processpet")
    public String processForm2(@Valid Pet pet,
                               BindingResult result){
        if (result.hasErrors()){
            return "petform";
        }
        petRepository.save(pet);
        return "redirect:/petlist";
    }
    @RequestMapping("/detailperson/{id}")
    public String showPerson(@PathVariable("id") long id, Model model)
    {model.addAttribute("person", personRepository.findAll());
        return "showperson";
    }
    @RequestMapping("/updateperson/{id}")
    public String updatePerson(@PathVariable("person_id") long id,Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        return "personform";
    }
    @RequestMapping("/deleteperson/{id}")
    public String delPerson(@PathVariable("id") long id){
        personRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailpet/{id}")
    public String showPet(@PathVariable("id") long id, Model model)
    {model.addAttribute("pet", petRepository.findById(id).get());
        return "showpet";
    }
    @RequestMapping("/updatepet/{id}")
    public String updatePet(@PathVariable("id") long id,Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        model.addAttribute("pets", petRepository.findAll());
        return "petform";
    }
    @RequestMapping("/deletepet/{id}")
    public String delPet(@PathVariable("id") long id){
        petRepository.deleteById(id);
        return "redirect:/";
    }
}
