package org.example.jdbcexample.repository;


import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexample.dox.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
    void findByUserId(){
        for(Address address : addressRepository.findByUserId("1283955099553812480")){
            log.debug("address: {}",address);
        }
    }

}