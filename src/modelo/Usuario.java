package modelo;

import java.util.Objects;
import modelo.utils.Permissao;

public class Usuario implements Base{
    private Integer id;
    private String nome;
    private String senha;
    private Permissao permissaoUsuario;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String senha, Permissao permissaoUsuario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.permissaoUsuario = permissaoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getPermissaoUsuario() {
        return permissaoUsuario;
    }

    public void setPermissaoUsuario(Permissao permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
