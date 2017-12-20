package sahatara.com.sstservice.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import sahatara.com.sstservice.R;
import sahatara.com.sstservice.utility.GetDataFromServer;
import sahatara.com.sstservice.utility.MyAlertDialog;
import sahatara.com.sstservice.utility.MyConstant;

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
        // Login Controller
        loginController();


    }

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    Initial edittext
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String userString = userEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
                    // have space
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    myAlertDialog.normalDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space)
                    );

                } else {
                    // no space  has data  for login
                    try {
                        String tag = "20DecV1";
                        MyConstant myConstant = new MyConstant();
                        MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                        GetDataFromServer getDataFromServer = new GetDataFromServer(getActivity());
                        getDataFromServer.execute(myConstant.getUrlGetUserString());

                        String jsonString = getDataFromServer.get();
                        Log.d(tag, "Json ==>" + jsonString);

                        boolean status = true;
                        String[] columnStrings = myConstant.getUserColumnStrings();
                        String[] loginString = new String[columnStrings.length];


                        JSONArray jsonArray = new JSONArray(jsonString);
                        for (int i=0; i<jsonArray.length();i+=1) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString(columnStrings[2]))) {
                                status = false;
                                for (int i1=0; i1<columnStrings.length; i1+=1) {
                                    loginString[i1] = jsonObject.getString(columnStrings[i1]);

                                }// for

                            }   // if
                        } // for


                    } catch (Exception e) {
                        e.printStackTrace();

                    }


                } // if

            }
        });

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



