package com.economy.dto.input;

import java.math.BigDecimal;
import java.util.Date;

public class PropostaInputDto {
    private int empresaId;
    private String descricao;
    private BigDecimal valor;
    private Date dataCriacao;
    private boolean isLongoPrazo;

    public PropostaInputDto(int empresaId, String descricao, BigDecimal valor, Date dataCriacao, boolean isLongoPrazo) {
        this.empresaId = empresaId;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.isLongoPrazo = isLongoPrazo;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isLongoPrazo() {
        return isLongoPrazo;
    }

    public void setLongoPrazo(boolean longoPrazo) {
        isLongoPrazo = longoPrazo;
    }
}
