package br.com.ecommerce.javashop.models;

public enum ClientType {

    PHYSICAL_PERSON(0, "Physical Person"), LEGAL_PERSON(1, "Legal Person");

    private int code;
    private String description;

    private ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  static  ClientType toEnum(Integer code) {

        if (code == null) return  null;

        for (ClientType ct : ClientType.values()) {
            if (code.equals(ct.getCode()))
                return ct;
        }

        throw new IllegalArgumentException("Invalid code " + code);
    }

}
