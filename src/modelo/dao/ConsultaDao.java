package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;

public class ConsultaDao implements Operacao<Consulta> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean salvar(Consulta t) {
        try {
            sql = "INSERT INTO consulta ("
                    + "con_paciente_id,"
                    + "con_medico_id,"
                    + "con_data,"
                    + "con_hora,"
                    + "con_status,"
                    + "con_diagnostico,"
                    + "con_medicacao)"
                    + " VALUES (?,?,?,?,?,?,?)";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getPaciente().getId());
            ps.setInt(2, t.getMedico().getId());
            ps.setDate(3, Date.valueOf(t.getDataLancamento()));
            ps.setString(4, t.getHora());
            ps.setString(5, t.getStatus());
            ps.setString(6, t.getDiagnostico());
            ps.setString(7, t.getMedicao());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Consulta inserida com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Consulta t) {
        try {
            sql = "UPDATE consulta SET"
                    + " con_paciente_id=?,"
                    + "con_medico_id=?,"
                    + "con_data=?,"
                    + "con_hora=?,"
                    + "con_status=?,"
                    + "con_diagnostico=?,"
                    + "con_medicacao=? "
                    + " WHERE con_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getPaciente().getId());
            ps.setInt(2, t.getMedico().getId());
            ps.setDate(3, Date.valueOf(t.getDataLancamento()));
            ps.setString(4, t.getHora());
            ps.setString(5, t.getStatus());
            ps.setString(6, t.getDiagnostico());
            ps.setString(7, t.getMedicao());
            ps.setInt(8, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Consulta atualizar com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Consulta t) {
        try {
            sql = "DELETE FROM consulta WHERE con_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Consulta remover com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        Consulta consulta = null;
        try {
            sql = "SELECT * FROM consulta WHERE con_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("con_id"));
                consulta.getPaciente().setId(rs.getInt("con_paciente_id"));
                consulta.getMedico().setId(rs.getInt("con_medico_id"));
                consulta.setDataLancamento(rs.getDate("con_data").toLocalDate());
                consulta.setHora(rs.getString("con_hora"));
                consulta.setStatus(rs.getString("con_status"));
                consulta.setDiagnostico(rs.getString("con_diagnostico"));
                consulta.setMedicao(rs.getString("con_medicacao"));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return consulta;
    }

    @Override
    public List<Consulta> buscarTodos() {
        List<Consulta> consultas = new ArrayList<>();
        try {
            sql = "SELECT * FROM consulta ";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            Consulta consulta = null;
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("con_id"));
                consulta.getPaciente().setId(rs.getInt("con_paciente_id"));
                consulta.getMedico().setId(rs.getInt("con_medico_id"));
                consulta.setDataLancamento(rs.getDate("con_data").toLocalDate());
                consulta.setHora(rs.getString("con_hora"));
                consulta.setStatus(rs.getString("con_status"));
                consulta.setDiagnostico(rs.getString("con_diagnostico"));
                consulta.setMedicao(rs.getString("con_medicacao"));
                consultas.add(consulta);
                consulta = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return consultas;
    }

    public List<Consulta> buscarConsultaPaciente(Integer pacienteID) {
        List<Consulta> consultas = new ArrayList<>();
        try {
            sql = "SELECT * FROM consulta Where con_paciente_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, pacienteID);
            rs = ps.executeQuery();
            Consulta consulta = null;
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("con_id"));
                consulta.getPaciente().setId(rs.getInt("con_paciente_id"));
                consulta.getMedico().setId(rs.getInt("con_medico_id"));
                consulta.setDataLancamento(rs.getDate("con_data").toLocalDate());
                consulta.setHora(rs.getString("con_hora"));
                consulta.setStatus(rs.getString("con_status"));
                consulta.setDiagnostico(rs.getString("con_diagnostico"));
                consulta.setMedicao(rs.getString("con_medicacao"));
                consultas.add(consulta);
                consulta = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return consultas;
    }

    public List<Consulta> buscarConsultaMedico(Integer medicoId) {
        List<Consulta> consultas = new ArrayList<>();
        try {
            sql = "SELECT * FROM consulta Where con_medico_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, medicoId);
            rs = ps.executeQuery();
            Consulta consulta = null;
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("con_id"));
                consulta.getPaciente().setId(rs.getInt("con_paciente_id"));
                consulta.getMedico().setId(rs.getInt("con_medico_id"));
                consulta.setDataLancamento(rs.getDate("con_data").toLocalDate());
                consulta.setHora(rs.getString("con_hora"));
                consulta.setStatus(rs.getString("con_status"));
                consulta.setDiagnostico(rs.getString("con_diagnostico"));
                consulta.setMedicao(rs.getString("con_medicacao"));
                consultas.add(consulta);
                consulta = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return consultas;
    }

    public List<Consulta> buscarConsultaMedicoPaciente(Integer medicoID,Integer pacienteID) {
        List<Consulta> consultas = new ArrayList<>();
        try {
            sql = "SELECT * FROM consulta Where con_medico_id=? and con_paciente_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, medicoID);
            ps.setInt(2, pacienteID);
            rs = ps.executeQuery();
            Consulta consulta = null;
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("con_id"));
                consulta.getPaciente().setId(rs.getInt("con_paciente_id"));
                consulta.getMedico().setId(rs.getInt("con_medico_id"));
                consulta.setDataLancamento(rs.getDate("con_data").toLocalDate());
                consulta.setHora(rs.getString("con_hora"));
                consulta.setStatus(rs.getString("con_status"));
                consulta.setDiagnostico(rs.getString("con_diagnostico"));
                consulta.setMedicao(rs.getString("con_medicacao"));
                consultas.add(consulta);
                consulta = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return consultas;
    }
}
