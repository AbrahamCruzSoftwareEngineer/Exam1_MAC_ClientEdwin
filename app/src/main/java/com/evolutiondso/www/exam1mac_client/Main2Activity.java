package com.evolutiondso.www.exam1mac_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.evolutiondso.www.exam1mac_client.entities.Student;

import java.util.jar.Attributes;

import static com.evolutiondso.www.exam1mac_client.MainActivity.*;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtviewname = (TextView) findViewById(R.id.a_secondact_tv_name);
        TextView txtviewage = (TextView) findViewById(R.id.a_secondact_tv_age);
        TextView txtviewgrade = (TextView) findViewById(R.id.a_secondact_tv_grade);
        Intent intent = getIntent();
        txtviewname.setText(intent.getStringExtra(kName));
        txtviewage.setText(intent.getStringExtra(kAge));
        txtviewgrade.setText(intent.getStringExtra(kGrade));


    }

    public void backtomain1(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
