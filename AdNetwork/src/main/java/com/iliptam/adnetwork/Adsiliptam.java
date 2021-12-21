package com.iliptam.adnetwork;

import static com.iliptam.adnetwork.utils.Global.check;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.iliptam.adnetwork.interfaces.OnInitializationCompleteListener;
import com.iliptam.adnetwork.utils.Global;
import com.iliptam.adnetwork.utils.PrefManager;
import com.iliptam.adnetwork.viewmodels.AdsViewModel;
import com.iliptam.adnetwork.viewmodels.CmpViewModel;

import java.util.ArrayList;
import java.util.List;


public class Adsiliptam {

    public static OnInitializationCompleteListener completeListener;
    public static Context mcontext;
    public static CmpViewModel cmpViewModel;
    public static PrefManager prefManager;

    public static void initialize(Context context, String key, String url, int loadSeconds, OnInitializationCompleteListener listener) {
        completeListener = listener;
        mcontext = context;
        Global.CAT_ID = key;
        Global.API_URL = url;
        Global.IMAGE_URL = url + "uploads/";

        prefManager = new PrefManager(mcontext);

        cmpViewModel = new ViewModelProvider((ViewModelStoreOwner) mcontext).get(CmpViewModel.class);

        if (Global.isConnectedToInternet(mcontext)) {
            if (check(mcontext, loadSeconds)) {
                DataFromServer();
            } else {
                if (!prefManager.getBoolean("INIT")) {
                    DataFromServer();
                }
            }
        }
    }

    private static void DataFromServer() {
        cmpViewModel.LoadFromServer("", completeListener);
    }

}
