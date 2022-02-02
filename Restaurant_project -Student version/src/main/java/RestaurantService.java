import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        Restaurant rest = null;
        for(Restaurant restaurant: restaurants) {
            if(restaurant.getName().equals(restaurantName))
                rest = restaurant;
            break;
        }
        if(rest == null){
            throw new restaurantNotFoundException(restaurantName);
        }
        return rest;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved != null){
            restaurants.remove(restaurantToBeRemoved);
        }else{
            throw new restaurantNotFoundException(restaurantName);
        }
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
