package com.prova.domains.enums;

public enum UserType {

    CLIENT(0, "ROLE_CLIENT"), ADMIN(1, "ROLE_ADMIN");

    private Integer id;
    private String userType;
    
    private UserType(Integer id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static UserType toEmun(Integer id){
        if(id==null) return null;
        for(UserType x : UserType.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Usario Invalido.");
    }

}
