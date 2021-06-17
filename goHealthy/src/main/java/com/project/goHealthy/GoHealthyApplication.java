package com.project.goHealthy;

import com.project.goHealthy.entity.Product;
import com.project.goHealthy.repository.ProductRepository;
import com.project.goHealthy.repository.UserRepository;
import com.project.goHealthy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class GoHealthyApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

//	@PostConstruct
//	public void initUsers() {
//		List<User> users = Stream.of(
//				new User(101, "codrut", "password", "conesciuc@yahoo.com"),
//				new User(102, "user1", "pwd1", "user1@yahoo.com"),
//				new User(103, "user2", "pwd2", "user2@yahoo.com"),
//				new User(104, "user3", "pwd3", "user3@yahoo.com")
//		).collect(Collectors.toList());
//		repository.saveAll(users);
//	}

//	@PostConstruct
//	public void initProducts() {
//		List<Product> products = Stream.of(
//			new Product(101, "apple", 0.5, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fyurta.ro%2Fblog%2Fmar-patul%2F&psig=AOvVaw2mMhoWFaYfMblksVIKn4Cg&ust=1622668987208000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLDM_pav9_ACFQAAAAAdAAAAABAD"),
//			new Product(102, "banana", 0.7, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.digi24.ro%2Fstiri%2Fexterne%2Fmapamond%2Fo-banana-cumparata-de-la-alimentara-a-ajuns-sa-coste-120-000-de-dolari-dupa-ce-a-fost-expusa-ca-opera-de-arta-1227102&psig=AOvVaw0J7WRgphJbm2Xz8kLrS8SP&ust=1622669053836000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNCOvbav9_ACFQAAAAAdAAAAABAD"),
//			new Product(103, "peach", 0.8, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.libertyprim.com%2Fen%2Flexique-familles%2F96%2Fpeach-lexique-des-fruits.htm&psig=AOvVaw1xGchOt6UX_eHL3IYNXeNA&ust=1622669097997000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMjAh8yv9_ACFQAAAAAdAAAAABAD")
//		).collect(Collectors.toList());
//		productRepository.saveAll(products);
//	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*")
						.allowedHeaders("*")
						.allowedMethods("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true);
			}
		};
	}

//	@Bean
//	CommandLineRunner runner(ProductService productService) {
//		return args -> {
//			productService.save(new Product(1, "TV Set", 300.00, "http://placehold.it/200x100"));
//			productService.save(new Product(2, "Game Console", 200.00, "http://placehold.it/200x100"));
//			productService.save(new Product(3, "Sofa", 100.00, "http://placehold.it/200x100"));
//			productService.save(new Product(4, "Icecream", 5.00, "http://placehold.it/200x100"));
//			productService.save(new Product(5, "Beer", 3.00, "http://placehold.it/200x100"));
//			productService.save(new Product(6, "Phone", 500.00, "http://placehold.it/200x100"));
//			productService.save(new Product(7, "Watch", 30.00, "http://placehold.it/200x100"));
//		};
//	}



	public static void main(String[] args) {
		SpringApplication.run(GoHealthyApplication.class, args);
	}

}
