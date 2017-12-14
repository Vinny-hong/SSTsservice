package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sahatara.com.sstservice.R;

/**
 * Created by SST on 15/12/2560.
 */

public class RegisterFlagment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_register,container,false);

        return view;
    }


}  // Main class

