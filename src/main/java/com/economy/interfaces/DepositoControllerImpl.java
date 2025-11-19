package com.economy.interfaces;

import com.economy.domain.model.Deposito;
import com.economy.domain.service.DepositoService;

import java.util.List;

public class DepositoControllerImpl implements DepositoController{
    private final DepositoService depositoService;
    public DepositoControllerImpl(DepositoService depositoService) {
        this.depositoService = depositoService;
    }

    @Override
    public Deposito fazerDeposito(Deposito deposito) {
        return depositoService.criarDeposito(deposito);
    }

    @Override
    public List<Deposito> listarDepositosPorEmpresa(int empresaId) {
        return depositoService.listarByEmpresaId(empresaId);
    }
}
