package com.example.demo.ecomrepo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.users.Itens;

public interface Itemrepo extends CrudRepository<Itens, Integer>{

}
