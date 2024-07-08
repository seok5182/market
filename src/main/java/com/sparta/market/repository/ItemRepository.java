package com.sparta.market.repository;


import com.sparta.market.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findAllByOrderByIdDesc();
}
