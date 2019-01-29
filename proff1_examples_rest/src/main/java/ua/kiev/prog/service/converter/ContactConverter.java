package ua.kiev.prog.service.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.dto.ContactDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactConverter implements Converter<List<Contact>, List<ContactDto>> {
    @Override
    public List<ContactDto> convert(List<Contact> contacts) {
        List<ContactDto> result = new ArrayList<>();
        for (Contact contact : contacts) {
            result.add(ContactDto.builder()
                    .id(contact.getId())
                    .name(contact.getName())
                    .surname(contact.getSurname())
                    .email(contact.getEmail())
                    .groupName(contact.getGroup() == null ? "" : contact.getGroup().getName())
                    .phone(contact.getPhone())
                    .build());
        }
        return result;
    }
}
