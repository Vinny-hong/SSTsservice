package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sahatara.com.sstservice.R;

/**
 * Created by sst on 12/21/2017.
 */

public class DetailFragment extends Fragment{

    public static DetailFragment detailInstanc(String idString, String nameString,
                                               String catString, String imageString,
                                               String priceString, String detailString) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",idString);
        bundle.putString("Name",nameString);
        bundle.putString("Category",catString);
        bundle.putString("Image",imageString);
        bundle.putString("Price",priceString);
        bundle.putString("Detail",detailString);
        return detailFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }
} //Main Class
