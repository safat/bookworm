package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 10:56 AM
 */

@Controller
public class ProfileController {
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String getProfilePage(@PathVariable int userId, ModelMap modelMap) {
        return "user/profile";
    }
}