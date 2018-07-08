package war.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import war.model.Farmer;
import war.repository.FarmerRepository;

import java.util.ArrayList;
import java.util.List;

@Controller

public class FarmerController {

    @Autowired
    private FarmerRepository farmerRepository;


   @RequestMapping("/farmers")
    public String farmers(Model model) {
       List<Farmer> farmers = farmerRepository.findAll();
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

        farmerRepository.save(farmer);

       return "redirect:/farmers";
    }
    @RequestMapping(value = "/deleteFarmer", method = RequestMethod.GET)
    public String deleteFarmer(@RequestParam(name="id") Long id){
      // Farmer farmer = farmerRepository.getOne(id)

       farmerRepository.delete(id);
        return "redirect:/farmers";
    }

    }


