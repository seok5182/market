package com.sparta.market.controller;

import com.sparta.market.dto.ItemRequestDto;
import com.sparta.market.dto.ItemResponseDto;
import com.sparta.market.entity.Item;
import com.sparta.market.msg.Msg;
import com.sparta.market.service.ItemService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping("/post")
	public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
		return itemService.createItem(requestDto);
	}

	@GetMapping("/post")
	public List<ItemResponseDto> getItems() {
		return itemService.getItems();
	}

	@PutMapping("/post/{id}")
	public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
		return itemService.updateItem(id, requestDto);
	}

	@DeleteMapping("/post/{id}")
	public Msg deleteItem(@PathVariable Long id) {
		return itemService.deleteItem(id);
	}
}
