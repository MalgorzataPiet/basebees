package war.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("buttons","no");
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        beekeeper.setLogin(currentPrincipalName);
        beekeeperRepository.save(beekeeper);

        return "redirect:/beekeepers";
    }

    @RequestMapping(value = "/deleteBeekeeper", method = RequestMethod.GET)
    public String deleteBeekeeper(@RequestParam(name="id") Long id){
         Beekeeper beekeeper = beekeeperRepository.getOne(id);
        beekeeperRepository.delete(id);
        return "redirect:/beekeepers";
    }

    @RequestMapping(value = "/findBeekeeper")

    public String findBeekeeper(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        //  System.out.println(currentPrincipalName);
        List<Beekeeper> beekeepers = beekeeperRepository.findByLogin(currentPrincipalName);
        model.addAttribute("buttons","yes");
        model.addAttribute("beekeepers", beekeepers);
        return "beekeepers/beekeepers";
    }
}
