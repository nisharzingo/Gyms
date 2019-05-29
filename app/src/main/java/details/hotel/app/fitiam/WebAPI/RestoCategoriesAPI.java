package details.hotel.app.fitiam.WebAPI;

import java.util.ArrayList;

import details.hotel.app.fitiam.Model.RestaurantCategories;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RestoCategoriesAPI {

    @GET("RestaurantCategories/GetAllCategoriesByRestaurantId/{RestaurantId}")
    Call<ArrayList<RestaurantCategories>> getCategoryByRestId(@Header("Authorization") String authKey, @Path("RestaurantId") int id);

}
