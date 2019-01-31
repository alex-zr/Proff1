package ua.kiev.prog.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class ContactDto {
    long id;
    String groupName;
    String name;
    String surname;
    String phone;
    String email;
}
