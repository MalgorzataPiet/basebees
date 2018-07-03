package war.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        farmers.stream().forEach(System.out::println);

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
        farmerRepository.save(farmer);
       return "farmers/farmersformresult";
    }



}
