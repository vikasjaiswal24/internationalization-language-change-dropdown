package com.springboot.internationalization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api")
public class LanguageController {

    @RequestMapping(path = "/international", 
    				method = RequestMethod.GET, 
    				produces = "text/html")
    public String international() {
        return "international";
    }
}