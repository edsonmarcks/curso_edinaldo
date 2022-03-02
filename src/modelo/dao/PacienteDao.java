package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

/**
 *
 * @author edsonmarcks
 */
public class PacienteDao implements Operacao<Paciente> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean salvar(Paciente t) {
        try {
            sql = "INSERT INTO paciente ("
                    + "pac_nome,"
                    + "pac_sexo,"
                    + "pac_nasc,"
                    + "pac_cpf,"
                    + "pac_telefone,"
                    + "pac_email,"
                    + "pac_rua,"
                    + "pac_bairro,"
                    + "pac_cidade,"
                    + "pac_estado)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = ConexaoDB.getConexao().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNome());
            ps.setString(2, t.getSexo());
            ps.setDate(3, Date.valueOf(t.getNascimento()));
            ps.setString(4, t.getCPF());
            ps.setString(5, t.getTelefone());
            ps.setString(6, t.getEmail());
            ps.setString(7, t.getRua());
            ps.setString(8, t.getBairro());
            ps.setString(9, t.getCidade());
            ps.setString(10, t.getEstado());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                t.setId(rs.getInt(1));
            }
            rs.close();
            ps.closeOnCompletion();
            System.out.println("Novo paciente cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("O registro não foi inserido, motivo: \n" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Paciente t) {
        try {
            sql = "UPDATE paciente SET "
                    + "pac_nome=?,"
                    + "pac_sexo=?,"
                    + "pac_nasc=?,"
                    + "pac_cpf=?,"
                    + "pac_telefone=?,"
                    + "pac_email=?,"
                    + "pac_rua=?,"
                    + "pac_bairro=?,"
                    + "pac_cidade=?,"
                    + "pac_estado=?"
                    + " WHERE pac_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, t.getNome());
            ps.setString(2, t.getSexo());
            ps.setDate(3, Date.valueOf(t.getNascimento()));
            ps.setString(4, t.getCPF());
            ps.setString(5, t.getTelefone());
            ps.setString(6, t.getEmail());
            ps.setString(7, t.getRua());
            ps.setString(8, t.getBairro());
            ps.setString(9, t.getCidade());
            ps.setString(10, t.getEstado());
            ps.setInt(11, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Paciente atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("O registro não foi atualizado, motivo: \n" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Paciente t) {
        try {
            sql = "DELETE FROM paciente  WHERE pac_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Paciente removido com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("O registro não foi removido, motivo: \n" + ex.getMessage());
        }
        return false;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Paciente paciente = null;
        try {
            sql = "select * from paciente where pac_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("pac_id"));
                paciente.setNome(rs.getString("pac_nome"));
                paciente.setSexo(rs.getString("pac_sexo"));
                paciente.setNascimento(rs.getDate("pac_nasc").toLocalDate());
                paciente.setCPF(rs.getString("pac_cpf"));
                paciente.setTelefone(rs.getString("pac_telefone"));
                paciente.setRua(rs.getString("pac_rua"));
                paciente.setCidade(rs.getString("pac_cidade"));
                paciente.setEstado(rs.getString("pac_estado"));
                paciente.setBairro(rs.getString("pac_bairro"));
                paciente.setEmail(rs.getString("pac_email"));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException | RuntimeException e) {
            System.err.println("Falha ao localizar o paciente por [id] \n" + e.getMessage());
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            sql = "select * from paciente";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            Paciente paciente = null;
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("pac_id"));
                paciente.setNome(rs.getString("pac_nome"));
                paciente.setSexo(rs.getString("pac_sexo"));
                paciente.setNascimento(rs.getDate("pac_nasc").toLocalDate());
                paciente.setCPF(rs.getString("pac_cpf"));
                paciente.setTelefone(rs.getString("pac_telefone"));
                paciente.setRua(rs.getString("pac_rua"));
                paciente.setCidade(rs.getString("pac_cidade"));
                paciente.setEstado(rs.getString("pac_estado"));
                paciente.setBairro(rs.getString("pac_bairro"));
                paciente.setEmail(rs.getString("pac_email"));
                pacientes.add(paciente);
                paciente = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException | RuntimeException e) {
            System.err.println("Falha ao localizar o paciente por [id] \n" + e.getMessage());
        }
        return pacientes;
    }

    public List<Paciente> buscarTodos(String nome) {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            sql = "select * from paciente where pac_nome like ?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();
            Paciente paciente = null;
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt("pac_id"));
                paciente.setNome(rs.getString("pac_nome"));
                paciente.setSexo(rs.getString("pac_sexo"));
                paciente.setNascimento(rs.getDate("pac_nasc").toLocalDate());
                paciente.setCPF(rs.getString("pac_cpf"));
                paciente.setTelefone(rs.getString("pac_telefone"));
                paciente.setRua(rs.getString("pac_rua"));
                paciente.setCidade(rs.getString("pac_cidade"));
                paciente.setEstado(rs.getString("pac_estado"));
                paciente.setBairro(rs.getString("pac_bairro"));
                paciente.setEmail(rs.getString("pac_email"));
                pacientes.add(paciente);
                paciente = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException | RuntimeException e) {
            System.err.println("Falha ao localizar o paciente por [nome] \n" + e.getMessage());
        }
        return pacientes;
    }

}
