package com.example.mobilelele.web;

import com.example.mobilelele.model.dto.CreateOfferDTO;
import com.example.mobilelele.model.enums.Engine;
import com.example.mobilelele.model.enums.Transmission;
import com.example.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String all() {
        return "offers";
    }

    @ModelAttribute("engines") //създаваме attribute
    public Engine[] engines(){
        return Engine.values();
    }


    @GetMapping("/add")
    public String add() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") String id) {
        return "details";
    }

}
