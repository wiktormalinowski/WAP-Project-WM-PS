package com.uep.wap.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ItemTest {
    @Test
    public void createItem() {
        final Item item = new Item(1, "name", "condition", 1.11f, "brand", null);
        assertEquals(1, item.getId());
        assertEquals("name", item.getName());
        assertEquals("condition", item.getCondition());
        assertEquals(1.11f, item.getWeight());
        assertEquals("brand", item.getBrand_name());
        assertNull(item.getAuctions());
    }

}