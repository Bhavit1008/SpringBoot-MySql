package com.spring.connect;

import com.spring.connect.Repository.AddressDAO;
import com.spring.connect.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories
@RestController
@ComponentScan(basePackageClasses = LearnDbApplication.class)
class LearnDbApplication {

    @Autowired
    private AddressDAO addressDAO;

    @Bean
    public Supplier<List<Address>> addresses(){
        return ()->addressDAO.getAddressList();
    }

    @Bean
    public Supplier<String> hello(){
        return ()-> "hello !!!!!!";
    }


    @Bean
    public Function<String,List<Address>> findAddressByLocation(){
        return (input)->addressDAO.getAddressList().stream().filter(address->address.getLocationName().equalsIgnoreCase(input)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnDbApplication.class, args);
    }

    @GetMapping("/fun")
    public String fun(){
        return "fun";
    }
}