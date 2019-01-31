package ua.kiev.prog.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.dto.ContactDto;
import ua.kiev.prog.service.ContactService;
import ua.kiev.prog.service.converter.ContactConverter;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactRestController {

    private ContactService contactService;
    private ContactConverter contactConverter;

    @GetMapping("/contacts")
    public List<ContactDto> getContacts() {
        return contactConverter.convert(contactService.findAll());
    }

}
