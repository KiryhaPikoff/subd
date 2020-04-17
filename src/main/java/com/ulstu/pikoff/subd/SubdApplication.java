package com.ulstu.pikoff.subd;

import com.ulstu.pikoff.subd.entity.Category;
import com.ulstu.pikoff.subd.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class SubdApplication {

	private final AdRepository adRepository;

	private final CategoryRepository categoryRepository;

	private final ClientRepository clientRepository;

	private final CommentRepository commentRepository;

	private final ProductInfoRepository productInfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SubdApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStart() {
		System.out.println("=".repeat(150));
		this.firstRequest();;
		System.out.println("=".repeat(150));
		this.secondRequest();
		System.out.println("=".repeat(150));
		this.createCategory();
		System.out.println("=".repeat(150));
		this.deleteCategory();
		System.out.println("=".repeat(150));
		this.updateCategory();
		System.out.println("=".repeat(150));
		this.readAds();
		System.out.println("=".repeat(150));
		this.readClients();
		System.out.println("=".repeat(150));
		this.readComments();
		System.out.println("=".repeat(150));
		this.readCategories();
		System.out.println("=".repeat(150));
		this.readProductInfos();
		System.out.println("=".repeat(150));
	}

	public void firstRequest() {
		Timestamp start = new Timestamp(System.currentTimeMillis());
		List<CategoryNameWithCount> resultFirst = adRepository.getNameCategoryCount();
		Timestamp end = new Timestamp(System.currentTimeMillis());
		System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");

		resultFirst.forEach(categoryNameWithCount -> {
			System.out.print("Название категории: " + categoryNameWithCount.getCategoryName() + " ");
			System.out.println("Количество: " + categoryNameWithCount.getCount());
		});
	}

	public void secondRequest() {
		Timestamp start = new Timestamp(System.currentTimeMillis());
		List<CategoryNameWithMaxRating> resultSecond = adRepository.getCategoryRating(
				new Timestamp(1539547200000L),
				new Timestamp(System.currentTimeMillis())
		);
		Timestamp end = new Timestamp(System.currentTimeMillis());
		System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");

		resultSecond.forEach(categoryNameWithMaxRating -> {
			System.out.print("Название категории: " + categoryNameWithMaxRating.getCategoryName() + " ");
			System.out.println("Рейтинг: " + categoryNameWithMaxRating.getRating());
		});
	}

	private void createCategory() {
		Category parentCategory = new Category(null, "Категория 1", null, null);

		categoryRepository.save(parentCategory);

		Category childCategory = new Category(null, "Категория 2", null, null);

		categoryRepository.save(childCategory);
	}

	private void deleteCategory() {
		categoryRepository.deleteById(10005);
	}

	private void updateCategory() {
		Category parentCategory = new Category(10003, "Категория 555", null, null);
		categoryRepository.save(parentCategory);
	}

	private void readAds() {
		Timestamp start = new Timestamp(System.currentTimeMillis());
		adRepository.findAll(PageRequest.of(2, 2, Sort.Direction.ASC, "rating"))
				.toList()
				.forEach(System.out::println);
		Timestamp end = new Timestamp(System.currentTimeMillis());
		System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
	}

	private void readClients() {
		clientRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "name"))
				.toList()
				.forEach(System.out::println);
	}

	private void readComments() {
		commentRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "creationDate"))
				.toList()
				.forEach(System.out::println);
	}

	private void readCategories() {
		categoryRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "name"))
				.toList()
				.forEach(System.out::println);
	}

	private void readProductInfos() {
		productInfoRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "name"))
				.toList()
				.forEach(System.out::println);
	}
}