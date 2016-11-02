package com.evolutiondso.www.exam1mac_client;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.evolutiondso.www.exam1mac_client.entities.Student;
import com.google.android.gms.common.api.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    String line, lista;
    ArrayList<Student> lista_students;

    //Llamar a OKHTTP y conectar para jalar los valores
    OkHttpClient con = new OkHttpClient();
//    String run(String url) throws IOException {
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Response response = con.newCall(request).execute();
//        return response.body().string();
//    }
    //-----------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Toast.makeText(this, "OnCreateViewOK", Toast.LENGTH_SHORT).show();
        //meteaLista();
        //getJSON();
    }



    public void login_user(View view) {
        Toast.makeText(this, "Click NEXUS7", Toast.LENGTH_SHORT).show();
        meteaLista();
        valida_Datos();
    }

    public void valida_Datos(){
        EditText userName = (EditText) findViewById(R.id.editTexttUserName);
        String usrName = userName.getText().toString();
        EditText pasCode = (EditText) findViewById(R.id.edittextPass);
        String pasw = pasCode.getText().toString();

                if(usrName.equals("test") && pasw.equals("12345")){

                    Toast.makeText(MainActivity.this, "Welcome: " + usrName, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivity.this, "Access Denied!", Toast.LENGTH_SHORT).show();
                }

    }


    public void meteaLista(){
        Toast.makeText(this, "Inicando actualización de lista.", Toast.LENGTH_SHORT).show();
        try {
            String myJson = run("http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8");
            Getstudent parser = new Getstudent();
            lista_students = parser.parseMagic(myJson);
            for (Student student: lista_students){
                Log.d(TAG, "Listado Estudiante: " +student);
            }
        } catch (IOException e) {
            Log.d(TAG, "Exception: " + e);
        }
        Toast.makeText(this, "Lista Actualizada", Toast.LENGTH_SHORT).show();
    }
    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = con.newCall(request).execute();
        return response.body().string();
    }


//Aqui es la tarea anterior
//    private void getJSON() {
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        Log.d(TAG, "building Json start: ");
//
//        StringBuilder result = new StringBuilder();
//        HttpURLConnection urlConnection = null;
//
//        try {
//            URL url = new URL("http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8");
//            urlConnection = (HttpURLConnection) url.openConnection();
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            //String line;
//            while ((line = reader.readLine()) != null)
//            {
//                result.append(line);
//                Log.d(TAG, "line: " +line);
//            }
//
//        }
//
//        catch (MalformedURLException e)
//        {
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "catchJSON : " + result.toString());
//        try
//        {
//            Gson gson = new Gson();
//            Type listType = new TypeToken<List<Student>>(){}.getType();
//            Student obj = gson.fromJson(result.toString(), listType);
//            //String lista = obj.getAge();
//            Log.d(TAG, "Result JSON: " + obj);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            Log.d(TAG, "Exception: " + e);
//        }
//
//    }

}
