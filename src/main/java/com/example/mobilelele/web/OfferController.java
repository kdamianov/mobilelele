package com.example.mobilelele.web;

import com.example.mobilelele.model.dto.CreateOfferDTO;
import com.example.mobilelele.model.enums.Engine;
import com.example.mobilelele.model.enums.Transmission;
import com.example.mobilelele.service.BrandService;
import com.example.mobilelele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {

        this.offerService = offerService;
        this.brandService = brandService;
    }


    @ModelAttribute("engines") //създаваме attribute
    public Engine[] engines(){
        return Engine.values();
    }


    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createOfferDTO", createOfferDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }
        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/" + newOfferUUID;
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") String id) {
        return "details";
    }

    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }

}
