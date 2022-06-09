package com.github.matheushenrique18.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.github.matheushenrique18.model.CadastrarProdutoDTO;
import com.github.matheushenrique18.model.Produto;

@ApplicationScoped
public class ProdutoService {
	
	public List<Produto> buscarTodosProdutos(){
		return Produto.listAll();
	}
	
	public List<Produto> buscarProdutosValorMaiorQue(Integer parametro){
		Predicate<Produto> greaterThan10 = x -> x.valor.intValue() > parametro;
		
		List<Produto> todosProdutos = Produto.listAll();
		
		return todosProdutos.stream().filter(greaterThan10).collect(Collectors.toList());
	}
	
	@Transactional
	public void salvarProduto(CadastrarProdutoDTO dto){
		Produto p = new Produto();
		p.nome = dto.nome;
		p.valor = dto.valor;
		p.persist();
	}
	
	@Transactional
	public void alterarProduto(Long id, CadastrarProdutoDTO dto){
		
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		if(produtoOp.isPresent()) {
			Produto p = produtoOp.get();
			p.nome = dto.nome;
			p.valor = dto.valor;
			p.persist();
		}else {
			throw new NotFoundException();
		}
	}
	
	@Transactional
	public void excluirProduto(Long id){
		
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		produtoOp.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
	}

}
