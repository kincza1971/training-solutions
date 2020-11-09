package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Vad bölény étterem", 12);
        System.out.println(restaurant.getName() + ", " + restaurant.getCapacity());
        for (String menuItem : restaurant.getMenu()) {
            System.out.println(menuItem);
        }
    }
}
