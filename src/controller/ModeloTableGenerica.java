package controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Base;

public  abstract class ModeloTableGenerica<T extends Base> extends AbstractTableModel{
    protected final DateTimeFormatter FORMATER_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected List<T> lista;
    protected String[] colunas;
    protected T entidade;

    public ModeloTableGenerica(List<T> lista, String[] colunas) {
        this.lista = lista;
        this.colunas = colunas;
        reloadTable();
    }
          
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public T getEntity(int row){
        return lista.get(row);
    }
    
    public void adicionar(T t){
        if(lista.contains(t)){
            int index = lista.indexOf(t);
            lista.remove(t);
            lista.add(index, t);
            fireTableRowsUpdated(index, index);
        }
        else{
            lista.add(t);
            fireTableRowsInserted(lista.size(), lista.size());
        }
    }
    
    public void remover(T t){
        if(lista.contains(t)){
            int index = lista.indexOf(t);
            lista.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }
    
    private void reloadTable() {
        fireTableRowsInserted(lista.size(), lista.size());
    }
    
    public void setLista(List<T> lista){
        this.lista=lista;
        reloadTable();
    }
    
    public void resetLista(){
        lista.removeAll(lista);
        fireTableRowsInserted(lista.size(), lista.size());
    }
}
