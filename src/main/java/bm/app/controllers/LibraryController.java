package bm.app.controllers;

import bm.app.models.LinkToCheck;
import bm.app.services.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("menu")
    public String getMenu() {
        return "menu";
    }

    @PostMapping("addARecord")
    public String addingARecord() {
        return "addARecord";
    }

    @PostMapping("addedARecord")
    public String addARecordToADatabase(@RequestParam String linkName,
                                        @RequestParam String linkDescription,
                                        Model model) {

        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);

        LinkToCheck newLink = new LinkToCheck();
        newLink.setLink_name(linkName);
        newLink.setDescription(linkDescription);
        newLink.setAdded_on(date);

        model.addAttribute("linkName", linkName);
        model.addAttribute("linkDescription", linkDescription);
        model.addAttribute("addedOn", date);

        libraryService.insertRecord(newLink);

        return "addedARecord";
    }

//    @PostMapping("finalResult")
//    public String finalResult(@RequestParam Optional<String> link) {
//        String theLink;
//        if (link.isPresent()) {
//            theLink = link.get();
//        }
//
//    }
}
