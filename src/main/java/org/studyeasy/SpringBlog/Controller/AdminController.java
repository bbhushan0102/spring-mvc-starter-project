package org.studyeasy.SpringBlog.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.studyeasy.SpringBlog.models.Post;

import ch.qos.logback.core.model.Model;

@Controller
public class AdminController {

     @GetMapping("/admin")
    public String admin (Model model) {

        return "admin";
    }
    
    
}
