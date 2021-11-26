package com.wams.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String userRole;

}
