package com.puzzle4kids.mysimpleapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    RecyclerView recycl;
    ArrayList<StudentData> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        recycl = findViewById(R.id.recycl);

        RequestQueue requestQueue = Volley.newRequestQueue(DataActivity.this);
        String url = "http://adkkda34.atwebpages.com/show_student_list.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("abhay", response);
                Toast.makeText(DataActivity.this, "In Response", Toast.LENGTH_SHORT).show();

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    if (jsonArray.length() > 0) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String s_id = jsonObject.getString("s_id");
                            String s_name = jsonObject.getString("s_name");
                            String s_email = jsonObject.getString("s_email");
                            String s_gender = jsonObject.getString("s_gender");
                            String s_dob = jsonObject.getString("s_dob");
                            String s_addr = jsonObject.getString("s_addr");
                            String s_contact = jsonObject.getString("s_contact");
                            String p_contact = jsonObject.getString("p_contact");
                            String s_enrlno = jsonObject.getString("s_enrlno");
                            String s_spid = jsonObject.getString("s_spid");
                            String s_grno = jsonObject.getString("s_grno");
                            String s_rollno = jsonObject.getString("s_rollno");
                            String s_sem = jsonObject.getString("s_sem");
                            String s_div = jsonObject.getString("s_div");
                            String s_photo = jsonObject.getString("s_photo");

                            StudentData studentData = new StudentData(s_id,s_name,s_email,s_gender,s_dob,s_addr,s_contact,p_contact,s_enrlno,s_spid,s_grno,s_rollno,s_sem,s_div,s_photo);
                            arrayList.add(studentData);
                        }

                        recycleData data = new recycleData(DataActivity.this,arrayList);
                        recycl.setAdapter(data);

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DataActivity.this,RecyclerView.VERTICAL,false);
                        recycl.setLayoutManager(linearLayoutManager);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DataActivity.this, "Error chhe", Toast.LENGTH_SHORT).show();
                Log.e("abhay1", "" + error);
            }
        });
        requestQueue.add(stringRequest);
    }
}