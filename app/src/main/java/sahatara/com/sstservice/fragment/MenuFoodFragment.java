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
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;
import sahatara.com.sstservice.utility.FoodAdapter;
import sahatara.com.sstservice.utility.GetDataFromServer;
import sahatara.com.sstservice.utility.MyConstant;

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
        createListview();


    }// Main Method

    private void createListview() {
        ListView listView = getView().findViewById(R.id.listViewFood);
        MyConstant myConstant = new MyConstant();
        String tag = "21DecV1";
        String[] columnStrings = myConstant.getFoodColumnStrings();

        try {

            GetDataFromServer getDataFromServer = new GetDataFromServer(getContext());
            getDataFromServer.execute(myConstant.getUrlGetFoodString());
            String jsonString = getDataFromServer.get();
            Log.d(tag, "JSON ==>" + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);

            final String[] idStrings = new String[jsonArray.length()];
            final String[] categoryStrings = new String[jsonArray.length()];
            String[] barodeStrings = new String[jsonArray.length()];
            String[] qrcodeStrings = new String[jsonArray.length()];
            final String[] nameFoodStrings = new String[jsonArray.length()];
            final String[] priceStrings = new String[jsonArray.length()];
            final String[] detailStrings = new String[jsonArray.length()];
            final String[] imagePathStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                idStrings[i] = jsonObject.getString(columnStrings[0]);
                categoryStrings[i] = jsonObject.getString(columnStrings[1]);
                barodeStrings[i] = jsonObject.getString(columnStrings[2]);
                qrcodeStrings[i] = jsonObject.getString(columnStrings[3]);
                nameFoodStrings[i] = jsonObject.getString(columnStrings[4]);
                priceStrings[i] = jsonObject.getString(columnStrings[5]);
                detailStrings[i] = jsonObject.getString(columnStrings[6]);
                imagePathStrings[i] = jsonObject.getString(columnStrings[7]);

            }  //  for

            FoodAdapter foodAdapter = new FoodAdapter(getActivity(), imagePathStrings,
                    nameFoodStrings, priceStrings);
            listView.setAdapter(foodAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentMainFragment,
                            DetailFragment.detailInstance(idStrings[i], nameFoodStrings[i], categoryStrings[i],imagePathStrings[i],
                                    priceStrings[i],
                                    detailStrings[i]))
                            .addToBackStack(null).
                            commit();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMenuFoodFragment);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        // setup title and sub title
        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle(loginStrings[1]);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setSubtitle("Online Now");

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
