package com.example.bryan.cabingameslist.retrofit;

import com.example.bryan.cabingameslist.model.CabinVideosModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitVideosAPI {

    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=sScIVJhJ2EVwnS6LtTEkU-95CQQ_fwRHZAiCHL00k7vqfIvE6OntrOtsF0vxvxRjPp" +
            "tbEVVsyTN7P8W0gXdqZy4HfaKhfN_Um5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnPQ" +
            "7cmdW5JCPSIDcgKrKx2_ZbWIEjwdWpIQ3LQk8CDLYj21ogSBWGs8ERIoFL0chD6K9tCRF4Fvy&lib=MFgWwo" +
            "emiy8l_XkGNiVvUmGvJhdhxLcHa")
    Call<List<CabinVideosModel>> getEvents();
}
