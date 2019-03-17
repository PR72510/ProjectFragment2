package com.example.projectfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    private static final String TAG = "MainActivity";
    TextView tvName, tvPhone;
    EditText etName, etPhone;
    Button btnAdd;
    ListFragment listFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_Phone);
        etName = findViewById(R.id.et_Name);
        etPhone = findViewById(R.id.et_Phone);
        btnAdd = findViewById(R.id.btn_add);

        fragmentManager = getSupportFragmentManager();
        listFragment = (ListFragment)fragmentManager.findFragmentById(R.id.frg_list);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter both Fields", Toast.LENGTH_LONG).show();
                }
                else{
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"Person added....", Toast.LENGTH_LONG).show();
                    etPhone.setText(null);
                    etName.setText(null);
                    listFragment.notifyDataChanged();
                }
            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        Log.i(TAG, "onItemClicked: ");
        tvName.setText(ApplicationClass.people.get(index).getName());
        tvPhone.setText(ApplicationClass.people.get(index).getTelNr());
    }

}
