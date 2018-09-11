package com.example.bryan.cabingameslist.retrofit;

import com.example.bryan.cabingameslist.model.CabinGamesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("echo?user_content_key=U4GWFQ5l_WClYNaWUc0vl6_VnTiE9IA7DD9DMsIGBqGNNZeeZJGS_qrNm10Ix2oh4K9G" +
            "ypNCTh8jjpRIN4DZjIOR5Oa2Z9Grm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_nRPgeZU6HP9TFyHjmB_S7NGfj2PgE" +
            "D1zh0lmODcuY_3RLTIQK4l0mSHMo5BUMYnY_v0qbk3Js6WQqE0Pgzm3YDQnTKXwhOBLzGIfsWzMa0ErpUs8G9fu" +
            "iQ&lib=Mbe01TOrTwKynuphANi9F6GvJhdhxLcHa")
    Call<List<CabinGamesModel>> getEvents();
}
