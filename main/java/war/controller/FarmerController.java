package war.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import war.account.AccountRepository;
import war.model.Farmer;
import war.repository.FarmerRepository;

import java.util.ArrayList;
import java.util.List;

@Controller

public class FarmerController {

    @Autowired
    private FarmerRepository farmerRepository;
    private AccountRepository accountRepository;


   @RequestMapping("/farmers")
    public String farmers(Model model) {
       List<Farmer> farmers = farmerRepository.findAll();
       model.addAttribute("buttons","no");
        model.addAttribute("farmers", farmers);
        return "farmers/farmers";
    }

   @GetMapping("/farmersform")
    public String farmersForm(Model model) {
       model.addAttribute("farmers", new Farmer());
        return "farmers/farmersform";
    }


    @PostMapping("/farmersform")
    public String farmersSubmit(@ModelAttribute Farmer farmer) {

     //   System.out.println(farmer.getEndDate());
     //   System.out.println(farmer.getStartDate());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        farmer.setLogin(currentPrincipalName);
        farmerRepository.save(farmer);


       return "redirect:/farmers";
    }
    @RequestMapping(value = "/deleteFarmer", method = RequestMethod.GET)
    public String deleteFarmer(@RequestParam(name="id") Long id){
      // Farmer farmer = farmerRepository.getOne(id)
       farmerRepository.delete(id);
        return "redirect:/findFarmer";
    }

    @RequestMapping(value = "/findFarmer")

    public String findFarmer(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
      //  System.out.println(currentPrincipalName);
         List<Farmer> farmers = farmerRepository.findByLogin(currentPrincipalName);
        model.addAttribute("buttons","yes");
        model.addAttribute("farmers", farmers);
        return "farmers/farmers";
    }


    }


