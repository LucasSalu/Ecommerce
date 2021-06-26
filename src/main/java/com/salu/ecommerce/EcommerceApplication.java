 package com.salu.ecommerce;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salu.ecommerce.domain.Categoria;
import com.salu.ecommerce.domain.Cidade;
import com.salu.ecommerce.domain.Cliente;
import com.salu.ecommerce.domain.Endereco;
import com.salu.ecommerce.domain.Estado;
import com.salu.ecommerce.domain.Pagamento;
import com.salu.ecommerce.domain.PagamentoComBoleto;
import com.salu.ecommerce.domain.PagamentoComCartao;
import com.salu.ecommerce.domain.Pedido;
import com.salu.ecommerce.domain.Produto;
import com.salu.ecommerce.domain.enums.EstadoPagamento;
import com.salu.ecommerce.domain.enums.TipoCliente;
import com.salu.ecommerce.repository.CategoriaRepository;
import com.salu.ecommerce.repository.CidadeRepository;
import com.salu.ecommerce.repository.ClienteRepository;
import com.salu.ecommerce.repository.EnderecoRepository;
import com.salu.ecommerce.repository.EstadoRepository;
import com.salu.ecommerce.repository.PagamentoRepository;
import com.salu.ecommerce.repository.PedidoRepository;
import com.salu.ecommerce.repository.ProdutoRepository;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired 
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
    @Autowired
    PagamentoRepository pagamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		

		
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Categoria cat1 =  new Categoria(null, "Informatica");
//		Categoria cat2 =  new Categoria(null, "Escritorio");
//		
//		Produto p1 = new Produto(null, "Computador", 2000.00);
//		Produto p2 = new Produto(null, "Impressora", 800.00);
//		Produto p3 = new Produto(null, "Mouse", 80.00);
//		
//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat1.getProdutos().addAll(Arrays.asList(p2));
//		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
//		
//		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
//		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
//		
		
	    Categoria cat1 = new Categoria(null, "Informática");
	    Categoria cat2 = new Categoria(null, "Escritório");
	 
	     Produto p1 = new Produto(null, "Computador", 2000.00);
	     Produto p2 = new Produto(null, "Impressora", 800.00);
	     Produto p3 = new Produto(null, "Mouse", 80.00);
	     
	     Estado e1 = new Estado(null, "São Paulo");
	     Estado e2 = new Estado(null, "Minas Gerais");
	 
	     Cidade c1 = new Cidade(null, "Uberlandia", e2);
	     Cidade c2 = new Cidade(null, "São Paulo", e1);
	     Cidade c3 = new Cidade(null, "Campinas", e1);
	     
	     Cliente cl1 =  new Cliente(null,"Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
	     Endereco end1 =  new Endereco (null, "Rua das Flores","300","Apto 203", "Jardim","3822084",c1, cl1);
	     Endereco end2 =  new Endereco (null, "Avenida Matos","105","Sala 800", "Centro","38777012",c2, cl1);
	     
	     cl1.getEnderecos().addAll(Arrays.asList(end1, end2));
	     cl1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
	     
	     
	     e1.getCidades().addAll(Arrays.asList(c1));
	     e2.getCidades().addAll(Arrays.asList(c2, c3));
	     
	     categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	     produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	     categoriaRepository.flush();
	     produtoRepository.flush();
	 
	     cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	     cat2.getProdutos().add(p2);
	 
	     p1.getCategorias().add(cat1);
	     p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	     p3.getCategorias().add(cat1);
	     categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	     produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	     
	     estadoRepository.saveAll(Arrays.asList(e1,e2));
	     cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	     
	     clienteRepository.save(cl1);
	     enderecoRepository.saveAll(Arrays.asList(end1, end2));
	     
	     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	     Pedido ped1 =  new Pedido(null, sdf.parse("30/09/2017 10:32"), cl1,end1);
	     Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cl1, end2);
	     
	     Pagamento pag1 =  new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
	     ped1.setPagamento(pag1);
	     
	     Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
	     ped2.setPagamento(pag2);
	     
	     pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
	     pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	}

}
