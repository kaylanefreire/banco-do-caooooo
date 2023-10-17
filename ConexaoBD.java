package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    String driver = "com.mysql.jdbc.Driver";
    String banco = "padb";
    String host = "localhost";
    String str_con = "jdbc:mysql://" +host+ ":3306/" +banco;
    String usuario = "root";
    String senha = "";
    
    Connection con;
    PreparedStatement estado;
    
    public void conectar(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(str_con, usuario, senha);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao encontrar o driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao conectar");
        }
    }
    public void fecharConexao(){
        try {
            estado.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao encerrar a conexão");
        }
        
    }
    
}
