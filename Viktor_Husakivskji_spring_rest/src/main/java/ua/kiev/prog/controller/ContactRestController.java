package ua.kiev.prog.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.dto.ContactDto;
import ua.kiev.prog.domain.dto.GroupDto;
import ua.kiev.prog.service.ContactService;
import ua.kiev.prog.service.converter.ContactConverter;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class ContactRestController {

    private ContactService contactService;
    private ContactConverter contactConverter;
    private RestTemplate restTemplate;

    @GetMapping("/contacts")
    public List<ContactDto> getContacts() {
        return contactConverter.convert(contactService.findAll());
    }

    // https://www.tutorialspoint.com/spring_boot/spring_boot_rest_template.htm
    @GetMapping("/groups")
    public String getGroups() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/groups",
                HttpMethod.GET, entity, String.class).getBody();
    }

}
