package com.economy.infrastructure.persistence;

import com.economy.domain.model.Deposito;
import com.economy.domain.repository.DepositoRepository;

import java.util.List;

public class JdbcDepositoRepository implements DepositoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcDepositoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Deposito criarDeposito(Deposito deposito) {
        return null;
    }

    @Override
    public Deposito editarDeposito(Deposito deposito, int idDeposito) {
        return null;
    }

    @Override
    public void deletarDeposito(int idDeposito) {

    }

    @Override
    public List<Deposito> listarDepositos() {
        return List.of();
    }

    @Override
    public List<Deposito> listarByEmpresaId(int empresaId) {
        return List.of();
    }
}
