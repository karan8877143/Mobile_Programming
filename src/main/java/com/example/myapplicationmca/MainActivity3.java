package com.example.myapplicationmca;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    TextView tvText;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        tvText = findViewById(R.id.tvText);
        btnClick = findViewById(R.id.btnClick);

        registerForContextMenu(tvText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_edit) {
            tvText.setTextColor(Color.RED);
            Toast.makeText(this, "Color Changed", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_delete) {
            tvText.setText("Long Press Me");
            tvText.setTextColor(Color.BLACK);
            Toast.makeText(this, "Reset Done", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.menu_exit) {
            Toast.makeText(this, "Exiting App", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Action");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }
}