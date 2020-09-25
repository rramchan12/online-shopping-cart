package com.ravi.onlineshop.repository;

import com.ravi.onlineshop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
