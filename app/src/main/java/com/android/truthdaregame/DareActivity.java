package com.android.truthdaregame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class DareActivity extends AppCompatActivity {
    private ArrayList<TruthItem> truthList;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson = new Gson();
    String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values);
        selectedCategory = getIntent().getStringExtra("selectedCategory");
        sharedPreferences = getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        TextView txtCat = findViewById(R.id.txCategoryName);
        txtCat.setText(selectedCategory);
        truthList = new ArrayList<>();

        recyclerViewConfig();
        populateDefaultData();

        if (sharedPreferences.contains("UserDares"))
            populateUserData(sharedPreferences.getString("UserDares", null));

        findViewById(R.id.ivBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.ivAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

//    public void populateDefaultData() {
//        Values values = new Values();
//        for (int i = 0; i < values.dares.length; i++)
//            truthList.add(new TruthItem(values.dares[i].getmText(), selectedCategory));
//    }
//
//    public void populateUserData(String jsonDares) {
//        String[] dares = gson.fromJson(jsonDares, String[].class);
//        for (String dare : dares) truthList.add(new TruthItem(dare, selectedCategory));
//    }

    public void populateDefaultData() {
        Values values = new Values();
        for (TruthItem truth : values.dares) {
            if (truth.getmCategory().equals(selectedCategory)) {
                truthList.add(truth);
            }
        }
    }

    public void populateUserData(String jsonTruths) {
        TruthItem[] truths = gson.fromJson(jsonTruths, TruthItem[].class);
        for (TruthItem truth : truths) {
            if (truth.getmCategory().equals(selectedCategory)) {
                truthList.add(truth);
            }
        }
    }

    public void recyclerViewConfig() {
        // config for RV
        recyclerView = findViewById(R.id.recyclerView);

        //performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new TruthAdapter(truthList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog_box);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // setup buttons
        final EditText input = dialog.findViewById(R.id.editText);
        Button dismiss = dialog.findViewById(R.id.dismiss);
        Button add = dialog.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mText = input.getText().toString();
                if (mText.isEmpty())
                    Toast.makeText(getApplicationContext(), "Empty Text", Toast.LENGTH_LONG).show();
                else {
                    updateUserData(mText, selectedCategory);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

//    public void updateUserData(String string) {
//        ArrayList<String> textList = new ArrayList<>();
//
//        if (sharedPreferences.contains("UserDares")) {
//            String jsonDares = sharedPreferences.getString("UserDares", null);
//            String[] dares = gson.fromJson(jsonDares, String[].class);
//            for (int i = 0; i < dares.length; i++)
//                textList.add(dares[i]);
//        }
//
//        textList.add(string);
//        editor.putString("UserDares", gson.toJson(textList));
//        editor.apply();
//        truthList.add(new TruthItem(string, selectedCategory));
//    }

    public void updateUserData(String string, String category) {
        ArrayList<TruthItem> truthItemList = new ArrayList<>();

        // Retrieve existing user data
        if (sharedPreferences.contains("UserDares")) {
            String jsonDares = sharedPreferences.getString("UserDares", null);
            TruthItem[] dares = gson.fromJson(jsonDares, TruthItem[].class);
            if (dares != null) {
                truthItemList.addAll(Arrays.asList(dares));
            }
        }

        // Create a new TruthItem with the provided text and category
        TruthItem newTruthItem = new TruthItem(string, category);
        truthItemList.add(newTruthItem);

        // Save the updated user data
        editor.putString("UserDares", gson.toJson(truthItemList));
        editor.apply();

        // Add the new TruthItem to the displayed list
        truthList.add(newTruthItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//
//        if (item.getItemId() == R.id.action_add) {//TODO: add
//            showDialog();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finish();
    }
}