package com.tarkalabs.core.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.tarkalabs.base.R;

public class UiUtils {


    //----------------------------------- SnackBar and Toast  ---------------------------------------//

    public static void showSnackBar(View view, String message, int length) {
        Snackbar snackbar = Snackbar.make(view, message, length);
        View v = snackbar.getView();
        TextView textView = v.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setMaxLines(4);
        snackbar.show();
    }

    public static void showSnackBarWithAction(View view, int messageResId, int length,
                                              int actionResId, View.OnClickListener actionClickListener) {
        Snackbar snackbar = Snackbar.make(view, messageResId, length);
        View v = snackbar.getView();
        TextView textView = v.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setMaxLines(4);
        snackbar.setAction(actionResId, actionClickListener);
        snackbar.show();
    }

    public static void showSnackBarWithAction(View view, String message, int length, String action,
                                              View.OnClickListener actionClickListener) {
        Snackbar snackbar = Snackbar.make(view, message, length);
        View v = snackbar.getView();
        TextView textView = v.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setMaxLines(4);
        snackbar.setAction(action, actionClickListener);
        snackbar.show();
    }

    public static void showSnackBar(View view, int message, int length) {
        Snackbar snackbar = Snackbar.make(view, message, length);
        View v = snackbar.getView();
        TextView textView = v.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setMaxLines(4);
        snackbar.show();
    }

    public static void showToast(AppCompatActivity mActivity, String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static AlertDialog createAlertDialog(Context context, String title,
                                                String message, String buttonFirstText,
                                                DialogInterface.OnClickListener firstListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        if (!TextUtils.isEmpty(buttonFirstText)) {
            builder.setPositiveButton(buttonFirstText, firstListener);
        }

        DialogInterface.OnClickListener OnClickListener = (dialog, which) -> dialog.dismiss();
        builder.setNegativeButton("Cancel", OnClickListener);
        return builder.create();
    }

    public static AlertDialog createAlertDialogWithTwoButtons(Context context, String title,
                                                              String message, String buttonFirstText, String buttonSecondText,
                                                              DialogInterface.OnClickListener firstListener,
                                                              DialogInterface.OnClickListener secondListener) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonFirstText, firstListener)
                .setNegativeButton(buttonSecondText, secondListener)
                .create();
    }
}




