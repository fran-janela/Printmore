package br.edu.insper.desagil.printmore;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<Usuario, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacao(Usuario usuario, int avaliacao) {
		if (usuario.getNome() != this.usuario.getNome()) {
			if ((1 <= avaliacao) && (5 >= avaliacao)) {
				this.avaliacoes.put(usuario, avaliacao);
			}
		}
	}
	
	public int mediaAvaliacoes() {
		int soma = 0;
		double media = 0.0;
		for (int avaliacao : this.avaliacoes.values()) {
			soma += avaliacao;
		}
		if (this.avaliacoes.size() != 0) {
			media = (double) soma / this.avaliacoes.size();
		}
		
		return (int) Math.round(media);
		
	}
}
