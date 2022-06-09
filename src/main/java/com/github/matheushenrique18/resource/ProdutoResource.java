package com.github.matheushenrique18.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.matheushenrique18.model.CadastrarProdutoDTO;
import com.github.matheushenrique18.model.Produto;
import com.github.matheushenrique18.service.ProdutoService;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	@Inject
	ProdutoService produtoService;
	
	@GET
	public List<Produto> buscarTodosProdutos(){
		return produtoService.buscarTodosProdutos();
	}
	
	@Path("valoresMaioresQue/{parametro}")
	@GET
	public List<Produto> buscarProdutosValorMaiorQueDez(@PathParam("parametro") Integer p){
		return produtoService.buscarProdutosValorMaiorQue(p);
	}
	
	@POST
	public void salvarProduto(CadastrarProdutoDTO dto){
		produtoService.salvarProduto(dto);
	}
	
	@PUT
	@Path("{id}")
	public void alterarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto){
		produtoService.alterarProduto(id, dto);
	}
	
	@DELETE
	@Path("{id}")
	public void excluirProduto(@PathParam("id") Long id){
		
		produtoService.excluirProduto(id);
	}

}
