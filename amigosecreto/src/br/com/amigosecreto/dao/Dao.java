package br.com.amigosecreto.dao;

import java.util.List;

public interface Dao<T> {
	void adicionar(T entidade);
	 List<T> listar();
	 T buscar(int id); 
	 T atualizar(T entidade);
}
