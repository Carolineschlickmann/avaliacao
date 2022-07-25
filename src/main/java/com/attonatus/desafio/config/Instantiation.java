package com.attonatus.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attonatus.desafio.domain.Endereco;
import com.attonatus.desafio.domain.Pessoa;
import com.attonatus.desafio.repository.EnderecoRepository;
import com.attonatus.desafio.repository.PessoaRepository;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {

		Pessoa p1 = new Pessoa(null, "Maria Brown", "2019/09/17");
		Pessoa p2 = new Pessoa(null, "Alex Green", "2015/06/25");

		Endereco e1 = new Endereco(null, "São Ludgero", "Rodovia SC 108", 88730000, 1030, true, p1);
		Endereco e2 = new Endereco(null, "Gravatal", "Rodovia SC 370", 88735000, 2400, true, p2);
		Endereco e3 = new Endereco(null, "Tubarao", "Rodovia SC 370", 88701970, 800, false, p2);

		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
	}
}
