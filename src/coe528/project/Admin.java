package coe528.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reals
 */
public abstract class Admin {
    
    private String username;
    private String password;
    
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
}
