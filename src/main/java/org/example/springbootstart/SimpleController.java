package org.example.springbootstart;

import jakarta.validation.Valid;
import org.example.springbootstart.model.User;
import org.example.springbootstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

    @Autowired
    private UserService userService;

    public SimpleController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping("/users")
    public String homePage(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }
    @GetMapping(value="/edit/")
    public ModelAndView editPage(@RequestParam String id) {
        User u = userService.getById(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", u);
        return modelAndView;
    }
    @PostMapping(value="/edit")
    public ModelAndView editUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
            modelAndView.setViewName("editPage");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/users");
        userService.edit(user);
        return modelAndView;
    }
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        User u = new User();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", u);
        return modelAndView;
    }
    @PostMapping(value="/add")
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
            modelAndView.setViewName("editPage");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        userService.add(user);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }
    @GetMapping(value="/delete/")
    public ModelAndView deleteUser(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        User u = userService.getById(Integer.parseInt(id));
        userService.delete(u);
        return modelAndView;
    }
}
