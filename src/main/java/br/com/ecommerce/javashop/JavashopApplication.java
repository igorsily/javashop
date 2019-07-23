package br.com.ecommerce.javashop;

import br.com.ecommerce.javashop.models.Category;
import br.com.ecommerce.javashop.models.City;
import br.com.ecommerce.javashop.models.Products;
import br.com.ecommerce.javashop.models.States;
import br.com.ecommerce.javashop.repositories.CategoryRepository;
import br.com.ecommerce.javashop.repositories.CityRepository;
import br.com.ecommerce.javashop.repositories.ProductRepository;
import br.com.ecommerce.javashop.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class JavashopApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoriaRepository;

	@Autowired
	private ProductRepository produtoRepository;

	@Autowired
	private CityRepository cidadeRepository;
	@Autowired
	private StateRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavashopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category( "Informática");
		Category cat2 = new Category( "Escritório");
		Category cat3 = new Category( "Cama mesa e banho");
		Category cat4 = new Category( "Eletrônicos");
		Category cat5 = new Category( "Jardinagem");
		Category cat6 = new Category( "Decoração");
		Category cat7 = new Category( "Perfumaria");

		Products p1 = new Products( "Computador", new BigDecimal(2000.00));
		Products p2 = new Products( "Impressora", new BigDecimal(2000.00));
		Products p3 = new Products( "Mouse", new BigDecimal(2000.00));
		Products p4 = new Products( "Mesa de escritório", new BigDecimal(2000.00));
		Products p5 = new Products( "Toalha", new BigDecimal(2000.00));
		Products p6 = new Products( "Colcha", new BigDecimal(2000.00));
		Products p7 = new Products( "TV true color", new BigDecimal(2000.00));
		Products p8 = new Products( "Roçadeira", new BigDecimal(2000.00));
		Products p9 = new Products( "Abajour", new BigDecimal(2000.00));
		Products p10 = new Products( "Pendente", new BigDecimal(2000.00));
		Products p11 = new Products( "Shampoo", new BigDecimal(2000.00));

		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		States est1 = new States( "Minas Gerais");
		States est2 = new States( "São Paulo");

		City c1 = new City( "Uberlândia", est1);
		City c2 = new City( "São Paulo", est2);

		c1.setState(est1);
		c2.setState(est2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2));




	}
}