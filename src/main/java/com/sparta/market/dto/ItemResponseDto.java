package com.sparta.market.dto;

import com.sparta.market.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
	private Long id;
	private String username;
	private String title;
	private String content;
	private int price;


	public ItemResponseDto(Item saveItem) {
		this.id = saveItem.getId();
		this.username = saveItem.getUsername();
		this.title = saveItem.getTitle();
		this.content = saveItem.getContent();
		this.price = saveItem.getPrice();
	}
}
