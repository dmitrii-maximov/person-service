package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping()
    ContactDto getContact(@AuthenticationPrincipal ContactEntity contact) {
            return service.findContact(contact.getId());
    }

    @GetMapping("/card")
    MedicalCardDto getCard(@AuthenticationPrincipal ContactEntity contact) {
        return service.findMedicalCard(contact.getId());
    }

    @GetMapping("/address")
    AddressDto getAddress(@AuthenticationPrincipal ContactEntity contact) {
        return service.findAddress(contact.getId());
    }

    @GetMapping("/data")
    PersonDataDto getPersonData(@AuthenticationPrincipal ContactEntity contact) {
        return service.findPersonData(contact.getId());
    }

    @GetMapping("/illness")
    IllnessDto getIllness(@AuthenticationPrincipal ContactEntity contact) {
        return service.findIllness(contact.getId());
    }
}