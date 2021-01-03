package com.example.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//Student : Gurparteet Singh Purbe
//ID: 217604851
//This lab is partnered with : Carlos Ordonez (217077629)

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }



    public void onEncrypt(View v) {

        try {
            //PREVIOUSLY DONE IN TWO LINE LIKE :
            //    EditText keyView = (EditText) findViewById(R.id.key);
            //    String key = keyView.getText().toString();

            String key = ((EditText) findViewById(R.id.key)).getText().toString();
            String data = ((EditText) findViewById(R.id.data)).getText().toString();

            Cipher c = new Cipher(key);

            String result = c.Encrypt(data);

            (((EditText) findViewById(R.id.data))).setText(result);


        } catch (Exception e) {

            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();

        }
    }
    public void onDecrypt(View v){

            try {


                String key= ((EditText) findViewById(R.id.key)).getText().toString() ;
                String data= ((EditText) findViewById(R.id.data)).getText().toString() ;

                Cipher c =new Cipher(key) ;

                String result= c.Decrypt(data) ;

                (((EditText) findViewById(R.id.data))).setText(result);


            }
            catch (Exception e){


                Toast label= Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
                label.show();

            }
    }



    public void onSave(View v ) {
            try {
                String name=((EditText) findViewById(R.id.file)).getText().toString() ;
                File dir= this.getFilesDir();

                File file= new File(dir,name);

                FileWriter fw= new FileWriter(file) ;
                fw.write(((EditText) findViewById(R.id.data)).getText().toString());
                fw.close();
                Toast.makeText(this, "SAVED." ,Toast.LENGTH_LONG).show();


            }
            catch (Exception e){
                Toast.makeText(this , e.getMessage() , Toast.LENGTH_LONG).show();

            }

    }

    public void onLoad(View v){

            try {
                String name= (((EditText) findViewById(R.id.file))).getText().toString();
                File dir = this.getFilesDir();
                File file=new File(dir,name);
                FileReader fr=new FileReader(file);

                String show="" ;
                for ( int c =fr.read() ; c!=-1 ;c=fr.read()){
                    show+=(char) c ;
                }
                fr.close();
                (((EditText) findViewById(R.id.data))).setText(show) ;
            }
            catch (Exception e){
                Toast.makeText(this,e.getMessage() ,Toast.LENGTH_LONG).show();
            }
    }





    }






