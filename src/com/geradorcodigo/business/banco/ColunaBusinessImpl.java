/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.business.banco;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.dao.banco.ColunaDao;
import com.geradorcodigo.dao.banco.ColunaDaoImpl;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Tabela;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public class ColunaBusinessImpl implements ColunaBusiness{
    private ColunaDao colunaDao;

    public ColunaBusinessImpl() {
        colunaDao = new ColunaDaoImpl();
    }
    
    
    @Override
    public List<Coluna> select(Tabela tabela) throws GeradorException{
        if(tabela==null){
            throw new ColunaBusinessException("Tabela Nula.");
        }
        if(tabela.getNome()==null || tabela.getNome().isEmpty()){
            throw new ColunaBusinessException("O nome da tabela tem preencimento obrigatório.");
        }
        if(tabela.getOwner()==null || tabela.getOwner().isEmpty()){
            throw new ColunaBusinessException("O owner da tabela tem preencimento obrigatório.");
        }
        return colunaDao.select(tabela);
    }
}
