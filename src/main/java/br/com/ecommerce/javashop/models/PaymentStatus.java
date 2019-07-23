package br.com.ecommerce.javashop.models;

public enum  PaymentStatus {

    PENDING(0, "Pending"), CANCELED(1, "canceled"), PAID(2, "Paid");

    private int code;
    private String description;

    private PaymentStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  static  PaymentStatus toEnum(Integer code) {

        if (code == null) return  null;

        for (PaymentStatus ps : PaymentStatus.values()) {
            if (code.equals(ps.getCode()))
                return ps;
        }

        throw new IllegalArgumentException("Invalid code " + code);
    }
}
