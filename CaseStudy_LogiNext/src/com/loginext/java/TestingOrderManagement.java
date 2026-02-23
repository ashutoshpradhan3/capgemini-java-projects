package com.loginext.java;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestingOrderManagement {
	
	@Test
    void testAssignOrders() {

        Dummy service = new Dummy();

        int[][] orders = {{1, 10},{4, 20},{15, 5},{22, 20},{24, 10},{25, 10}};

        List<String> expected = Arrays.asList("C1 - D1","C2 - D2","C3 - D1","C4 - D1","C5 - D2","C6 - No Food :-(");

        List<String> actual = service.assignOrders(orders, 2);

        assertEquals(expected, actual);
	}
}
