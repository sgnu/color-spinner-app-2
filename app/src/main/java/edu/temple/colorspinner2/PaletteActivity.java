package edu.temple.colorspinner2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    Spinner spinner;
    String[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = getResources().getStringArray(R.array.colors);

        spinner = findViewById(R.id.spinner);
        final ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, android.R.layout.simple_spinner_dropdown_item, colors);

        spinner.setAdapter(adapter);
        //  Prevent "selecting" the first option on initialization
        spinner.setSelection(0, false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent launchActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                String color = (String) adapter.getItem(position);

                //  Store key-value pair in the intent
                launchActivityIntent.putExtra("COLOR", color);
                startActivity(launchActivityIntent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public class ColorAdapter extends BaseAdapter {
        private Context context;
        private String[] objects;

        public ColorAdapter(Context context, int textViewResourceId, String[] objects) {
            this.context = context;
            this.objects = objects;
        }

        @Override
        public int getCount() {
            return this.objects.length;
        }

        @Override
        public Object getItem(int position) {
            return objects[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, parent, false);
            }
            CharSequence currentItem = (CharSequence) getItem(position);
            String color = (String) getItem(position);

            TextView textViewItemName = convertView.findViewById(R.id.text_view_item_name);
            textViewItemName.setText(currentItem);
            textViewItemName.setBackgroundColor(Color.parseColor(color));
            return convertView;
        }
    }
}
