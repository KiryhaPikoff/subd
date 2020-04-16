package com.ulstu.pikoff.subd;

import com.ulstu.pikoff.subd.repository.AdRepository;
import com.ulstu.pikoff.subd.repository.CategoryNameWithCount;
import com.ulstu.pikoff.subd.repository.CategoryNameWithMaxRating;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class SubdApplication {

	private final AdRepository adRepository;

	public static void main(String[] args) {
		SpringApplication.run(SubdApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStart() {
		System.out.println("=".repeat(150));

		Timestamp firstStart = new Timestamp(System.currentTimeMillis());
		List<CategoryNameWithCount> resultFirst = adRepository.getNameCategoryCount();
		Timestamp firstEnd = new Timestamp(System.currentTimeMillis());
		System.out.println("Время выполнения запроса: " + (firstEnd.getTime() - firstStart.getTime()) + " мс");

		System.out.println("=".repeat(150));
		resultFirst.forEach(categoryNameWithCount -> {
			System.out.print("Название категории: " + categoryNameWithCount.getCategoryName() + " ");
			System.out.println("Количество: " + categoryNameWithCount.getCount());
		});
		System.out.println("=".repeat(150));

		Timestamp secondStart = new Timestamp(System.currentTimeMillis());
		List<CategoryNameWithMaxRating> resultSecond = adRepository.getCategoryRating(new Timestamp(1539547200000L), new Timestamp(System.currentTimeMillis()));
		Timestamp secondEnd = new Timestamp(System.currentTimeMillis());
		System.out.println("Время выполнения запроса: " + (secondEnd.getTime() - secondStart.getTime()) + " мс");

		System.out.println("=".repeat(150));
		resultSecond.forEach(categoryNameWithMaxRating -> {
			System.out.print("Название категории: " + categoryNameWithMaxRating.getCategoryName() + " ");
			System.out.println("Рейтинг: " + categoryNameWithMaxRating.getRating());
		});
		System.out.println("=".repeat(150));
	}
}