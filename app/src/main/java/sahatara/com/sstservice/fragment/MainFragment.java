package sahatara.com.sstservice.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sahatara.com.sstservice.R;

/**
 * Created by SST on 15/12/2560.
 */


public class MainFragment extends Fragment{
    // method ทำงาน all activity

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Register Controller
        registerController();


    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               //  Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFlagment())
                        .addToBackStack(null)
                        .commit();

            } // onClick
        });
    }
    // main method


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



