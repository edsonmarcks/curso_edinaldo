
package modelo;

import java.time.LocalDate;
import java.util.Objects;
import modelo.utils.VerificadorCPF;

public class Paciente implements Base{
    private Integer id;
    private String nome;
    private LocalDate nascimento;
    private String sexo;
    private String CPF;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Paciente() {
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    /**
     * Este campo apenas aceita cpf válido
     * 
     * @param CPF
     * @throws RuntimeException 
     */
    public void setCPF(String CPF) throws RuntimeException{
//        if(!VerificadorCPF.validandoCPF(CPF))
//            throw  new RuntimeException("CPF Informado é Inválido!!!");
        this.CPF = CPF.replaceAll("-", "").replaceAll("\\.", "");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
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
