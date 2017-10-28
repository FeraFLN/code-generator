/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T01BRQ0067
 */
public class Conexao {
    private String className;
    private String url;
    private String password;
    private String user;
    private Properties properties;
    private final String nomeArquivo = "conexao.properties";
    
    public Conexao() {
        properties = new Properties();
        
    }
    
    public Connection getConnection() throws ConexaoException{
        try {
            readProperties();
            Class.forName(className);
            return DriverManager.getConnection(url, user,password);
            
        } catch (SQLException ex) {
            throw new ConexaoException("Erro na conex�o com o banco de dados.",ex.getMessage());

        } catch (ClassNotFoundException ex) {
            throw new ConexaoException("ClassName informado n�o foi encontrado na lib de conex�o.",ex.getMessage());
        }
    }
    
    private void readProperties() throws ConexaoException{
        try {
            properties.load(new FileInputStream(new File("properties"+File.separator+nomeArquivo)));
            className = properties.getProperty("className");
            if(className==null || className.isEmpty()){
                throw new ConexaoException("A propriedade \"className\" n�o foi encontrada no arquivo "+nomeArquivo+".");
            }
            url = properties.getProperty("url");
            if(url==null || url.isEmpty()){
                throw new ConexaoException("A propriedade \"url\" n�o foi encontrada no arquivo "+nomeArquivo+".");
            }
            password = properties.getProperty("password");
            if(password==null || password.isEmpty()){
                throw new ConexaoException("A propriedade \"password\" n�o foi encontrada no arquivo "+nomeArquivo+".");
            }
            user = properties.getProperty("user");
            if(user==null || user.isEmpty()){
                throw new ConexaoException("A propriedade \"user\" n�o foi encontrada no arquivo "+nomeArquivo+".");
            }
        } catch (IOException ex) {
            throw new ConexaoException("Erro ao ler o arquivo properties",ex.getMessage());
        }
    }
    
}
