package com.example.emiliaaxen.stockholmguide1;

import com.example.emiliaaxen.stockholmguide1.model.StockholmItem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by emiliaaxen on 16-03-25.
 */
public class StockholmItemTest {
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


        String expected = "Norrmalm/Vasastan";
        String actual = restaurantNeighborhood.getNeighborhood();
        assertEquals(expected, actual);

    }


    @Test
    public void TestIfAttractionNameIsCorrect(){
        StockholmItem attraction = new StockholmItem();
        attraction.setName("Djurgarden");


        String expected = "Djurgarden";
        String actual = attraction.getName();
        assertEquals(expected, actual);




    }

    @Test
    public void TestIfAttractionNeighborhoodIsCorrect(){
        StockholmItem restaurantNeighborhood = new StockholmItem();
        restaurantNeighborhood.setNeighborhood("Djurgarden");


        String expected = "Djurgarden";
        String actual = restaurantNeighborhood.getNeighborhood();
        assertEquals(expected, actual);

    }

    @Test
    public void TestIfShoppingNameIsCorrect(){
        StockholmItem shopping = new StockholmItem();
        shopping.setName("Mood");


        String expected = "Mood";
        String actual = shopping.getName();
        assertEquals(expected, actual);




    }

    @Test
    public void TestIfShoppingNeighborhoodIsCorrect(){
        StockholmItem shoppingNeighborhood = new StockholmItem();
        shoppingNeighborhood.setNeighborhood("Norrmalm/Vasastan");


        String expected = "Norrmalm/Vasastan";
        String actual = shoppingNeighborhood.getNeighborhood();
        assertEquals(expected, actual);

    }

    @Test
    public void TestIfHotelNameIsCorrect(){
        StockholmItem hotel = new StockholmItem();
        hotel.setName("Berns");


        String expected = "Berns";
        String actual = hotel.getName();
        assertEquals(expected, actual);




    }

    @Test
    public void TestIfHotelNeighborhoodIsCorrect(){
        StockholmItem hotelNeighborhood = new StockholmItem();
        hotelNeighborhood.setNeighborhood("Ostermalm");


        String expected = "Ostermalm";
        String actual = hotelNeighborhood.getNeighborhood();
        assertEquals(expected, actual);

    }


}


