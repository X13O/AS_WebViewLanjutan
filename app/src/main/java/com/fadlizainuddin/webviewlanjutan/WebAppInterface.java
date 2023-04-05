package com.fadlizainuddin.webviewlanjutan;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    private Activity _activity;
    private Context _context;

    public WebAppInterface(Context context, Activity activity) {
        _context = context;
        _activity = activity;
    }

    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(_context, message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showSms() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showEmail() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showKalkulator() {
        try
        {
            Intent kalkulatorIntent = new Intent(Intent.ACTION_MAIN);
            kalkulatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName("com.android.bbkcalculator", "com.android.bbkcalculator.Calculator");
            kalkulatorIntent.setComponent(cn);

            _context.startActivity(kalkulatorIntent);
        }
        catch (ActivityNotFoundException anfe)
        {
            Toast.makeText(_context.getApplicationContext(), "Aplikasi Tidak Ditemukan", Toast.LENGTH_SHORT).show();
        }
    }
}
