package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ecomrepo.Bucketrepo;
import com.example.demo.ecomrepo.Ecomuserrepo;
import com.example.demo.ecomrepo.Itemrepo;
import com.example.demo.users.Buckets;
import com.example.demo.users.Itens;
import com.example.demo.users.Users;

@Service
public class Servcice {
	
	static Integer orderid=1;
	
	static Integer userid;
	
	@Autowired
	public Ecomuserrepo userrepo;
	
	@Autowired
	public Itemrepo itemrepo;
	
	@Autowired
	public Bucketrepo bucketrepo;
	
	public String saveUser(Users user)
	{
		Users newuser=new Users();
		newuser.setId(user.getId());
		newuser.setPassword(user.getPassword());
		newuser.setName(user.getName());
		userrepo.save(newuser);
		return "Saved";
	}

	public String getUser(Users user) {
		
		Iterable<Users> list=userrepo.findAll();
		for(Users exsist:list)
		{
			if(exsist.getId().equals(user.getId()) && exsist.getPassword().equals(user.getPassword()))
			{
				userid=user.getId();
				return "Logined";
			}
		}
		return "Login failed!";
	}

	public String saveItem(Itens items) {
		if(userid==1111)
		{
		Itens newitem=new Itens();
		newitem.setItemid(items.getItemid());
		newitem.setItemname(items.getItemname());
		newitem.setItemprice(items.getItemprice());
		newitem.setBrand(items.getBrand());
		newitem.setKeyword(items.getKeyword());
		
		itemrepo.save(items);
		return "Item added";
		}
		else
		{
			return "User power not sufficent";
		}
	}

	public ArrayList<Itens> searchitem(String keyword) {
		Iterable<Itens> allitems=itemrepo.findAll();
		ArrayList<Itens> filtereditems=new ArrayList<>();
		for(Itens eachitem:allitems)
		{
			if(eachitem.getKeyword().equals(keyword))
			{
				filtereditems.add(eachitem);
			}			
		}
		return filtereditems;
	}

	public String saveBucket(Buckets items) {
		Buckets newitem=new Buckets();
		newitem.setOrderid(orderid);
		newitem.setItemid(items.getItemid());
		newitem.setItemname(items.getItemname());
		newitem.setItemprice(items.getItemprice());
		newitem.setUserid(items.getUserid());
		newitem.setStatus(items.getStatus());
		
		bucketrepo.save(newitem);
		orderid++;
		if(items.getStatus()==0)
		{
			return "Items added to cart";
		}
		if(items.getStatus()==1)
		{
			return "Order placed";
		}
		return "Item added but status is none";
	}

	public String logout() {
		userid=null;
		
		return "Logged out successfully";
	}
	
	

}
