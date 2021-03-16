import com.bridgelabz.hotelmanagement.Hotel;
import com.bridgelabz.hotelmanagement.HotelManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.bridgelabz.hotelmanagement.HotelManagement.*;

public class TestHotelManagement {
    HotelManagement hotelManagement;
    Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
    Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
    Hotel ridgewood = new Hotel("Ridgewood", 220 , 150, 5);
    @BeforeEach
    void setUp() {
        hotelManagement = new HotelManagement();
        hotelManagement.addHotel(lakewood);
        hotelManagement.addHotel(bridgewood);
        hotelManagement.addHotel(ridgewood);

    }

    @Test
    public void testAddHotel() {
        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

       hotels.forEach(hotel -> System.out.println("added in list: " + hotel));
    }

    @Test
    public void getCheapestHotelByRates() {
      Assertions.assertEquals(lakewood, getCheapHotelByRate());
      showCheapHotel();

    }

    @Test
    void getCheapestHotelByRatingsTest() {
       Hotel  cheapestHotelByRatings = HotelManagement.getCheapestHotelByRating();
       Assertions.assertEquals(bridgewood, cheapestHotelByRatings);
        System.out.println("Cheapest hotel by rating: " + cheapestHotelByRatings.hotelName);
    }
}
