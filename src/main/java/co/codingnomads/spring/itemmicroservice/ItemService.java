package co.codingnomads.spring.itemmicroservice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository = null;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Item updatedItem) {
        Item item = itemRepository.findByName(updatedItem.getName());
        BeanUtils.copyProperties(updatedItem, item);
        return itemRepository.save(item);
    }

    public Item insertNewItem(Item newItem) {
        return itemRepository.save(newItem);
    }

     Item getItemById(Long id)

    { return itemRepository.findById(id)
            .orElse(null);
    }

    public void deleteItemById(Long id) {itemRepository.deleteById(id);
    }
}
