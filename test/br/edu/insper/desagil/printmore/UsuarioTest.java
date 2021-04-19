package br.edu.insper.desagil.printmore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private static double DELTA = 0.01;

	private Usuario u;
	
	@BeforeEach
	public void setUp() {
		u = new Usuario("João");
	}
	
	@Test
	public void umVideoAvaliacoesInvalidas() {
		Video video = u.postaVideo(1, new Produto("Mesa",102.5));
		video.adicionaAvaliacao(u, 2);
		video.adicionaAvaliacao(new Usuario("Maria"), 0);
		video.adicionaAvaliacao(new Usuario("Mariana"), 6);
		assertEquals(0,u.totalAvaliacoes(),DELTA);
	}

	@Test
	public void umVideoUmaAvaliacao() {
		Video video = u.postaVideo(1, new Produto("Mesa",102.5));
		video.adicionaAvaliacao(new Usuario("Maria"), 4);
		assertEquals(4,u.totalAvaliacoes(),DELTA);
	}
	
	@Test
	public void umVideoDuasAvaliacoes() {
		Video video = u.postaVideo(1, new Produto("Mesa",102.5));
		video.adicionaAvaliacao(new Usuario("Maria"), 4);
		video.adicionaAvaliacao(new Usuario("Mariana"), 3);
		assertEquals(4,u.totalAvaliacoes(),DELTA);
	}
	
	@Test
	public void umVideoTresAvaliacoes() {
		Video video = u.postaVideo(1, new Produto("Mesa",102.5));
		video.adicionaAvaliacao(new Usuario("Maria"), 4);
		video.adicionaAvaliacao(new Usuario("Mariana"), 3);
		video.adicionaAvaliacao(new Usuario("Dulce"), 3);
		assertEquals(3,u.totalAvaliacoes(),DELTA);
	}
	
	@Test
	public void doisVideosTresAvaliacoes() {
		Video video1 = u.postaVideo(1, new Produto("Mesa",102.5));
		Video video2 = u.postaVideo(1, new Produto("cadeira",25.5));
		video1.adicionaAvaliacao(new Usuario("Maria"), 4);
		video1.adicionaAvaliacao(new Usuario("Mariana"), 3);
		video2.adicionaAvaliacao(new Usuario("Dulce"), 3);
		assertEquals(7,u.totalAvaliacoes(),DELTA);
	}
	
	
}
