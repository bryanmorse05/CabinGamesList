package com.example.bryan.cabingameslist.retrofit;

import com.example.bryan.cabingameslist.model.CabinVideosModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitVideosAPI {

    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=gsQSb8tUQZtYGuPrGEOHI3KsYBM_lRVci1Sb6NCyIgClUjw1jsMPqPIGAuzMORf8D" +
            "RUsJjOfFOGuDX1hMq2pOAOOPQcLKNNlm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_b2Dq9eF5uigZ_-Lj-k0R1" +
            "gcGbRE54Gfy1X4897iSixY_M-lB5ZIpTxy_Fx8x2sh9WFaaLr9SclXYRPfsmnsUskPBynGya1R3JdlQmsvQW" +
            "IfarLW7DyvvFg&lib=MFgWwoemiy8l_XkGNiVvUmGvJhdhxLcHa")
    Call<List<CabinVideosModel>> getEvents();
}
