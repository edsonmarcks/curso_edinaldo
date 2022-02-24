package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Medico  implements Base{
    private Integer id;
    private String nome;
    private LocalDate dataAdmissao;
    private String especializacao;
    private String telefone;
    private String CRM;
    private String email;

    
    public Medico() {
    }

    public Medico(Integer id, String nome, LocalDate dataAdmissao, String especializacao, String telefone, String CRM, String email) {
        this.id = id;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.especializacao = especializacao;
        this.telefone = telefone;
        this.CRM = CRM;
        this.email = email;
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

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome+" - CRM [ "+CRM+" ]"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
