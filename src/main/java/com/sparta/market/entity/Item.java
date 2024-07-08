package com.sparta.market.entity;

import com.sparta.market.dto.ItemRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "username", nullable = false)
	private String username;


	public Item(ItemRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.title = requestDto.getTitle();
		this.content = requestDto.getContent();
		this.price = requestDto.getPrice();
	}


	public void update(ItemRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.title = requestDto.getTitle();
		this.content = requestDto.getContent();
		this.price = requestDto.getPrice();
	}
}
