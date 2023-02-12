package com.example.demo.Control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.Servcice;
import com.example.demo.users.Buckets;
import com.example.demo.users.Itens;
import com.example.demo.users.Users;

import jakarta.servlet.http.HttpSession;

@RestController
public class Controller {
	@Autowired
	public Servcice server;
	
	@GetMapping("/home")
	public String home()
	{
		return "home page";
	}
	@GetMapping("/saveform")
	public String saveform()
	{
		return "saveform";
	}
	
	@PostMapping("/saveuser")
	public String sveUser(@RequestBody Users user)
	{
		server.saveUser(user);
		return "User saved";
	}
	
	@PostMapping("/getuser")
	public String getuser(@RequestBody Users user)
	{
		return server.getUser(user);
	}
	
	@PostMapping("/saveitem")
	public String saveitem(@RequestBody Itens items)
	{
		return (server.saveItem(items));
	}
	
	@GetMapping("/search/{keyword}")
	public ArrayList<Itens> searchitem(@PathVariable String keyword)
	{
		return server.searchitem(keyword);
	}
	
	@PostMapping("/whishlist")
	public String saveitem(@RequestBody Buckets items)
	{
		return (server.saveBucket(items));
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return server.logout();
	}

}
