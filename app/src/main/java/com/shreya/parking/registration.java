package com.shreya.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parking.connection.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class registration extends AppCompatActivity {

     EditText Name, Email, Password, Mobile_Number;
     Button SUBMIT;
     TextView status;

    Connection con;
    Statement stmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name = findViewById(R.id.Name);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        Mobile_Number=findViewById(R.id.Mobile_Number);
        SUBMIT = (Button)findViewById(R.id.SUBMIT);
       // status= (TextView)findViewById(R.id.status);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new registration.registeruser().execute("");
            }
        });
    }
   public class registeruser extends AsyncTask<String, String ,String>{

        String z = "";
        Boolean isSuccess = false;

       @Override
       protected void onPreExecute() {
         status.setText(("Sending Data"));
       }

       @Override
       protected void onPostExecute(String s) {

           status.setText("Registration Successful");
           Name.setText("");
           Email.setText("");
           Password.setText("");
           Mobile_Number.setText("");
       }

       @Override
       protected String doInBackground(String... strings) {
          try {
              con = connectionClass(ConnectionClass.un.toString(),ConnectionClass.pass.toString(),ConnectionClass.db.toString(),ConnectionClass.ip);
              if(con == null){
                  z = "Check your Internet Connection";
              }
              else{
                  String sql = "INSERT INTO register (Name,Email,Password,Mobile_Number) VALUES ('"+Name.getText()+"','"+Email.getText()+"','"+Password.getText()+"','"+Mobile_Number+"')";
                  stmt = con.createStatement();
                  stmt.executeUpdate(sql);
              }
          }catch (Exception e){
              isSuccess = false;
              z = e.getMessage();
          }
           return z;
       }
   }

    @SuppressLint("NewApi")
    public Connection connectionClass(String user, String password, String database, String server){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server+"/" + database + ";user=" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
         } catch (Exception e) {
           Log.e("SQL Connection Error : ", e.getMessage());
        }
        return connection;
    }
   //public void moveToLogin(View v){
     //   startActivity(new Intent(getApplicationContext(),login.class));
       // finish();
   // }*/


}