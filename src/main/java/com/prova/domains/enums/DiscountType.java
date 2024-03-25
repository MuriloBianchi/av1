package com.prova.domains.enums;

public enum DiscountType {

    AVISTA(0, "ROLE_AVISTA"), PROMO(1, "ROLE_PROMO"), VIP(2, "ROLE_VIP"), FIRSTBUY(3, "ROLE_FIRSTBUY");

    private Integer id;
    private String discountType;
    
    private DiscountType(Integer id, String discountType) {
        this.id = id;
        this.discountType = discountType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public static DiscountType toEnum(Integer id){
        if(id==null) return null;
        for(DiscountType x : DiscountType.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Discount!");
    }
}
