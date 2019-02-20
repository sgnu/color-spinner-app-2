package edu.temple.colorspinner2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent receivedIntent = getIntent();

        //  Retrieve the key-value pair from PaletteActivity
        String color = receivedIntent.getStringExtra("COLOR");
        findViewById(R.id.constraint).setBackgroundColor(Color.parseColor(color));
    }
}
