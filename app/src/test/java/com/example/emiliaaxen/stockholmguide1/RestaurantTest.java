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
    public void TestIfRestaurantNeighborhoodIsCorrect(){
        StockholmItem restaurantNeighborhood = new StockholmItem();
        restaurantNeighborhood.setNeighborhood("Norrmalm/Vasastan");


        String expected = "Saturnus";
        String actual = restaurantNeighborhood.getName();
        assertEquals(expected, actual);

    }

    }
    @Test
    public void TestIfRestaurantAddressIsCorrect(){

    }
   
}
