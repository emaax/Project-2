package com.example.emiliaaxen.stockholmguide1;

import com.example.emiliaaxen.stockholmguide1.model.StockholmItem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by emiliaaxen on 16-03-25.
 */
public class RestaurantTest {
    @Test
    public void TestIfRestaurantNameIsCorrect(){

        StockholmItem restaurant = new StockholmItem();
        restaurant.setName("Saturnus");


        String expected = "Saturnus";
        String actual = restaurant.getName();
        assertEquals(expected, actual);

    }



    @Test
    public void TestIfRestaurantLocationIsCorrect(){

    }
    @Test
    public void TestIfRestaurantAddressIsCorrect(){

    }
    @Test
    public void TestIfRestaurantNeighborhoodIsCorrect(){

    }
}
