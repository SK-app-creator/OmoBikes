package com.omobikes.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCycleFinder = findViewById(R.id.btn_cycle_finder);
        Button btnPartsFinder = findViewById(R.id.btn_parts_finder);

        btnCycleFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("file", "cycle_finder.html");
                intent.putExtra("title", "Find a Cycle");
                startActivity(intent);
            }
        });

        btnPartsFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("file", "cycle_parts_finder.html");
                intent.putExtra("title", "Find Cycle Parts");
                startActivity(intent);
            }
        });
    }
}
