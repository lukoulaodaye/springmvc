package org.example.jdbcexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jdbcexample.dox.Address;
import org.example.jdbcexample.dox.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddress {
    private User user;
    private List<Address> addresses;
}
