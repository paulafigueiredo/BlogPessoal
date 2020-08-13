package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository  extends JpaRepository<Postagem,Long>{
		 
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); 
	/*findAll = Buscar todos pelo titulo. 
	 * Containing = pegar tudo que conter os caracteres dentro da string
	 * IgnoreCase = Nao leva em consideraçao maiusculo e minusculo.
	 */
	
}
