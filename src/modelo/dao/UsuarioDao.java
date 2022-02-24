package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import modelo.utils.Permissao;

/**
 *
 * @author edsonmarcks
 */
public class UsuarioDao implements Operacao<Usuario> {

    //Objetos de conexao
    String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean ok = false;

    @Override
    public boolean salvar(Usuario t) {
        try {
            sql = "INSERT INTO usuario (use_nome,use_senha,use_permissao) "
                    + "VALUES (?,?,?)";
            //abre uma conexao;
            ps = ConexaoDB.getConexao().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNome());
            ps.setString(2, t.getSenha());
            ps.setString(3, t.getPermissaoUsuario().name());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                t.setId(rs.getInt(1));
            }
            rs.close();
            System.out.println("novo usuário cadastrado com sucesso!");
            ps.closeOnCompletion();
            ok = true;
        } catch (SQLException e) {
            ok = false;
            System.err.println("Erro ao tentar cadastrar o usuário\n" + e.getMessage());
            TransportMessage.MESSAGE = e.getMessage();
            TransportMessage.COD_ERROR = e.getErrorCode();
            System.out.println(e.getErrorCode());
        }

        return ok;
    }

    @Override
    public boolean atualizar(Usuario t) {
        try {
            sql = "UPDATE usuario SET use_nome=?,use_permissao=? WHERE use_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, t.getNome());
            ps.setString(2, t.getPermissaoUsuario().name());
            ps.setInt(3, t.getId());
            ps.execute();
            System.out.println("usuário atualizado com sucesso!");
            ps.closeOnCompletion();
            ok = true;
        } catch (SQLException e) {
            ok = false;
            System.err.println("Erro ao tentar atualizar o usuário\n" + e.getMessage());
        }

        return ok;
    }

    @Override
    public boolean remover(Usuario t) {
        try {
            sql = "DELETE FROM usuario  WHERE use_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, t.getId());
            ps.execute();
            System.out.println("usuário removido com sucesso!");
            ps.closeOnCompletion();
            ok = true;
        } catch (SQLException e) {
            ok = false;
            System.err.println("Erro ao tentar remover o usuário\n" + e.getMessage());
        }
        return ok;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        Usuario usuario = null;
        try {
            sql = "select use_id,use_nome,use_permissao FROM usuario "
                    + "WHERE use_id=?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("use_id"));
                usuario.setNome(rs.getString("use_nome"));
                usuario.setPermissaoUsuario(Permissao.valueOf(rs.getString("use_permissao")));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Erro ao tentar buscar o usuario\n" + e.getMessage());
        }

        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            sql = "select use_id,use_nome,use_permissao FROM usuario ";
            ps = ConexaoDB.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("use_id"));
                usuario.setNome(rs.getString("use_nome"));
                usuario.setPermissaoUsuario(Permissao.valueOf(rs.getString("use_permissao")));
                usuarios.add(usuario);
                usuario = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Erro ao tentar buscar o usuario\n" + e.getMessage());
        }

        return usuarios;
    }

    public Usuario validarLogin(String use_nome, String use_senha) {
        Usuario usuario = null;
        try {

            sql = "select use_id,use_nome, use_senha, use_permissao FROM usuario WHERE"
                    + " use_nome=? and use_senha = ?";

            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, use_nome);
            ps.setString(2, use_senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("use_id"));
                usuario.setNome(rs.getString("use_nome"));
                usuario.setSenha(rs.getString("use_senha"));
                usuario.setPermissaoUsuario(Permissao.valueOf(rs.getString("use_permissao")));
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Falha: "+e.getMessage());
        }
        return usuario;
    }
    
        public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            sql = "select use_id,use_nome,use_permissao FROM usuario where use_nome like ?";
            ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            rs = ps.executeQuery();
            Usuario usuario;
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("use_id"));
                usuario.setNome(rs.getString("use_nome"));
                usuario.setPermissaoUsuario(Permissao.valueOf(rs.getString("use_permissao")));
                usuarios.add(usuario);
                usuario = null;
            }
            rs.close();
            ps.closeOnCompletion();
        } catch (Exception e) {
            System.err.println("Erro ao tentar buscar o usuario\n" + e.getMessage());
        }

        return usuarios;
    }
}
