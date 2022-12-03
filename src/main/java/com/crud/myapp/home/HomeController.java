package com.crud.myapp.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss", Locale.KOREAN
        );
        String formattedDateString = simpleDateFormat.format(date);

        model.addAttribute("serverTime", formattedDateString);

        return "index";
    }

}
