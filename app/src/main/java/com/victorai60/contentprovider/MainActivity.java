package com.victorai60.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cursor = getContentResolver().query(Uri.parse("content://" + TestContentProvider
                .AUTHORITY + "/" + TestContentProvider.PATH), null, null, null, null);
        if (cursor != null) {
            try {
                System.out.println(cursor.getCount());
                cursor.moveToFirst();
                System.out.println(cursor.getString(0));
            } finally {
                cursor.close();
            }
        }
    }
}
