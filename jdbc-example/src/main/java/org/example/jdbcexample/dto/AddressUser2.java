package org.example.jdbcexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jdbcexample.dox.Address;
import org.example.jdbcexample.dox.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressUser2 {
    private User user;
    private Address address;
}
