package com.example.Grocery.Stock.Trcaer.inventory;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InventoryItemService {

    private final InventoryItemRepository repository;

    public InventoryItemService(InventoryItemRepository repository) {
        this.repository = repository;
    }

    public InventoryItem addItem(InventoryItem item) {
        // Check if item with same name already exists
        if (repository.findByItemName(item.getItemName()).isPresent()) {
            throw new RuntimeException("Item with name '" + item.getItemName() + "' already exists!");
        }
        item.setStatus(ItemStatus.AVAILABLE);
        return repository.save(item);
    }

    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    public InventoryItem updateItemStatus(Long id, ItemStatus status) {
        InventoryItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventoryItem not found: " + id));
        item.setStatus(status);
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("InventoryItem not found: " + id);
        }
        repository.deleteById(id);
    }
}
