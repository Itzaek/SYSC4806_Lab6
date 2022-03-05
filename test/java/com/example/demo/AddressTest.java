package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private BuddyInfo buddyInfo;

    @BeforeEach
    public void setUp() {
        buddyInfo = new BuddyInfo("Isaac", "Test Place", "111-111-1111");
    }
    @Test
    public void testAddress() {
        buddyInfo.setAddress("Test Change Address");
        assertEquals("Test Change Address", buddyInfo.getAddress());
    }
}
