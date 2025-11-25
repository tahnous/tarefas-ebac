package br.com.tahnous.service;

import br.com.tahnous.dao.IContratoDao;

public class ContratoService implements  IContratoService{

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return null;
    }

    public  String atualizar() {
        contratoDao.atualizar();
        return null;
    }

    public String buscar() {
        contratoDao.buscar();
        return null;
    }

    public String excluir() {
        contratoDao.excluir();
        return null;
    }
}
