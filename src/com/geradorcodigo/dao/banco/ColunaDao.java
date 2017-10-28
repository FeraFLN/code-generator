/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.dao.banco;

import com.geradorcodigo.exception.GeradorException;
import com.geradorcodigo.domain.banco.Coluna;
import com.geradorcodigo.domain.banco.Tabela;
import java.util.List;

/**
 *
 * @author T01BRQ0067
 */
public interface ColunaDao {
    
    public List<Coluna> select(Tabela tabela) throws GeradorException;
    
}
