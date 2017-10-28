/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geradorcodigo.jdbctype;

import com.geradorcodigo.exception.GeradorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author T01BRQ0067
 */
public class JdbcType {

    protected static Properties properties;
    protected static final String nomeArquivo = "jdbcType.properties";


    private static void readProperties() throws GeradorException {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File("properties" + File.separator + nomeArquivo)));
        } catch (IOException ex) {
            throw new GeradorException("Erro ao tentar lêr o arquivo " + nomeArquivo + ".", ex.getMessage());
        }
    }

    public static String getMapJdbcType(String key) throws GeradorException {
        readProperties();
        return properties.getProperty(key)==null?key:properties.getProperty(key);
    }
}
