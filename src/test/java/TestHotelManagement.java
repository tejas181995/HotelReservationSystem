import com.bridgelabz.hotelmanagement.Hotel;
import com.bridgelabz.hotelmanagement.HotelManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.bridgelabz.hotelmanagement.HotelManagement.hotels;

public class TestHotelManagement {
    HotelManagement hotelManagement;
    Hotel lakewood = new Hotel("Lakewood", 110);
    Hotel bridgewood = new Hotel("Bridgewood", 150);
    Hotel ridgewood = new Hotel("Ridgewood", 220 );
    @BeforeEach
    void setUp() {
        hotelManagement = new HotelManagement();
    }

    @Test
    public void testAddHotel() {
        hotelManagement.addHotel(lakewood);
        hotelManagement.addHotel(bridgewood);
        hotelManagement.addHotel(ridgewood);
        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

        hotels.forEach(hotel -> System.out.println("added in list: " + hotel));
    }
}
