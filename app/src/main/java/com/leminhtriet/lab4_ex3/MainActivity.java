package com.leminhtriet.lab4_ex3;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvPhones;
    private List<Phone> phones = new ArrayList<>();
    private Button btnRemoveAll;
    private Button btnRemoveSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind UI controls to Java objects
        lvPhones = findViewById(R.id.listview_phone);
        btnRemoveAll = findViewById(R.id.btn_remove_all);
        btnRemoveSelected = findViewById(R.id.btn_remove_selected);

        generateRandomItems();

        final PhoneArrayAdapter phoneArrayAdapter = new PhoneArrayAdapter(this,
                R.layout.list_row, phones);
        lvPhones.setAdapter(phoneArrayAdapter);

        btnRemoveAll.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                phones.clear();
                phoneArrayAdapter.notifyDataSetChanged();
            }
        });

        btnRemoveSelected.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Phone phone : phones) {
                    if (phone.isSelected()) {
                        phone.setSelected(true);
                    }
                }
                phoneArrayAdapter.notifyDataSetChanged();
            }
        });
    }
    private void generateRandomItems() {
        phones.add(new Phone("Samsung Galaxy S23 512GB Blue", true));
        phones.add(new Phone("Samsung Galaxy S23 512GB Red", true));
        phones.add(new Phone("Samsung Galaxy S23 512GB Vivamagenta", true));
        phones.add(new Phone("Samsung Galaxy S23 512GB Luxury-Black", true));
    }
}
