package com.ravi.onlineshop.bo;

import com.ravi.onlineshop.model.Item;
import com.ravi.onlineshop.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemBo {

   private ItemRepository itemRepository;


   @Autowired
   public ItemBo(ItemRepository itemRepository){
       log.debug("Item Repository BO is called");
       this.itemRepository = itemRepository;
   }

    /**
     *
     * @return List of All Items
     */
    public List<Item> viewItems() {
        return itemRepository.findAll();
    }
}
