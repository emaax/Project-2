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
        stockholmItems.addAll(getShoppingItems(context));
        stockholmItems.addAll(getHotelItems(context));


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

        StockholmItem sally = new StockholmItem();
        sally.setName(context.getString(R.string.sallyochsystrar_name));
        sally.setType(TYPE_RESTAURANTS);
        sally.setAddress("Klarabergsgatan 50, Stockholm");
        sally.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        sally.setDescription(context.getString(R.string.sallyochsystrar));
        sally.setImageResourceId(R.drawable.sally);

        StockholmItem flyingelk = new StockholmItem();
        flyingelk.setName(context.getString(R.string.flyingelk_name));
        flyingelk.setType(TYPE_RESTAURANTS);
        flyingelk.setAddress("Malartorget 15, Stockholm");
        flyingelk.setNeighborhood(context.getString(R.string.neighborhood_sodermalm));
        flyingelk.setDescription(context.getString(R.string.flyingelk));
        flyingelk.setImageResourceId(R.drawable.flying);

        StockholmItem snickarbacken = new StockholmItem();
        snickarbacken.setName(context.getString(R.string.snickarbacken_name));
        snickarbacken.setType(TYPE_RESTAURANTS);
        snickarbacken.setAddress("Snickarbacken 7, Stockholm");
        snickarbacken.setNeighborhood(context.getString(R.string.neighborhood_ostermalm));
        snickarbacken.setDescription(context.getString(R.string.snickarbacken));
        snickarbacken.setImageResourceId(R.drawable.snickarbacken);

        StockholmItem meatballs = new StockholmItem();
        meatballs.setName(context.getString(R.string.meatball_name));
        meatballs.setType(TYPE_RESTAURANTS);
        meatballs.setAddress("Nytorgsgatan 30, Stockholm");
        meatballs.setNeighborhood(context.getString(R.string.neighborhood_sodermalm));
        meatballs.setDescription(context.getString(R.string.meatball));
        meatballs.setImageResourceId(R.drawable.meatballs_for_the_people);

        StockholmItem sturehof = new StockholmItem();
        sturehof.setName(context.getString(R.string.sturehof_name));
        sturehof.setType(TYPE_RESTAURANTS);
        sturehof.setAddress("Stureplan 2, Stockholm");
        sturehof.setNeighborhood(context.getString(R.string.neighborhood_ostermalm));
        sturehof.setDescription(context.getString(R.string.sturehof));
        sturehof.setImageResourceId(R.drawable.sturehof);

        StockholmItem flippinburg = new StockholmItem();
        flippinburg.setName(context.getString(R.string.flippinburgers_name));
        flippinburg.setType(TYPE_RESTAURANTS);
        flippinburg.setAddress("Observatoriegatan 8, Stockholm");
        flippinburg.setNeighborhood(context.getString(R.string.neighborhood_norrmalmvasa));
        flippinburg.setDescription(context.getString(R.string.flippinburgers));
        flippinburg.setImageResourceId(R.drawable.flippinburgers);

        StockholmItem blaporten = new StockholmItem();
        blaporten.setName(context.getString(R.string.blaporten_name));
        blaporten.setType(TYPE_RESTAURANTS);
        blaporten.setAddress("Djurgardsvagen 64, Stockholm");
        blaporten.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        blaporten.setDescription(context.getString(R.string.blaporten));
        blaporten.setImageResourceId(R.drawable.bla_porten);

        StockholmItem urbandeli = new StockholmItem();
        urbandeli.setName(context.getString(R.string.urbandeli_name));
        urbandeli.setType(TYPE_RESTAURANTS);
        urbandeli.setAddress("Nytorget 4, Stockholm");
        urbandeli.setNeighborhood(context.getString(R.string.neighborhood_sodermalm));
        urbandeli.setDescription(context.getString(R.string.urbandeli));
        urbandeli.setImageResourceId(R.drawable.urbandeli);



        ArrayList<StockholmItem> restaurants = new ArrayList<>();

        restaurants.add(saturnus);
        restaurants.add(sally);
        restaurants.add(flyingelk);
        restaurants.add(snickarbacken);
        restaurants.add(meatballs);
        restaurants.add(sturehof);
        restaurants.add(flippinburg);
        restaurants.add(blaporten);
        restaurants.add(urbandeli);

        return restaurants;
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

    private static ArrayList<StockholmItem> getHotelItems(Context context){
        StockholmItem diplomat = new StockholmItem();
        diplomat.setName(context.getString(R.string.diplomat_name));
        diplomat.setType(TYPE_HOTELS);
        diplomat.setAddress("Strandvagen 7C, Stockholm");
        diplomat.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        diplomat.setDescription(context.getString(R.string.diplomat));
        diplomat.setImageResourceId(R.drawable.diplomat);

        StockholmItem grand = new StockholmItem();
        grand.setName(context.getString(R.string.grand_name));
        grand.setType(TYPE_HOTELS);
        grand.setAddress("Sodra Blasieholmshamnen 8, Stockholm");
        grand.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        grand.setDescription(context.getString(R.string.grand));
        grand.setImageResourceId(R.drawable.grandhotel);

        StockholmItem berns = new StockholmItem();
        berns.setName(context.getString(R.string.berns_name));
        berns.setType(TYPE_HOTELS);
        berns.setAddress("Nackstramsgatan 8, Stockholm");
        berns.setNeighborhood(context.getString(R.string.neighborhood_djurgarden));
        berns.setDescription(context.getString(R.string.berns));
        berns.setImageResourceId(R.drawable.berns);


        ArrayList<StockholmItem> hotels = new ArrayList<>();

        hotels.add(diplomat);
        hotels.add(grand);
        hotels.add(berns);

        return hotels;
    }
}

