package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Medico;

public class MedicoDao implements Operacao<Medico> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean salvar(Medico t) {
        try {
            sql = "INSERT INTO medico ("
                    + "med_nome,"
                    + "med_data_admissao,"
                    + "med_especializacao,"
                    + "med_telefone,"
                    + "med_CRM)"
                    + " VALUES (?,?,?,?,?)";
            ps = ConexaoDB.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNome());
            ps.setDate(2, Date.valueOf(t.getDataAdmissao()));
            ps.setString(3, t.getEspecializacao());
            ps.setString(4, t.getTelefone());
            ps.setString(5, t.getCRM());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                t.setId(rs.getInt(1));
            }
            rs.close();
            ps.closeOnCompletion();
            System.out.println("novo médico inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Não foi possível inserir novo registro\n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Medico t) {
        try {
            sql = "UPDATE medico SET "
                    + "med_nome=?,"
                    + "med_data_admissao=?,"
                    + "med_especializacao=?,"
                    + "med_telefone=?,"
                    + "med_CRM=?"
                    + " WHERE med_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, t.getNome());
            ps.setDate(2, Date.valueOf(t.getDataAdmissao()));
            ps.setString(3, t.getEspecializacao());
            ps.setString(4, t.getTelefone());
            ps.setString(5, t.getCRM());
            ps.setInt(6, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("novo médico atualizar com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Não foi possível atualizar novo registro\n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Medico t) {
        try {
            sql = "DELETE FROM medico WHERE med_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Médico removido com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Não foi possível remover registro\n" + e.getMessage());
        }
        return false;
    }

    @Override
    public Medico buscarPorId(Integer id) {
        Medico medico = null;
        try {
            sql = "Select * from medico where med_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt("med_id"));
                medico.setNome(rs.getString("med_nome"));
                medico.setDataAdmissao(rs.getDate("med_data_admissao").toLocalDate());
                medico.setEspecializacao(rs.getString("med_especializacao"));
                medico.setTelefone(rs.getString("med_telefone"));
                medico.setCRM(rs.getString("med_CRM"));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException ex) {
            System.err.println("Erro ao localizar médico\n" + ex.getMessage());
        }

        return medico;
    }

    @Override
    public List<Medico> buscarTodos() {
        List<Medico> medicos = new ArrayList<>();
        try {
            sql = "Select * from medico";
            ps = ConexaoDB.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();
            Medico medico = null;
            while (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt("med_id"));
                medico.setNome(rs.getString("med_nome"));
                medico.setDataAdmissao(rs.getDate("med_data_admissao").toLocalDate());
                medico.setEspecializacao(rs.getString("med_especializacao"));
                medico.setTelefone(rs.getString("med_telefone"));
                medico.setCRM(rs.getString("med_CRM"));
                medicos.add(medico);
                medico = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException ex) {
            System.err.println("Erro ao localizar médico\n" + ex.getMessage());
        }

        return medicos;
    }

    public List<Medico> buscarTodos(String nome) {
        List<Medico> medicos = new ArrayList<>();
        try {
            sql = "Select * from medico WHERE med_nome like ?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            Medico medico = null;
            while (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt("med_id"));
                medico.setNome(rs.getString("med_nome"));
                medico.setDataAdmissao(rs.getDate("med_data_admissao").toLocalDate());
                medico.setEspecializacao(rs.getString("med_especializacao"));
                medico.setTelefone(rs.getString("med_telefone"));
                medico.setCRM(rs.getString("med_CRM"));
                medicos.add(medico);
                medico = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException ex) {
            System.err.println("Erro ao localizar médico\n" + ex.getMessage());
        }

        return medicos;
    }

    public Medico buscarPorCRM(String CRM) {
        Medico medico = null;
        try {
            sql = "Select * from medico where med_CRM=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, CRM);
            rs = ps.executeQuery();
            if (rs.next()) {
                medico = new Medico();
                medico.setId(rs.getInt("med_id"));
                medico.setNome(rs.getString("med_nome"));
                medico.setDataAdmissao(rs.getDate("med_data_admissao").toLocalDate());
                medico.setEspecializacao(rs.getString("med_especializacao"));
                medico.setTelefone(rs.getString("med_telefone"));
                medico.setCRM(rs.getString("med_CRM"));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException ex) {
            System.err.println("Erro ao localizar médico\n" + ex.getMessage());
        }

        return medico;
    }
}
