package sahatara.com.sstservice.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sahatara.com.sstservice.R;

/**
 * Created by sst on 12/21/2017.
 */

public class FoodAdapter   extends BaseAdapter {

    private Context context;
    private String[] iconStrings, nameFoodStrings, priceFoodStrings;

    // make constructor  alt - ins
    public FoodAdapter(Context context,
                       String[] iconStrings,
                       String[] nameFoodStrings,
                       String[] priceFoodStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.nameFoodStrings = nameFoodStrings;
        this.priceFoodStrings = priceFoodStrings;
    }

    @Override
    public int getCount() {
        return nameFoodStrings.length;  // get items record count
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_menu_food, viewGroup, false);

        //  initial view
        ImageView imageView = view1.findViewById(R.id.imvIcon);
        TextView nameFoodTextView = view1.findViewById(R.id.txtNameFood);
        TextView priceFoodTextView = view1.findViewById(R.id.txtPriceFood);

        // show view
        nameFoodTextView.setText(nameFoodStrings[i]);
        priceFoodTextView.setText(priceFoodStrings[1]+ " THB.");

        Picasso.with(context).load(iconStrings[i]).into(imageView);



        return view1;
    }
} // main class
