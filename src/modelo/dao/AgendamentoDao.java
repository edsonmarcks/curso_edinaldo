/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Agendamento;
import modelo.utils.StatusAgendamento;

/**
 *
 * @author edsonmarcks
 */
public class AgendamentoDao implements Operacao<Agendamento> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean salvar(Agendamento t) {
        try {
            sql = "INSERT INTO agendamento ("
                    + "age_paciente_id,"
                    + "age_medico_id,"
                    + "age_data,"
                    + "age_hora,"
                    + "age_status)"
                    + " VALUES (?,?,?,?,?)";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getPaciente().getId());
            ps.setInt(2, t.getMedico().getId());
            ps.setDate(3, Date.valueOf(t.getDataLancamento()));
            ps.setString(4, t.getHora());
            ps.setString(5, t.getStatus());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Agendamento inserida com sucesso!");
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Agendamento t) {
        try {
            sql = "UPDATE agendamento SET"
                    + " age_paciente_id=?,"
                    + "age_medico_id=?,"
                    + "age_data=?,"
                    + "age_hora=?,"
                    + "age_status=? "
                    + " WHERE age_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getPaciente().getId());
            ps.setInt(2, t.getMedico().getId());
            ps.setDate(3, Date.valueOf(t.getDataLancamento()));
            ps.setString(4, t.getHora());
            ps.setString(5, t.getStatus());
            ps.setInt(6, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Agendamento atualizar com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remover(Agendamento t) {
        try {
            sql = "DELETE FROM agendamento WHERE age_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
            ps.closeOnCompletion();
            System.out.println("Agendamento remover com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao tentar \n" + e.getMessage());
        }
        return false;
    }

    @Override
    public Agendamento buscarPorId(Integer id) {
        Agendamento agendamento = null;
        try {
            sql = "SELECT * FROM agendamento WHERE age_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt("age_id"));
                agendamento.getPaciente().setId(rs.getInt("age_paciente_id"));
                agendamento.getMedico().setId(rs.getInt("age_medico_id"));
                agendamento.setDataLancamento(rs.getDate("age_data").toLocalDate());
                agendamento.setHora(rs.getString("age_hora"));
                agendamento.setStatus(rs.getString("age_status"));;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamento;
    }

    @Override
    public List<Agendamento> buscarTodos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            sql = "SELECT * FROM agendamento ";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            Agendamento agendamento = null;
            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt("age_id"));
                agendamento.getPaciente().setId(rs.getInt("age_paciente_id"));
                agendamento.getMedico().setId(rs.getInt("age_medico_id"));
                agendamento.setDataLancamento(rs.getDate("age_data").toLocalDate());
                agendamento.setHora(rs.getString("age_hora"));
                agendamento.setStatus(rs.getString("age_status"));
                agendamentos.add(agendamento);
                agendamento = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamentos;
    }

    public List<Agendamento> buscarAgendamentoPaciente(Integer pacienteID) {
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            sql = "SELECT * FROM agendamento Where age_paciente_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, pacienteID);
            rs = ps.executeQuery();
            Agendamento agendamento = null;
            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt("age_id"));
                agendamento.getPaciente().setId(rs.getInt("age_paciente_id"));
                agendamento.getMedico().setId(rs.getInt("age_medico_id"));
                agendamento.setDataLancamento(rs.getDate("age_data").toLocalDate());
                agendamento.setHora(rs.getString("age_hora"));
                agendamento.setStatus(rs.getString("age_status"));
                agendamentos.add(agendamento);
                agendamento = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamentos;
    }

    public List<Agendamento> buscarAgendamentoMedico(Integer medicoId) {
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            sql = "SELECT * FROM agendamento Where age_medico_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, medicoId);
            rs = ps.executeQuery();
            Agendamento agendamento = null;
            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt("age_id"));
                agendamento.getPaciente().setId(rs.getInt("age_paciente_id"));
                agendamento.getMedico().setId(rs.getInt("age_medico_id"));
                agendamento.setDataLancamento(rs.getDate("age_data").toLocalDate());
                agendamento.setHora(rs.getString("age_hora"));
                agendamento.setStatus(rs.getString("age_status"));
                agendamentos.add(agendamento);
                agendamento = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamentos;
    }

    public List<Agendamento> buscarAgendamentoMedicoPaciente(Integer medicoId, Integer mes, StatusAgendamento status) {
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            sql = "SELECT agendamento.age_id, agendamento.age_data,agendamento.age_hora,agendamento.age_status,"
                    + "paciente.pac_nome, paciente.pac_nasc from agendamento INNER JOIN paciente on paciente.pac_id = agendamento.age_paciente_id "
                    + "Where agendamento.age_medico_id=? AND MONTH(agendamento.age_data) = ? AND agendamento.age_status=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, medicoId);
            ps.setInt(2, mes);
            ps.setString(3, status.name());
            rs = ps.executeQuery();
            Agendamento agendamento = null;
            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt(1));
                agendamento.setDataLancamento(rs.getDate(2).toLocalDate());
                agendamento.setHora(rs.getString(3));
                agendamento.setStatus(rs.getString(4));
                agendamento.getPaciente().setNome(rs.getString(5));
                agendamento.getPaciente().setNascimento(rs.getDate(6).toLocalDate());
                agendamentos.add(agendamento);
                agendamento = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamentos;
    }

    public List<Agendamento> buscarAgendamentoMedicoPaciente(Integer medicoID, Integer pacienteID) {
        List<Agendamento> agendamentos = new ArrayList<>();
        try {
            sql = "SELECT * FROM agendamento Where age_medico_id=? and age_paciente_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, medicoID);
            ps.setInt(2, pacienteID);
            rs = ps.executeQuery();
            Agendamento agendamento = null;
            while (rs.next()) {
                agendamento = new Agendamento();
                agendamento.setId(rs.getInt("age_id"));
                agendamento.getPaciente().setId(rs.getInt("age_paciente_id"));
                agendamento.getMedico().setId(rs.getInt("age_medico_id"));
                agendamento.setDataLancamento(rs.getDate("age_data").toLocalDate());
                agendamento.setHora(rs.getString("age_hora"));
                agendamento.setStatus(rs.getString("age_status"));
                agendamentos.add(agendamento);
                agendamento = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Desculpe erro ao buscar\n" + e.getMessage());
        }
        return agendamentos;
    }

    public boolean isHorarioVago(Integer idMedico, LocalDate data, String horario) {
        boolean resultado = false;
        try {
            sql = "select age_id from agendamento where age_medico_id=? "
                    + "and age_data = ? AND age_hora = ?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, idMedico);
            ps.setDate(2, Date.valueOf(data));
            ps.setString(3, horario);
            rs = ps.executeQuery();
            if(rs.next()){
                resultado=false;
            }else{
                resultado=true;
            }
            rs.close();
            ps.closeOnCompletion();
            
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
