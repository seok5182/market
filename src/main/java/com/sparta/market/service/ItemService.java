package com.sparta.market.service;

import com.sparta.market.dto.ItemRequestDto;
import com.sparta.market.dto.ItemResponseDto;
import com.sparta.market.entity.Item;
import com.sparta.market.msg.Msg;
import com.sparta.market.repository.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ItemService {
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public ItemResponseDto createItem(ItemRequestDto requestDto) {
		Item item = new Item(requestDto);

		Item saveItem = itemRepository.save(item);

		return new ItemResponseDto(saveItem);
	}

	public List<ItemResponseDto> getItems() {
		return itemRepository.findAllByOrderByIdDesc().stream().map(ItemResponseDto::new).toList();
	}

	@Transactional
	public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
		Item item = findById(id);

		item.update(requestDto);

		return new ItemResponseDto(item);
	}

	public Msg deleteItem(Long id) {
		Item item = findById(id);

		itemRepository.delete(item);

		return new Msg("삭제완료");
	}

	private Item findById(Long id) {
		return itemRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
		);
	}
}
