package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText Usuario;
    private EditText Contrasena;
    private Button Ingresar;
    private  BufferedWriter writer;
    private BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConecction();
        Log.e("Holaa","-1");

        //referenciar
        Usuario=findViewById(R.id.Usuario);
       Contrasena=findViewById(R.id.Contrasena);
        Ingresar=findViewById(R.id.Ingresar);

        Ingresar.setOnClickListener(
                (v)->{

                   /*Intent i = new Intent(this,BienvenidoActivity.class);
                    startActivity(i);*/
                }

        );


    }

    public void initConecction() {
        Log.e("Holaa","0");
        new Thread(

                () -> {

                    try {
                        Log.e("Holaa","1");

                      Socket cliente= new Socket("127.0.0.1",5000);
                        Log.e("Holaa","2");
                        //envio y recepcion
                        InputStream is= cliente.getInputStream();
                        OutputStream os= cliente.getOutputStream();

                      writer= new BufferedWriter(new OutputStreamWriter(os));
                      reader= new BufferedReader(new InputStreamReader(is));

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

        ).start();

    }// cierra initConecction

}//cierra main