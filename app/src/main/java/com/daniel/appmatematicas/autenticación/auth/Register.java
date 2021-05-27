package com.daniel.appmatematicas.autenticación.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daniel.appmatematicas.R;
import com.daniel.appmatematicas.ValidarEmail;
import com.daniel.appmatematicas.view.EncuentraNumeroActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.android.material.snackbar.Snackbar;
//import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {


    private TextView mTitleRegister;
    private EditText mRegister_user_name;
    private EditText mRegister_user_email;
    private EditText mRegister_user_password;
    private FrameLayout mBtnCreateUserRegister;
    private ProgressDialog mProgress;


    private DatabaseReference mDatabaseUser;
    private FirebaseAuth mAuth;

    /*Animación*/
    private Animation mUp_to_down,mhide_to_bottom;
    private LinearLayout mRelato_regis_body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_relato);
        initView();

    }

    private void initView() {
        mProgress = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users");

        mTitleRegister = (TextView) findViewById(R.id.register_title_sangrienta_lectura);
        String text = "<font color='#da152c'>Crear </font>Cuenta";
        mTitleRegister.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);

        String bloodLustFuente= "fuentes/BloodLust.ttf";
        String nightmareFuente= "fuentes/Nigh.ttf";

        mRelato_regis_body = (LinearLayout) findViewById(R.id.relato_regis_body);


        mRegister_user_name = (EditText) findViewById(R.id.register_user_name);
        mRegister_user_email = (EditText) findViewById(R.id.register_user_email);
        mRegister_user_password = (EditText) findViewById(R.id.register_user_password);

        mBtnCreateUserRegister = (FrameLayout) findViewById(R.id.RegistrarCuenta);


        mUp_to_down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_to_down);
        mhide_to_bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_to_up);

        mTitleRegister.setAnimation(mUp_to_down);
        mRelato_regis_body.setAnimation(mUp_to_down);
        mBtnCreateUserRegister.setAnimation(mhide_to_bottom);


        mBtnCreateUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();

            }
        });

    }

    private void startRegister() {
        String display_name = mRegister_user_name.getText().toString();
        String display_email = mRegister_user_email.getText().toString();
        String display_password = mRegister_user_password.getText().toString();

        if (display_name.length() < 4){
            showSnackBar("Verificar nombre.");
            mRegister_user_name.setError("El usuario debe ser mayor de 4 dígitos.");

        }else if (!validarEmail(display_email)){
            showSnackBar("Email no válido.");
            mRegister_user_email.setError("Email no válido.");

        }else if(display_password.length() < 6){
            showSnackBar("La contraseña es muy corta.");
            mRegister_user_password.setError("Mínimo 6 dígitos.");
        }else{
            showSnackBar("Creando Cuenta.");
            mProgress.setTitle("Registrando Datos.");
            mProgress.setMessage("Asignando Credenciales.");
            mProgress.show();
            register_user(display_name,display_email,display_password);
        }

    }

    private boolean validarEmail(String display_email) {
        ValidarEmail check = new ValidarEmail(getApplicationContext());
        boolean booleamCheckEmail = check.checkEmail(display_email);
        Log.v("checkEmail",""+booleamCheckEmail);
        return booleamCheckEmail;
    }


    private void register_user(final String display_name, String display_email, String display_password) {
        mAuth.createUserWithEmailAndPassword(display_email, display_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String user_id = mAuth.getCurrentUser().getUid();

                            FirebaseUser user =  mAuth.getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(display_name)
                                    .setPhotoUri(Uri.parse("https://i.blogs.es/66b2a4/photo-1511367461989-f85a21fda167/450_1000.jpeg"))
                                    .build();

                            DatabaseReference cureent_user_db = mDatabaseUser.child(user_id);
                            cureent_user_db.child("name").setValue(display_name);
                            cureent_user_db.child("image").setValue("https://i.blogs.es/66b2a4/photo-1511367461989-f85a21fda167/450_1000.jpeg");
                            user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("TAG", "User profile updated.");
                                    }
                                }
                            });

                            mProgress.dismiss();

                            createRegister();
                            showSnackBar("Creando Cuenta");

                        } else {
                            mProgress.hide();
                            showSnackBar("No se pudo crear la cuenta por favor intente nuevamente");
                        }

                    }
                });
    }

    public void createRegister(){
        Intent i = new Intent(Register.this, EncuentraNumeroActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        finish();
        startActivity(i);

    }

    public void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.registerRelato), msg, Snackbar.LENGTH_SHORT)
                .show();
    }
}
