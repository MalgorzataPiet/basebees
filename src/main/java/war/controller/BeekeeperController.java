package war.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import war.model.Beekeeper;
import war.model.Farmer;
import war.repository.BeekeeperRepository;
import war.repository.FarmerRepository;

import java.util.List;

@Controller
public class BeekeeperController {

    @Autowired
    private BeekeeperRepository beekeeperRepository;

    @RequestMapping("/beekeepers")
    public String beekeepers(Model model) {

        List<Beekeeper> beekeepers = beekeeperRepository.findAll();
        beekeepers.stream().forEach(System.out::println);

        model.addAttribute("beekeepers", beekeepers);



        return "beekeepers/beekeepers";
    }

    @GetMapping("/beekeepersform")
    public String farmersForm(Model model) {
        model.addAttribute("beekeepers", new Beekeeper());
        return "beekeepers/beekeepersform";
    }


    @PostMapping("/beekeepersform")
    public String farmersSubmit(@ModelAttribute Beekeeper beekeeper) {
        beekeeperRepository.save(beekeeper);

        return "redirect:/beekeepers";
    }
}
