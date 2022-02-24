package modelo;

public class Consulta extends Servico{
    private String diagnostico;
    private String medicao;

    public Consulta() {
        
    }


    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicao() {
        return medicao;
    }

    public void setMedicao(String medicao) {
        this.medicao = medicao;
    }    
}
