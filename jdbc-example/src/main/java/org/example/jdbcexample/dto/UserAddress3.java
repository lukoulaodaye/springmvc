package org.example.jdbcexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jdbcexample.dox.Address;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddress3 {
    private String id;
    private String name;
    private List<Address> addresses;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
