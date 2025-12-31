-- Clear existing data to prevent duplicates
DELETE FROM inventory_item;

-- Initial inventory data
INSERT INTO inventory_item (item_name, status) VALUES ('Milk', 'AVAILABLE');
INSERT INTO inventory_item (item_name, status) VALUES ('Bread', 'AVAILABLE');
INSERT INTO inventory_item (item_name, status) VALUES ('Eggs', 'AVAILABLE');
INSERT INTO inventory_item (item_name, status) VALUES ('Butter', 'OCCUPIED');
INSERT INTO inventory_item (item_name, status) VALUES ('Cheese', 'AVAILABLE');
INSERT INTO inventory_item (item_name, status) VALUES ('Yogurt', 'AVAILABLE');
