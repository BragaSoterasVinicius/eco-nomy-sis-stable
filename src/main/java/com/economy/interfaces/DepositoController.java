package com.economy.interfaces;

import com.economy.domain.model.Deposito;

import java.util.List;

public interface DepositoController {
    Deposito fazerDeposito(Deposito deposito);
    List<Deposito> listarDepositosPorEmpresa(int empresaId);
}
