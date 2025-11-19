package com.economy.infrastructure.persistence;

import com.economy.domain.model.Empresa;
import com.economy.domain.repository.EmpresaRepository;

import java.util.List;

public class JdbcEmpresaRepository implements EmpresaRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcEmpresaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Empresa criarEmpresa(Empresa empresa) {
        return null;
    }

    @Override
    public Empresa editarEmpresa(Empresa empresa, int idEmpresa) {
        return null;
    }

    @Override
    public void deletarEmpresa(int idEmpresa) {

    }

    @Override
    public List<Empresa> listarEmpresas() {
        return List.of();
    }

    @Override
    public List<Empresa> listarById(int id) {
        return List.of();
    }

    @Override
    public Empresa login(String email, String senha) {
        return null;
    }
}
