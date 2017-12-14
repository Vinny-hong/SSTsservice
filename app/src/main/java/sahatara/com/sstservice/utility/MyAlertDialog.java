package sahatara.com.sstservice.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import sahatara.com.sstservice.R;

/**
 * Created by SST on 14/12/2560.
 */

public class MyAlertDialog {

    private Context context;
    // construcetor
    public MyAlertDialog(Context context) {
        this.context = context;
    }

    public void normalDialog(String titleString,
                             String messageString) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // undo ใช้งานไม่ได้ ชั่วคราว
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });

        builder.show();

        }


} // Main class
