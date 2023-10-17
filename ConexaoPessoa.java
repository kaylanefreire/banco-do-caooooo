package conection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConexaoPessoa extends ConexaoBD{
    
    public void inserir(Pessoa p){
        String sql = "insert into pessoa values (?,?,?)";
        conectar();
        try {
            estado = con.prepareStatement(sql);
            estado.setString(1, p.getCpf());
            estado.setString(2, p.getNome());
            estado.setInt(3, p.getIdade());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir!");
        }
    }
    public void atualizar(Pessoa p) {
       
        String sql = "update pessoa set nome = ?, idade = ? where cpf = ?";
        conectar();
        try {
            estado = con.prepareStatement(sql);
            estado.setString(3, p.getCpf());
            estado.setString(1, p.getNome());
            estado.setInt(2, p.getIdade());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        }
    }
    public void remover(Pessoa p) {
        String sql = "delete from pessoa where cpf = ?";
        conectar();
        try {
            estado = con.prepareStatement(sql);
            estado.setString(1, p.getCpf());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
        }
    }
    public ArrayList<Pessoa> consultar(){
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        String sql = "select * from pessoa";
        ResultSet resultado;
        conectar();
        try {
            estado = con.prepareStatement(sql);
            resultado = estado.executeQuery();
            
            while(resultado.next()){
                Pessoa p = new Pessoa();
                p.setCpf(resultado.getString("cpf"));
                p.setNome(resultado.getString("nome"));
                p.setIdade(resultado.getInt("idade"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir");
        }
        return lista;
    }
}
