/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utils;

/**
 *
 * @author edsonmarcks
 */
public enum MesEnum {
    JAN(1,"Janeiro"),
    FEV(2,"Fevereiro"),
    MAR(3,"Março"),
    ABR(4,"Abril"),
    MAI(5,"Maio"),
    JUN(6,"Junho"),
    JUL(7,"Julho"),
    AGO(8,"Agosto"),
    SET(9,"Setembro"),
    OUT(10,"Outubro"),
    NOV(11,"Novembro"),
    DEZ(12,"Dezembro");
    
    private String mes;
    private Integer numeric;
    
    private MesEnum(Integer numeric,String mes) {
        this.numeric = numeric;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return mes; //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getValor(){
        return numeric;
    }
    
}
