package utp.sanchezsanchez.sistemajtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout txtUser, txtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
    public void closeApp(View view){
        finish();
        System.exit(0);
    }
    public void login(View view){
        if(txtUser.getEditText().getText().toString().equals("") && txtPassword.getEditText().getText().toString().equals("")){
            Toast.makeText(this, "Falta escribir algunos datos", Toast.LENGTH_SHORT).show();
        }
        if(txtUser.getEditText().getText().toString().equals("tecnico") && txtPassword.getEditText().getText().toString().equals("tecnico")){
            Toast.makeText(this, "Bienvenido técnico", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, TareasActivity.class);
            i.putExtra("id", 1);
            i.putExtra("user", txtUser.getEditText().getText().toString());
            i.putExtra("name", "Kevin Jhomar");
            i.putExtra("code", "T19309221");
            i.putExtra("image", "@drawable/cloud_inference_api_svgrepo_com");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            Toast.makeText(this, "Upps!, los datos ingresados son incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}