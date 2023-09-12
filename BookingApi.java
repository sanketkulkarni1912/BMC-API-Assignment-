package io.github.api;

import io.github.api.payload.BookingRequestPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.github.util.ApiEndpoints.BASE_URL;
import static io.github.util.ApiEndpoints.BOOKING_ENDPOINT;
import static io.restassured.RestAssured.given;

/**
 * @author 
 */
public final class BookingApi {
    private static final String ENDPOINT = BASE_URL + BOOKING_ENDPOINT;
    private static final String MEDIA_TYPE_JSON = "application/json";

    private BookingApi() {}

    public static Response getAllBookingIds() {
        return given().when().get(ENDPOINT);
    }

    public static Response getBookingIdsByName(String firstName, String lastName) {
        return given().param("firstname", firstName)
                .param("lastname", lastName)
                .when()
                .get(ENDPOINT);
    }

    public static Response getBookingIdsByDate(String checkin, String checkout) {
        return given().param("checkin", checkin).param("checkout", checkout).when().get(ENDPOINT);
    }

    public static Response getBookingById(int id) {
        return given().accept(MEDIA_TYPE_JSON).when().get(ENDPOINT + id);
    }

    public static Response createBooking(BookingRequestPayload bookingRequestPayload) {
        return given().contentType(ContentType.JSON)
                .accept(MEDIA_TYPE_JSON)
                .body(bookingRequestPayload)
                .when()
                .post(ENDPOINT);
    }

    public static Response updateBooking(
            BookingRequestPayload bookingRequestPayload, int id, String authToken) {
        return given().contentType(ContentType.JSON)
                .accept(MEDIA_TYPE_JSON)
                .header("Cookie", "token=" + authToken)
                .body(bookingRequestPayload)
                .when()
                .put(ENDPOINT + id);
    }

   
    public static Response deleteBooking(int id, String authToken) {
        return given().header("Cookie", "token=" + authToken).when().delete(ENDPOINT + id);
    }
}
