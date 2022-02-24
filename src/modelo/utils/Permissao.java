package modelo.utils;


public enum Permissao {
    USER_COMUM("Usuário comum"),
    ADMIN("Administrador"),
    MEDICO("Médico");
    
    private String text;

    private Permissao(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
