package modelo.dao;

import java.util.List;
import modelo.Base;

public interface Operacao<T extends Base>{
    public boolean salvar(T t);
    public boolean atualizar(T t);
    public boolean remover(T t);
    public T buscarPorId(Integer id);
    public List<T> buscarTodos();
}
