package sahatara.com.sstservice.utility;

/**
 * Created by sst on 12/19/2017.
 */

public class MyConstant {

    //    About URL
    private String urlPostUserString = "http://androidthai.in.th/sst/addDataVinny.php";

    private String urlGetUserString = "http://androidthai.in.th/sst/getAllDataVinny.php";

    //    About array
    private String[] userColumnStrings = new String[]{"id", "Name", "User", "Password"};

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
