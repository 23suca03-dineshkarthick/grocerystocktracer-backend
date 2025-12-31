package com.example.Grocery.Stock.Trcaer.inventory;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory-items")
@CrossOrigin
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service) {
        this.service = service;
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return service.getAllItems();
    }

    @PutMapping(path = "/{id}")
    public InventoryItem updateStatus(@PathVariable Long id, @RequestParam ItemStatus status) {
        return service.updateItemStatus(id, status);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
