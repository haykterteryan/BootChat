package am.springboot.chat.Controllers;

import am.springboot.chat.Entity.UserEntity;
import am.springboot.chat.Servise.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class HomeController {

    UserService userService;

    @GetMapping(value="/", params = "search")
    public String search(@RequestParam(name = "search") String name){

        userService.loadUserByname(name);

        return null;
    }
}
