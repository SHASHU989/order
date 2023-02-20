package com.orderservice.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="User")
public class User {
    @Id
    @Generated
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;//ROLE_USER,ROLE_ADMIN
}
