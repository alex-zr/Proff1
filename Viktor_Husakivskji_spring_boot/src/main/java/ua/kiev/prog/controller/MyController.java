package ua.kiev.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;
import ua.kiev.prog.service.ContactService;

import java.util.List;

@Controller
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;

    @Autowired
    private ContactService contactService;
/****/
/**  Mistakes checking  **/
    @RequestMapping("/error_wrong_login_or_password")
    public String errorMessage1(){
        return "error_wrong_login_or_password";
    }

    @RequestMapping("/error_passwords_not_similar")
    public String errorMessage2(){
        return "error_passwords_not_similar";
    }

    @RequestMapping("/error_wrong_user_already_exist")
    public String errorMessage3(){
        return "error_wrong_user_already_exist";
    }
/****/


    @RequestMapping({"/", "/index"})
    public String index(){

        return "index";
    }

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/registered")
    public String reg(){
        return "redirect:/contactPage";
    }


    @RequestMapping("/login")
    public String login(){




        return "redirect:/contactPage";
    }
/****/
    @RequestMapping("/contactPage")
    public String contactPage(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Contact> contacts = contactService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("allPages", getPageCount());

        return "contactPage";
    }

    @RequestMapping("/contact_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("groups", contactService.findGroups());
        return "contact_add_page";
    }

/****/
    @RequestMapping(value="/contact_change_page", method = {RequestMethod.GET, RequestMethod.POST})
    public String change(@RequestParam(value = "toDelete[]", required = false) long[] toChange, Model model) {
        if (toChange!=null && toChange.length<2 && toChange.length>0) {
            Contact contact = contactService.findContactById(toChange[0]);
            model.addAttribute("id",contact.getId());
            model.addAttribute("name", contact.getName());
            model.addAttribute("surname", contact.getSurname());
            model.addAttribute("email", contact.getEmail());
            model.addAttribute("phone", contact.getPhone());

        return "contact_change_page";
        }
        return "redirect:/contactPage";
    }

    @RequestMapping("/contact/change")
    public String change(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String phone,
                              @RequestParam String email,
                              @RequestParam long id){
        Contact contact = contactService.findContactById(id);
        contact.setEmail(email);
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        return "redirect:/contactPage";
    }
/****/

    @RequestMapping("/group_add_page")
    public String groupAddPage() {
        return "group_add_page";
    }

    @RequestMapping("/group/{id}")
    public String listGroup(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        Group group = (groupId != DEFAULT_GROUP_ID)
                ? contactService.findGroup(groupId).orElse(new Group())
                : null;
        if (page < 0) page = 0;

        List<Contact> contacts = contactService
                .findByGroup(group, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("byGroupPages", getPageCount(group));
        model.addAttribute("groupId", groupId);

        return "contactPage";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String pattern, Model model) {
        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contactService.findByPattern(pattern, null));

        return "contactPage";
    }

    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0) {
            contactService.deleteContacts(toDelete);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/contact/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam(value = "group") long groupId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email)
    {
        Group group = (groupId != DEFAULT_GROUP_ID)
                ? contactService.findGroup(groupId).orElse(new Group())
                : null;

        Contact contact = new Contact(group, name, surname, phone, email);
        contactService.addContact(contact);

        return "redirect:/contactPage";
    }

    @RequestMapping(value="/group/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        contactService.addGroup(new Group(name));
        return "redirect:/contactPage";
    }

    private long getPageCount() {
        long totalCount = contactService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(Group group) {
        long totalCount = contactService.countByGroup(group);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
