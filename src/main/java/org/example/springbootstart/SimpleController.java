package org.example.springbootstart;

import org.example.springbootstart.model.User;
import org.example.springbootstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        User u = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", u);
        return modelAndView;
    }
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.edit(user);
        return modelAndView;
    }
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        User u = new User();
        userService.add(u);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", u);
        return modelAndView;
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.add(user);
        return modelAndView;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        User u = userService.getById(id);
        userService.delete(u);
        return modelAndView;
    }
}
