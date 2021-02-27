package com.mvc.bean;

public class LoginBean 
{
    private String fc,password,status;
    
    public String getFC(){
        return fc;
    }
    public void setFC(String fc){
        this.fc=fc;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
}