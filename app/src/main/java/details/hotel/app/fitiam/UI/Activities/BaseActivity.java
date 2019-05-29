package details.hotel.app.fitiam.UI.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import details.hotel.app.fitiam.Model.HotelContacts;
import details.hotel.app.fitiam.R;
import details.hotel.app.fitiam.UI.Fragments.GalleryRowFragment;
import details.hotel.app.fitiam.UI.Fragments.HomeScreenFragment;
import details.hotel.app.fitiam.UI.Fragments.MoreFragment;
import details.hotel.app.fitiam.UI.Fragments.RoomCategoryFragment;
import details.hotel.app.fitiam.Utils.Constants;
import details.hotel.app.fitiam.Utils.PreferenceHandler;
import details.hotel.app.fitiam.Utils.ThreadExecuter;
import details.hotel.app.fitiam.Utils.Util;
import details.hotel.app.fitiam.WebAPI.HotelsDetailsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    fragment = new HomeScreenFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new GalleryRowFragment();
                    break;
                case R.id.navigation_notifications:
                    fragment = new RoomCategoryFragment();
                    break;
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    break;

            }
            return loadFragment(fragment);
        }
    };

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.hotel_fragment_view, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{

            setContentView(R.layout.activity_base);

           /* getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
            setTitle("Hotel Penthouse");

            loadFragment(new HomeScreenFragment());

            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            getHotelContact(Constants.HOTEL_DATA_ID);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void getHotelContact(final int id){



        new ThreadExecuter().execute(new Runnable() {
            @Override
            public void run() {
                //String auth_string = Util.getToken(getActivity());
                String auth_string = "Basic TW9obmlBdmQ6ODIyMDgxOTcwNg==";
                HotelsDetailsAPI apiService = Util.getClient().create(HotelsDetailsAPI.class);
                Call<ArrayList<HotelContacts>> call = apiService.getConatctByHotelId(auth_string,id);

                call.enqueue(new Callback<ArrayList<HotelContacts>>() {
                    @Override
                    public void onResponse(Call<ArrayList<HotelContacts>> call, Response<ArrayList<HotelContacts>> response) {
//                List<RouteDTO.Routes> list = new ArrayList<RouteDTO.Routes>();
                        int statusCode = response.code();
                        if (statusCode == 200) {


                            ArrayList<HotelContacts> hotelDetails =  response.body();

                            if(hotelDetails != null&&hotelDetails.size()!=0)
                            {
                                HotelContacts dto = hotelDetails.get(0);

                                if(dto!=null){

                                    String whatsappNumber =dto.getHotelPhone();
                                    PreferenceHandler.getInstance(BaseActivity.this).setWhatsappNUmber(whatsappNumber);
                                    PreferenceHandler.getInstance(BaseActivity.this).setEmailList(dto.getEmailList());
                                    //PreferenceHandler.getInstance(HotelOptionsScreen.this).setEmail(dto.get());

                                }
                            }
                        }else {

                            //Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<HotelContacts>> call, Throwable t) {

                        Log.e("TAG", t.toString());
                    }
                });
            }


        });
    }

}
