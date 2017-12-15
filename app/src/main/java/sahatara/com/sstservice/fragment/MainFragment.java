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


public class MainFragment extends Fragment{
    // new method
    @Nullable
    @Override
    // หน้ากาก UI  view  has 3  will return value
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // สร้างบ่าน
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
        }

        // add activity

}  // Main Class ทำหร้าที่ fragment



