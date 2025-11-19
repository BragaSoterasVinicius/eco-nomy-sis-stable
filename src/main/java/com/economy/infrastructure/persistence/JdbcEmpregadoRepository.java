package com.economy.infrastructure.persistence;

import com.economy.domain.model.Empregado;
import com.economy.domain.repository.EmpregadoRepository;

import java.util.List;

public class JdbcEmpregadoRepository implements EmpregadoRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcEmpregadoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Empregado criarEmpregado(Empregado empregado) {
        return null;
    }

    @Override
    public Empregado editarEmpregado(Empregado empregado, int idEmpregado) {
        return null;
    }

    @Override
    public void deletarEmpregado(int idEmpregado) {

    }

    @Override
    public List<Empregado> listarEmpregados() {
        return List.of();
    }

    @Override
    public List<Empregado> listarByIdUsuario(int idUsuario) {
        return List.of();
    }

    @Override
    public Empregado loginEmpregado(String email, String senha) {
        return null;
    }
}
