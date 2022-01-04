package by.academy.it.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class AddUserPhotoController {

    @GetMapping("/add-person-photo.html")
    public ModelAndView showAddPersonPhoto() {
        return new ModelAndView("add-person-photo");
    }

    @PostMapping("/add-person-photo.do")
    public ModelAndView addPersonPhoto(@RequestParam("image") MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        System.out.println("IMAGE BYTES: " + bytes.length);

        return new ModelAndView("redirect:/index.html");
    }
}
