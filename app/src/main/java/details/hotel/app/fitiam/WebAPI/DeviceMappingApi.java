package details.hotel.app.fitiam.WebAPI;

import details.hotel.app.fitiam.Model.DeviceMapping;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DeviceMappingApi {

    @POST("AgentDeviceMappings")
    Call<DeviceMapping> addProfileMap(@Body DeviceMapping body);
}
