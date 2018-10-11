package com.example.bryan.cabingameslist.retrofit;

import com.example.bryan.cabingameslist.model.CabinFriendsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitFriendsAPI {

    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=u5NPc0yzJ0TnYEi_jXiaEDq-w80aJbYlgMhJa90UlT39tJY5eXKkMyhRl6Vb249b" +
            "44L7XEcfRi7pHN_GZvkFbpMMYGI_G3Bcm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZ" +
            "EnOaJwfaXL8IPLmj6wex99uWKLhkWmKxL83vvWFQuLR-98Ifl4tNPFOIU9kkDPai226V-rV9yhQ38&lib=M" +
            "Twi5yEUZrIbxLvLmjqCYaz1fdgA3M0R2")
    Call<List<CabinFriendsModel>> getEvents();
}
