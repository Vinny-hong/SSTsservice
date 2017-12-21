package sahatara.com.sstservice.utility;

/**
 * Created by sst on 12/19/2017.
 */

public class MyConstant {

    //    About URL
    private String urlPostUserString = "http://androidthai.in.th/sst/addDataVinny.php";

    private String urlGetUserString = "http://androidthai.in.th/sst/getAllDataVinny.php";

    private String urlGetFoodString = "http://androidthai.in.th/sst/getAllFoodVinny.php";



    //    About array
    private String[] userColumnStrings = new String[]{"id", "Name", "User", "Password"};

    private String[] foodColumnStrings = new String[]{
            "id", "Category", "BarCode", "QRcode", "NameFood", "Price", "Detail", "ImagePath"     };


    public String[] getFoodColumnStrings() {
        return foodColumnStrings;
    }



    // alt + ins  create  getter
    public String getUrlGetFoodString() {
        return urlGetFoodString;

    }


    //  alt - insert

    public String[] getUserColumnStrings() {
        return userColumnStrings;
    }




    public String getUrlGetUserString() {

        return urlGetUserString;
    }

    // bring to use outside

    public String getUrlPostUserString() {


        return urlPostUserString;
    }
} //Main class
