package com.example.bryan.cabingameslist.retrofit;

import com.example.bryan.cabingameslist.model.CabinGamesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=2EaLfXw-husnYtzseAzsSsDmPayZR4GH_HdMEi4Sc14cUgFrh7nFrzJfZCUw63JRN" +
            "oUNVDjOG4ZdeBCTgvWOSd1aH5_j4CnYm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_nRPgeZU6HP9TFyHjmB_S7" +
            "NGfj2PgED1zh0lmODcuY_3RLTIQK4l0mSHMo5BUMYnY_v0qbk3Js6WQqE0Pgzm3YDQnTKXwhOBLzGIfsWzMa" +
            "0ErpUs8G9fuiQ&lib=Mbe01TOrTwKynuphANi9F6GvJhdhxLcHa")
    Call<List<CabinGamesModel>> getEvents();
}
