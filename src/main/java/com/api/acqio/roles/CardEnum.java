package com.api.acqio.roles;

public enum CardEnum {
    DEBITO("DEBITO"),
    CREDITO("CREDITO"),
    VOUCHER("VOUCHER");

    private String descricao;

    CardEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
