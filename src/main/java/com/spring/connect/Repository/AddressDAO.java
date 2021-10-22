package com.spring.connect.Repository;

import com.spring.connect.model.Address;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AddressDAO {
    public List<Address> getAddressList(){
        return Arrays.asList(
                new Address(1,"KVilla","TMG","RJ","313001"),
                new Address(1,"KVilla","TMG","RJ","313001"),
                new Address(1,"KVilla","TMG","RJ","313001")
        );
    }
}
