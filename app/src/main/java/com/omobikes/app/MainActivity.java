package com.omobikes.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "OmoBikes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity starting");

        try {
            setContentView(R.layout.activity_main);
            Log.d(TAG, "Layout loaded");

            LinearLayout btnCycleFinder = findViewById(R.id.btn_cycle_finder);
            LinearLayout btnPartsFinder = findViewById(R.id.btn_parts_finder);

            if (btnCycleFinder == null) {
                Log.e(TAG, "btn_cycle_finder is NULL");
                Toast.makeText(this, "Layout error: btn_cycle_finder not found", Toast.LENGTH_LONG).show();
                return;
            }

            if (btnPartsFinder == null) {
                Log.e(TAG, "btn_parts_finder is NULL");
                Toast.makeText(this, "Layout error: btn_parts_finder not found", Toast.LENGTH_LONG).show();
                return;
            }

            Log.d(TAG, "Buttons found, attaching listeners");

            btnCycleFinder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Cycle Finder clicked");
                    Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                    intent.putExtra("file", "cycle_finder.html");
                    intent.putExtra("title", "Find a Cycle");
                    startActivity(intent);
                }
            });

            btnPartsFinder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Parts Finder clicked");
                    Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                    intent.putExtra("file", "cycle_parts_finder.html");
                    intent.putExtra("title", "Find Cycle Parts");
                    startActivity(intent);
                }
            });

            Log.d(TAG, "MainActivity ready");

        } catch (Exception e) {
            Log.e(TAG, "CRASH in MainActivity: " + e.getMessage(), e);
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
