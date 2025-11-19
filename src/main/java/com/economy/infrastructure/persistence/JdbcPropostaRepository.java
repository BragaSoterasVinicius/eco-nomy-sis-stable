package com.economy.infrastructure.persistence;

import com.economy.domain.model.Proposta;
import com.economy.domain.repository.PropostaRepository;

import java.util.List;

public class JdbcPropostaRepository implements PropostaRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcPropostaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Proposta criarProposta(Proposta proposta) {
        return null;
    }

    @Override
    public Proposta editarProposta(Proposta proposta, int idProposta) {
        return null;
    }

    @Override
    public void deletarProposta(int idProposta) {

    }

    @Override
    public List<Proposta> listarPropostas() {
        return List.of();
    }

    @Override
    public List<Proposta> listarByEmpresaId(int empresaId) {
        return List.of();
    }

    @Override
    public List<Proposta> listarByEmpregadoId(int empregadoId) {
        return List.of();
    }

    @Override
    public Proposta getProposta(int idProposta) {
        return null;
    }
}
