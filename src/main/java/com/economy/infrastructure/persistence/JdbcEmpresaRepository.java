package com.economy.infrastructure.persistence;

import com.economy.domain.model.Empresa;
import com.economy.domain.repository.EmpresaRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmpresaRepository implements EmpresaRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcEmpresaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Empresa criarEmpresa(Empresa empresa) {
        String sql = """
            INSERT INTO t_en_empresa (nome, cnpj, saldo, senha, data_criacao)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[] {"id"})) {

            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setBigDecimal(3, empresa.getSaldo());
            stmt.setString(4, empresa.getSenha());
            stmt.setTimestamp(5, new Timestamp(empresa.getDataCriacao().getTime()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    empresa.setId(rs.getInt(1));
                }
            }

            return empresa;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating empresa", e);
        }
    }

    // -----------------------------------------------------------
    // UPDATE
    // -----------------------------------------------------------
    @Override
    public Empresa editarEmpresa(Empresa empresa, int idEmpresa) {
        String sql = """
            UPDATE t_en_empresa
            SET nome = ?, cnpj = ?, saldo = ?, senha = ?, data_criacao = ?
            WHERE id = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setBigDecimal(3, empresa.getSaldo());
            stmt.setString(4, empresa.getSenha());
            stmt.setTimestamp(5, new Timestamp(empresa.getDataCriacao().getTime()));
            stmt.setInt(6, idEmpresa);

            stmt.executeUpdate();
            empresa.setId(idEmpresa);

            return empresa;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating t_en_empresa " + idEmpresa, e);
        }
    }

    // -----------------------------------------------------------
    // DELETE
    // -----------------------------------------------------------
    @Override
    public void deletarEmpresa(int idEmpresa) {
        String sql = "DELETE FROM t_en_empresa WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpresa);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting t_en_empresa " + idEmpresa, e);
        }
    }

    // -----------------------------------------------------------
    // LIST ALL
    // -----------------------------------------------------------
    @Override
    public List<Empresa> listarEmpresas() {
        String sql = "SELECT * FROM t_en_empresa ORDER BY id DESC";
        List<Empresa> empresas = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                empresas.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing t_en_empresas", e);
        }

        return empresas;
    }

    // -----------------------------------------------------------
    // LIST BY ID
    // -----------------------------------------------------------
    @Override
    public List<Empresa> listarById(int id) {
        String sql = "SELECT * FROM t_en_empresa WHERE id = ?";
        List<Empresa> empresas = new ArrayList<>();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    empresas.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing t_en_empresa " + id, e);
        }

        return empresas;
    }

    // -----------------------------------------------------------
    // LOGIN
    // -----------------------------------------------------------
    @Override
    public Empresa login(String cnpj, String senha) {
        String sql = """
            SELECT * FROM t_en_empresa
            WHERE cnpj = ? AND senha = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cnpj);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error logging t_en_empresa", e);
        }
    }

    // -----------------------------------------------------------
    // INTERNAL MAPPER
    // -----------------------------------------------------------
    private Empresa mapRow(ResultSet rs) throws SQLException {
        Empresa e = new Empresa();

        e.setId(rs.getInt("id"));
        e.setNome(rs.getString("nome"));
        e.setCnpj(rs.getString("cnpj"));

        BigDecimal saldo = rs.getBigDecimal("saldo");
        e.setSaldo(saldo != null ? saldo : BigDecimal.ZERO);

        e.setSenha(rs.getString("senha"));

        Timestamp ts = rs.getTimestamp("data_criacao");
        e.setDataCriacao(ts != null ? new Date(ts.getTime()) : null);

        return e;
    }
}
