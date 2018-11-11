package com.rainy.bryan.cabingameslist.retrofit;

import com.rainy.bryan.cabingameslist.model.CabinGamesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitGamesAPI {

    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=EeFxOQ-SWGJC_IgCV4ICvNVcW-3EgHiVFIjQBs_q1DJJyD4p7dpiPmmxIUFi18rS" +
            "A4c0J6T7jOSsK3HanBqzijm4NZjunt7Gm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZ" +
            "EnE4_fx7_qU5tibfjg0WGl_fkKZzoSFSy8LwOitbmog99_3I3aivIlwtO93jeyqr89xGMOj2A9q7o&lib=" +
            "Mbe01TOrTwKynuphANi9F6GvJhdhxLcHa")
    Call<List<CabinGamesModel>> getEvents();
}
