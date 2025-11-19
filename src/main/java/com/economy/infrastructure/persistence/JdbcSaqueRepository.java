package com.economy.infrastructure.persistence;

import com.economy.domain.model.Saque;
import com.economy.domain.repository.SaqueRepository;

import java.util.List;

public class JdbcSaqueRepository implements SaqueRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcSaqueRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Saque criarSaque(Saque saque) {
        return null;
    }

    @Override
    public List<Saque> listarByEmpregadoId(int empregadoId) {
        return List.of();
    }
}
