import com.bridgelabz.hotelmanagement.Hotel;
import com.bridgelabz.hotelmanagement.HotelManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.bridgelabz.hotelmanagement.HotelManagement.hotels;

public class TestHotelManagement {
    HotelManagement hotelManagement;
    Hotel lakewood = new Hotel("Lakewood", 110, 90);
    Hotel bridgewood = new Hotel("Bridgewood", 150, 50);
    Hotel ridgewood = new Hotel("Ridgewood", 220 , 150);
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
    void getcheapestHotel() {
        long rate = hotelManagement.getCheapHotel(LocalDate.parse("2020-10-10"), LocalDate.parse("2020-10-11"));
        Assertions.assertEquals(220, rate);

    }
}
