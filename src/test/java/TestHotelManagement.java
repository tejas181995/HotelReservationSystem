import com.bridgelabz.hotelmanagement.Hotel;
import com.bridgelabz.hotelmanagement.HotelManagement;
import com.bridgelabz.hotelmanagement.InvalidDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.bridgelabz.hotelmanagement.HotelManagement.*;

public class TestHotelManagement {
    HotelManagement hotelManagement;
    Hotel lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
    Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
    Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);

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
    public void getCheapestHotelByRatesRegular() throws InvalidDataException {
        Assertions.assertEquals(lakewood, getCheapHotelByRate(Hotel.REGULAR_CUSTOMER));
        showCheapHotel(Hotel.REGULAR_CUSTOMER);

    }

    @Test
    public void getCheapestHotelByRatingsRegularTest() throws InvalidDataException {
        Hotel cheapestHotelByRatings = HotelManagement.getCheapestHotelByRating(Hotel.REGULAR_CUSTOMER);
        Assertions.assertEquals(bridgewood, cheapestHotelByRatings);
        System.out.println("Cheapest hotel by rating: " + cheapestHotelByRatings.hotelName);
    }

    @Test
    public void getBestRatedHotelRegularTest() throws InvalidDataException {
        Assertions.assertEquals(ridgewood, getBestRatedHotel());
        System.out.println("Best rated Hotel: " + getBestRatedHotel().hotelName + "  total Rate:  " + getTotalRates(getBestRatedHotel(), Hotel.REGULAR_CUSTOMER));
    }

    @Test
    void getCheapestHotelByrateSpecialTest() throws InvalidDataException {
        Assertions.assertEquals(lakewood, getCheapHotelByRate(Hotel.LOYAL_CUSTOMER));
        showCheapHotel(Hotel.LOYAL_CUSTOMER);
    }

    @Test
    public void invalidCustomerTypeTest1() throws InvalidDataException {
        Assertions.assertThrows(InvalidDataException.class, ()->{getCheapHotelByRate(3);} );
    }

    @Test
    void cheapestBestratedHotelSpecialCustTest() throws InvalidDataException {
        Assertions.assertEquals(ridgewood, getCheapestHotelByRating(Hotel.LOYAL_CUSTOMER));
        showCheapHotel(Hotel.LOYAL_CUSTOMER);
    }

    @Test
    void cheapestHotelForGivenDateValidation() throws InvalidDataException {
        Assertions.assertDoesNotThrow(()-> setDate("2020-09-11", "2020-09-12"));
        Assertions.assertEquals(bridgewood, getCheapestHotelByRating(Hotel.REGULAR_CUSTOMER));
    }

    @Test
    void cheapestHotelForGivenDateValidationInvalidInput()  {

        Assertions.assertThrows(InvalidDataException.class ,() ->{setDate("2020-09-11", "2020-13-13");});
    }
}