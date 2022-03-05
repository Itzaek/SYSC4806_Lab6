//TODO Was only able to finish part 1 of the lab

package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookRepository;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/addbuddyInfo")
    public String buddyInfo(Model model) {
        model.addAttribute("buddyinfo", new BuddyInfo());
        model.addAttribute("success", "Entry Error!");
        return "addBuddyInfo";
    }

    @PostMapping("/addbuddyInfo")
    public String addbuddyinfosubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook addressBook = addressBookRepository.findById(1);
        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);
        model.addAttribute("buddyinfo", buddyInfo);
        return "addBuddyInfoResult";
    }

    @GetMapping("/createAddressBook")
    public String createAddressBook(Model model) {
        AddressBook addressBook = new AddressBook();
        model.addAttribute("addressbook", addressBook);
        return "createAddressBook";
    }

    @PostMapping("/createAddressBook")
    public String createAddressBookSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        addressBook.setId(counter.incrementAndGet());
        addressBook.setName(addressBook.getName());
        model.addAttribute("addressbook", addressBook);
        addressBookRepository.save(addressBook);
        return "addressBookResult";
    }

    @GetMapping("/addressBookView")
    public String addressBookView(Model model) {
        model.addAttribute("addressbook", addressBookRepository.findAll());
        return "addressBook";
    }

}
