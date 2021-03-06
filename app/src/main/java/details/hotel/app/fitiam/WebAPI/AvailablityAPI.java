package details.hotel.app.fitiam.WebAPI;

import java.util.ArrayList;

import details.hotel.app.fitiam.Model.AvailabiltyCheckGetData;
import details.hotel.app.fitiam.Model.AvailabiltyCheckPostData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by ZingoHotels Tech on 11-12-2018.
 */

public interface AvailablityAPI {

    @POST("Agent/GetAvailabilityOfCategoryBetweenDatesOfParticularHotel")
    Call<ArrayList<AvailabiltyCheckGetData>> checkAvailablityofHotel(@Header("Authorization") String authKey, @Body AvailabiltyCheckPostData body);

}
