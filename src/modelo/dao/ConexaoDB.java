package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    //cria a varivel que vai armazenar a conexao
    //
    private static Connection conn;
    
    //retorna a conexao aberta, uso dela estatico é pra não ter que instanciar
    //uma nova conexão a cada iteração é uma abordagem ????
    public static Connection getConexao() throws SQLException{
        //caso a conexão não seja nula e não esteja fechada apenas retorno a conexao
        if(conn != null && !conn.isClosed()){
            System.out.println("retornando conexao");
            return conn;
        }
        
        //Registrar o driver do banco no sistema
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //Criando nova conexao
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_clinica", "root", "");
        System.out.println("nova conexão criada com sucesso!");
        return conn;
    }
}
