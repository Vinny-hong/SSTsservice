package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;

/**
 * Created by sst on 12/21/2017.
 */

public class MenuFoodFragment extends Fragment {

    private String[] loginStrings;



    // method to get value form login screen
    public static MenuFoodFragment menuFoodInstance(String[] loginStrings) {
        MenuFoodFragment menuFoodFragment = new MenuFoodFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login",loginStrings);
        menuFoodFragment.setArguments(bundle);
        return menuFoodFragment;

    }

    //  get  value from  above
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //    get value from argument
        getValueFromFlagment();

        //  create toolbar
        createToolbar();

        // make listView by ctrl - alt - enter
        makeListview();


    }// Main Method

    private void makeListview() {
        ListView listView = getView().findViewById(R.id.listViewFood);
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMenuFoodFragment);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        // setup title and sub title
        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle(loginStrings[1]);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setSubtitle("Online");

    }

    private void getValueFromFlagment() {
        loginStrings = getArguments().getStringArray("Login");
        Log.d("21DecV1", "Name ==>" + loginStrings[1]);

    }

    // first
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_food, container, false);
        return view;

    }  // main override






} // main class
