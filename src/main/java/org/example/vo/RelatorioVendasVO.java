package org.example.vo;

import java.time.LocalDate;

public class RelatorioVendasVO {
    private String nomeProduto;
    private long quantidadeProduto;
    private LocalDate dataUltimaVenda;

    public RelatorioVendasVO(String nomeProduto, long quantidadeProduto, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioVendasVO{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeProduto=" + quantidadeProduto +
                ", dataUltimaVenda=" + dataUltimaVenda +
                '}';
    }
}
