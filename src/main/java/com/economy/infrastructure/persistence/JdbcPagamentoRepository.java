package com.economy.infrastructure.persistence;

import com.economy.domain.model.Pagamento;
import com.economy.domain.repository.PagamentoRepository;

import java.util.List;

public class JdbcPagamentoRepository implements PagamentoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcPagamentoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        return null;
    }

    @Override
    public Pagamento editarPagamento(Pagamento pagamento, int idPagamento) {
        return null;
    }

    @Override
    public Pagamento getById(int pagamentoId) {
        return null;
    }

    @Override
    public List<Pagamento> listarPagamentosPorEmpregadoId(int id) {
        return List.of();
    }

    @Override
    public List<Pagamento> listarPagamentosPorEmpresaId(int empresaId) {
        return List.of();
    }
}
