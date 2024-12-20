package com.tj_JavaEE.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer adminId;
    private String account;
    private String password;
    private String permissionLevel;
}
