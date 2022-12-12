package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.BikkadIT.entity.User;
import com.BikkadIT.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/welcome")
	public String loadForm() {
		return "registration";
		
	}
	
	
	//for login
	@GetMapping("/login")
	public String preLogin() {
		return "login";
		
	}
	
	@PostMapping("/reg")
	public String userRegistration (User user, Model model) {
		System.out.println("Controller layer method");
		System.out.println(user);
		
		int id = userService.saveUser(user);
		
		model.addAttribute("ID", id);
		
		return "userSuccess";

}
	@GetMapping("/Log")
	public String loginCheck( User user) {
		System.out.println(user);
		boolean loginCheckServiceLayer=userService.loginCheckServiceLayer(user);
		
		if(loginCheckServiceLayer) {
			return "loginSuccess";
		}
		
		
		return "LoginFail";
		
	}
	@GetMapping("/getAllData")
	public String getAllData(Model model) {
List<User> all = userService.getAll();
		
		model.addAttribute("list", all);
		return "getAllData";
		
	}
	@GetMapping("/getSingleUser/{uid}")
	public String getSingleUser(@PathVariable int uid,Model model) {
		System.out.println(uid);
		User singleUser = userService.getSingleUser(uid);
		System.out.println(singleUser);
		model.addAttribute("USER", singleUser);
		return "getSingleUser";
		
	}
	
	@GetMapping("/update")
	public String preUpdate() {
		
		return "update";
		
	}
	
	@PostMapping("/updateUser")
	public String updateUser(User user,Model model) {
		System.out.println(user);
		List<User> updateUser=userService.updateUser(user);	
		System.out.println(updateUser);
		model.addAttribute("list", updateUser);
		return "updateList";
		
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public String deleteUser(@PathVariable Integer id,Model model) {
		
		List<User> list=userService.deleteUser(id);
		
		model.addAttribute("list", list);
		return "updateList";
		
	}
	
		
	}
	
