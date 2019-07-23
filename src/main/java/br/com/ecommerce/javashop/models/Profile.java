package br.com.ecommerce.javashop.models;

public enum Profile {

    ADMIN(0, "ADMIN"), CLIENT(1, "CLIENT");

    private int code;
    private String descricao;

    private Profile(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Profile toEnum(Integer code) {

        if (code == null)
            return null;

        for (Profile p : Profile.values()) {
            if (code.equals(p.getCode()))
                return p;
        }

        throw new IllegalArgumentException("Id inválido: " + code);

    }
}
