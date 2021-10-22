package com.spring.connect.controller;

import com.spring.connect.Repository.AddressDAO;
import com.spring.connect.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
@WebServlet
public class AddressController {
    @Autowired
    private AddressDAO addressDAO;

    @Bean
    public Supplier<List<Address>> addresses(){
        return ()->addressDAO.getAddressList();
    }

    @Bean
    public Function<String,List<Address>> findAddressByLocation(){
        return (input)->addressDAO.getAddressList().stream().filter(address->address.getLocationName().equalsIgnoreCase(input)).collect(Collectors.toList());
    }


}
