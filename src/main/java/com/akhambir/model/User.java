package com.akhambir.model;


import com.akhambir.dao.Column;
import com.akhambir.dao.Id;
import com.akhambir.dao.Table;

@Table("USERS")
public class User {

    @Id
    private Long id;
    @Column("NAME")
    private String name;
    @Column("EMAIL")
    private String email;
    @Column("PASSWORD")
    private String password;

    private String token;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
