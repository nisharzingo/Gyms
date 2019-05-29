package details.hotel.app.fitiam.WebAPI;

import java.util.ArrayList;

import details.hotel.app.fitiam.Model.Amenities;
import details.hotel.app.fitiam.Model.PaidAmenities;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface PaidAmenitiesAPI {

    @GET("Hotels/GetPaidAmenitiesByHotelId/{HotelId}")
    Call<ArrayList<PaidAmenities>> getPaidAmenitiesByHotelId(@Header("Authorization") String authKey, @Path("HotelId") int id);

    @GET("Hotels/GetAmenitiesByHotelId/{HotelId}")
    Call<ArrayList<Amenities>> getAmenitiesByHotelId(@Header("Authorization") String authKey, @Path("HotelId") int id);

}
