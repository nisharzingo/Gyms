package details.hotel.app.fitiam.WebAPI;

import details.hotel.app.fitiam.Model.Service;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST("Services")
    Call<Service> addService(@Header("Authorization") String authKey, @Body Service service);
}
