package com.prova.domains.enums;

public enum BookingState {

    PENDING(0, "ROLE_PENDING"), CONFIRMED(1, "ROLE_CONFIRMED"), CANCELED(2, "ROLE_CANCELED");

    private Integer id;
    private String bookinState;
    
    private BookingState(Integer id, String bookinState) {
        this.id = id;
        this.bookinState = bookinState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookinState() {
        return bookinState;
    }

    public void setBookinState(String bookinState) {
        this.bookinState = bookinState;
    }

    public static BookingState toEnum(Integer id){
        if(id==null) return null;
        for(BookingState x : BookingState.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Estado da reserva invalido.");
    }

}
