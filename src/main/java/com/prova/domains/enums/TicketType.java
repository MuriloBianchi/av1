package com.prova.domains.enums;

public enum TicketType {

    ECONOMIC(0, "ROLE_ECONOMIC"), ECONOMIC_PREMIUM(1, "ROLE_ECONOMIC_PREMIUM"), EXECUTIVE(2, "ROLE_EXECUTIVE"), FIRST_CLASS(3, "ROLE_FIRST_CLASS");

    private Integer id;
    private String ticketType;

    private TicketType(Integer id, String ticketType) {
        this.id = id;
        this.ticketType = ticketType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public static TicketType toEnum(Integer id){
        if(id == null) return null;
        for(TicketType x : TicketType.values()){
                if(id.equals(x.getId())){
                    return x;
                }
            }
            throw new IllegalArgumentException("Invalid Ticket Type!");
        }
}

