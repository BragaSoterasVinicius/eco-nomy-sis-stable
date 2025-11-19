package com.economy.infrastructure.config;

import com.economy.domain.repository.*;
import com.economy.infrastructure.persistence.*;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseConfig {

    @ApplicationScoped
    public DatabaseConnection databaseConnection(AgroalDataSource dataSource) {
        return new DatabaseConnectionImpl(dataSource);
    }

    public DepositoRepository depositoRepository(DatabaseConnection databaseConnection) {
        return new JdbcDepositoRepository(databaseConnection);
    }

    public EmpregadoRepository empregadoRepository(DatabaseConnection databaseConnection) {
        return new JdbcEmpregadoRepository(databaseConnection);
    }

    public EmpresaRepository empresaRepository(DatabaseConnection databaseConnection) {
        return new JdbcEmpresaRepository(databaseConnection);
    }

    public PagamentoRepository pagamentoRepository(DatabaseConnection databaseConnection) {
        return new JdbcPagamentoRepository(databaseConnection);
    }

    public PropostaRepository propostaRepository(DatabaseConnection databaseConnection) {
        return new JdbcPropostaRepository(databaseConnection);
    }

    public SaqueRepository saqueRepository(DatabaseConnection databaseConnection) {
        return new JdbcSaqueRepository(databaseConnection);
    }

}
