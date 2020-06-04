package com.springboot.crud.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.crud.model.User;
import com.springboot.crud.service.ProfileDetailService;
import com.springboot.crud.service.RoleDetailService;
import com.springboot.crud.service.UserDetailService;


@Controller

@RequestMapping("/")

public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private RoleDetailService roleDetailService;
	@Autowired
	private ProfileDetailService profileDetailService;
	
	@GetMapping("user/{id}")
	public String getUserDetail(@PathVariable("id") int id, ModelMap userModel) {
		userModel.addAttribute("user", userDetailService.findById(id));
		return "user";
	}
	
	@GetMapping("user/list")
	public String getUsersDetails(ModelMap userModel) {
		userModel.addAttribute("users", userDetailService.findAll());
		userModel.addAttribute("roles", roleDetailService.findAll());
		userModel.addAttribute("profiles", profileDetailService.findAll());
		return "index";
	}
	
	@PostMapping("user/add")
	public String addUser(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "cpf", required = true) String cpf,
			@RequestParam(value = "birthDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date birthDate,
			@RequestParam(value = "idRole", required = true) Long idRole,
			@RequestParam(value = "idProfile", required = true) Long idProfile, ModelMap userModel) {
		
		userModel.addAttribute("roles", roleDetailService.findAll());
		userModel.addAttribute("profiles", profileDetailService.findAll());
		
		User user = new User();
		user.setName(name);
		user.setCpf(cpf);
		user.setBirthDate(birthDate);
		user.setIdRole(idRole);
		user.setIdProfile(idProfile);
		
		int resp = userDetailService.insert(user);
		
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id : " + resp + " added successfully.");
			userModel.addAttribute("users", userDetailService.findAll());
			return "index";
		} else {
			userModel.addAttribute("msg", "User addition failed.");
			return "add";
		}
	}
	
	@GetMapping("signup")
    public String addForm(User user, ModelMap userModel) {
		userModel.addAttribute("roles", roleDetailService.findAll());
		userModel.addAttribute("profiles", profileDetailService.findAll());
        return "add";
    }
		
	@PostMapping("user/delete/{id}")
	public ModelAndView deleteUser(@PathVariable int id, ModelMap userModel) {
		int resp = userDetailService.deleteById(id);
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id : " + id + " deleted successfully.");
		} else {
			userModel.addAttribute("msg", "User with id : " + id + " deletion failed.");
		}
		return new ModelAndView("redirect:" + "/user/list");
	}
	
	@PostMapping("user/edit/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap userModel) {
		userModel.addAttribute("user", userDetailService.findById(id));
		userModel.addAttribute("roles", roleDetailService.findAll());
		userModel.addAttribute("profiles", profileDetailService.findAll());
		return "update";
	}
	
	@PostMapping("user/update")
	public ModelAndView updateUser(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "cpf", required = true) String cpf, @RequestParam(value = "birthDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date birthDate,
			@RequestParam("idRole") Long idRole, @RequestParam("idProfile") Long idProfile, ModelMap userModel) {
		
		User user  = new User();
		user.setName(name);
		user.setCpf(cpf);
		user.setBirthDate(birthDate);
		user.setIdRole(idRole);		
		user.setIdProfile(idProfile);
		user.setId(id);
		Integer resp = userDetailService.update(user);
		userModel.addAttribute("id", id);
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id : " + id + " updated successfully.");
			userModel.addAttribute("users", userDetailService.findAll());
			return new ModelAndView("redirect:" + "/user/list");
		} else {
			userModel.addAttribute("msg", "User with id : " + id + " update failed.");
			userModel.addAttribute("user", userDetailService.findById(id));
			return new ModelAndView("redirect:" + "/user/update");
		}
	}
}