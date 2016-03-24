package com.example.emiliaaxen.stockholmguide1.model;

import android.content.Context;

import com.example.emiliaaxen.stockholmguide1.R;

import java.util.ArrayList;

/**
 * Created by emiliaaxen on 16-03-18.
 */
public class StockholmItemsManager {

    //region Private Variables
    public static final String TYPE_RESTAURANTS = "Restaurants";
    public static final String TYPE_ATTRACTIONS = "Attractions";
    public static final String TYPE_SHOPPING = "Shopping";
    public static final String TYPE_HOTELS = "Hotels";

    /**
     * Returns a list of stockholm items
     *
     * @param context
     * @return
     */
    public static ArrayList<StockholmItem> getStockholmItems(Context context){
        ArrayList<StockholmItem> stockholmItems = new ArrayList<>();
        stockholmItems.addAll(getRestaurantItems(context));
        stockholmItems.addAll(getAttractionItems(context));
        stockholmItems.addAll(getHotelItems(context));
        stockholmItems.addAll(getShoppingItems(context));

        // add the rest of the types such as attractions, etc.

        return stockholmItems;
    }

    private static ArrayList<StockholmItem> getRestaurantItems(Context context){

        StockholmItem saturnus = new StockholmItem();
        saturnus.setName(context.getString(R.string.saturnus_name));
        saturnus.setType(TYPE_RESTAURANTS);
        saturnus.setAddress("Eriksbergsgatan 6, Stockholm");
        saturnus.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        saturnus.setDescription(context.getString(R.string.saturnus));
        saturnus.setImageResourceId(R.drawable.saturnus);

        // create the rest of the restaurant objects here

        ArrayList<StockholmItem> restaurants = new ArrayList<>();
        restaurants.add(saturnus);
        // add the rest of the restaurant objects here



        return restaurants;
    }

    private static ArrayList<StockholmItem> getHotelItems(Context context){
        StockholmItem diplomat = new StockholmItem();
        diplomat.setName(context.getString(R.string.diplomat_name);
        diplomat.setType(TYPE_HOTELS);
        diplomat.setAddress("Strandvagen 7C, Stockholm");
        diplomat.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        diplomat.setDescription(context.getString(R.string.diplomat));
        diplomat.setImageResourceId(R.drawable.diplomat);

        // create the rest of the hotels

        ArrayList<StockholmItem> hotels = new ArrayList<>();

        hotels.add(diplomat);

        // add the rest of hotel items to the hotel item list

        return hotels;
    }
    private static ArrayList<StockholmItem> getAttractionItems(Context context){

        StockholmItem nordicmuseum = new StockholmItem();
        nordicmuseum.setName(context.getString(R.string.nordic_museum_name));
        nordicmuseum.setType(TYPE_ATTRACTIONS);
        nordicmuseum.setAddress("Djurgarden, Stockholm");
        nordicmuseum.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        nordicmuseum.setDescription(context.getString(R.string.nordic_museum));
        nordicmuseum.setImageResourceId(R.drawable.nordiskamuseumet);

        StockholmItem djurgarden = new StockholmItem();
        djurgarden.setName(context.getString(R.string.djurgarden_name));
        djurgarden.setType(TYPE_ATTRACTIONS);
        djurgarden.setAddress("Djurgarden, Stockholm");
        djurgarden.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        djurgarden.setDescription(context.getString(R.string.djurgarden));
        djurgarden.setImageResourceId(R.drawable.djurgarden);

        StockholmItem oldTown = new StockholmItem();
        oldTown.setName(context.getString(R.string.old_town_name));
        oldTown.setType(TYPE_ATTRACTIONS);
        oldTown.setAddress("Old Town, Stockholm");
        oldTown.setNeighborhood("Old town");
        oldTown.setDescription(context.getString(R.string.old_town));
        oldTown.setImageResourceId(R.drawable.old_town);

        StockholmItem sthlmConsert = new StockholmItem();
        sthlmConsert.setName(context.getString(R.string.sthlm_concet_hall_name));
        sthlmConsert.setType(TYPE_ATTRACTIONS);
        sthlmConsert.setAddress("Hotorget, Stockholm");
        sthlmConsert.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        sthlmConsert.setDescription(context.getString(R.string.sthlm_concet_hall));
        sthlmConsert.setImageResourceId(R.drawable.sthlm_concert_hall);

        StockholmItem rosendal = new StockholmItem();
        rosendal.setName(context.getString(R.string.rosendal_name));
        rosendal.setType(TYPE_ATTRACTIONS);
        rosendal.setAddress("Rosendalsvagen 38, Stockholm");
        rosendal.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        rosendal.setDescription(context.getString(R.string.rosendal));
        rosendal.setImageResourceId(R.drawable.rosendal);

        ArrayList<StockholmItem> attractions = new ArrayList<>();

        attractions.add(nordicmuseum);
        attractions.add(djurgarden);
        attractions.add(oldTown);
        attractions.add(sthlmConsert);
        attractions.add(rosendal);

        // add the rest of hotel items to the hotel item list

        return attractions;
    }

    private static ArrayList<StockholmItem> getShoppingItems(Context context){

        StockholmItem ahlens = new StockholmItem();
        ahlens.setName(context.getString(R.string.ahlens_name));
        ahlens.setType(TYPE_SHOPPING);
        ahlens.setAddress("Klarabergsgatan 50, Stockholm");
        ahlens.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        ahlens.setDescription(context.getString(R.string.ahlens));
        ahlens.setImageResourceId(R.drawable.ahlens);

        StockholmItem mood = new StockholmItem();
        mood.setName(context.getString(R.string.mood_name));
        mood.setType(TYPE_SHOPPING);
        mood.setAddress("Regeringsgatan 48, Stockholm");
        mood.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        mood.setDescription(context.getString(R.string.mood));
        mood.setImageResourceId(R.drawable.mood_gallerian);

        StockholmItem nk = new StockholmItem();
        nk.setName(context.getString(R.string.nk_name));
        nk.setType(TYPE_SHOPPING);
        nk.setAddress("Hamngatan 18-20, Stockholm");
        nk.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        nk.setDescription(context.getString(R.string.nk));
        nk.setImageResourceId(R.drawable.nk);


        ArrayList<StockholmItem> shopping = new ArrayList<>();
        shopping.add(ahlens);
        shopping.add(mood);
        shopping.add(nk);

        return shopping;
    }
}

/*
 helper.addItem("Saturnus", TYPE_RESTAURANTS, "Eriksbergsgatan 6, Stockholm", "Norrmalm/Vasastan", getString(R.string.saturnus), R.drawable.saturnus);
        helper.addItem("Sally och Systrar", TYPE_RESTAURANTS, "Klarabergsgatan 50 Stockholm", "Norrmalm/Vasastan", getString(R.string.sallyochsystrar), R.drawable.sally);
        helper.addItem("Flying Elk", TYPE_RESTAURANTS, "Malartorget 15, Stockholm", "Sodermalm", getString(R.string.flyingelk), R.drawable.flying);
        helper.addItem("Snickarbacken", TYPE_RESTAURANTS, "Snickarbacken 7, Stockholm", "Ostermalm", getString(R.string.snickarbacken), R.drawable.snickarbacken);
        helper.addItem("Urban Deli", TYPE_RESTAURANTS, "Nytorget 4, Stockholm", "Sodermalm", getString(R.string.urbandeli), R.drawable.urbandeli);
        helper.addItem("Meatballs for the people", TYPE_RESTAURANTS, "Nytorgsgatan 30, Stockholm", "Sodermalm", getString(R.string.meatball), R.drawable.meatballs_for_the_people);
        helper.addItem("Sturehof", TYPE_RESTAURANTS, "Stureplan 2, Stockholm", "Ostermalm", getString(R.string.sturehof), R.drawable.sturehof);
        helper.addItem("Flipping Burger", TYPE_RESTAURANTS, "Observatoriegatan 8, Stockholm", "Norrmalm/Vasastan", getString(R.string.flippinburgers), R.drawable.flippinburgers);
        helper.addItem("Bla Porten", TYPE_RESTAURANTS, "Djurgardsvagen 64, Stockholm", "Djurgarden", getString(R.string.blaporten), R.drawable.bla_porten);

        helper.addItem("Nordic Museum", TYPE_ATTRACTIONS, "Djurgardsvagen 6-16, Stockholm", "Djurgarden", getString(R.string.nordic_museum), R.drawable.nordiskamuseumet);
        helper.addItem("Old Town", TYPE_ATTRACTIONS, "Old Town", "Old Town", getString(R.string.old_town), R.drawable.old_town);
        helper.addItem("Rosendal Palace ", TYPE_ATTRACTIONS, "Rosendalsvagen 38, Stockholm", "Djurgarden", getString(R.string.rosendal), R.drawable.rosendal);
        helper.addItem("Djurgarden", TYPE_ATTRACTIONS, "Djurgarden, Stockholm", "Djurgarden", getString(R.string.djurgarden), R.drawable.djurgarden);
        helper.addItem("Stockholm Consert Hall", TYPE_ATTRACTIONS, "Hotorget, Stockholm", "Hamngatan 18-20, Stockholm", getString(R.string.sthlm_concet_hall), R.drawable.sthlm_concert_hall);

        helper.addItem("Mood", TYPE_SHOPPING, "Regeringsgatan 48, Stockholm", "Norrmalm/Vasastan", getString(R.string.mood), R.drawable.mood_gallerian);
        helper.addItem("Ahlens", TYPE_SHOPPING, "Klarabergsgatan 50, Stockholm", "Norrmalm/Vasastan", getString(R.string.ahlens), R.drawable.ahlens);
        helper.addItem("NK", TYPE_SHOPPING, "Hamngatan 18-20, Stockholm", "Norrmalm/Vasastan", getString(R.string.nk), R.drawable.nk);

        helper.addItem("Hotel Diplomat", TYPE_HOTELS, "Strandvagen 7C, Stockholm", "Ostermalm", getString(R.string.diplomat), R.drawable.diplomat);
        helper.addItem("Grand Hôtel", TYPE_HOTELS, "Sodra Blasieholmshamnen 8, Stockholm", "Ostermalm", getString(R.string.grand), R.drawable.grandhotel);
        helper.addItem("Berns", TYPE_HOTELS, "Nackstramsgatan 8, Stockholm", "Ostermalm", getString(R.string.berns), R.drawable.berns);

*/