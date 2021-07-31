package com.loginsystem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
public class LoginController {
	@Autowired
	LoginMapper loginmapper;
	@RequestMapping(value="/")
	public String login() {

		return "login";
	}
	@RequestMapping(value="/login")
	public String login(Model model) {
        List<Login> list = loginmapper.selectAll();
        model.addAttribute("name",list);//コントローラからビューに値を渡す
        if(list.size()>0)
        	return "date";
        else
        	model.addAttribute("name",list);//コントローラからビューに値を渡す
        	return "login";
    }

}
