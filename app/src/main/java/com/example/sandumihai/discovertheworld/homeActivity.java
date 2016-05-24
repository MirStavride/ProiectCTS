package com.example.sandumihai.discovertheworld;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sandumihai.discovertheworld.about.aboutActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class homeActivity extends AppCompatActivity {

    EditText ipInserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        //verifica ce element din spinner a fost selectat
        //-------------------------------------------METODE DE VERIFICARE OPTIUNI SELECTATE IN SPINNER------------------------------
        readFontStyleItemSelectedInSpinner();
        readLanguageItemSelectedinSpinner();
        readBackgroundItemsSelectedInSpinner();
    }



    //FONT STYLE CHANGES
    //--------------------------------------------------------------------------------------------------------------------------
    //     VERIFICARE OPTIUNE SELECTATA IN SPINNER-UL PT FONT SI MODIFICARILE CORESPUNZATOARE IN ACTIVITATEA PT MENIU
    //--------------------------------------------------------------------------------------------------------------------------

    public void readFontStyleItemSelectedInSpinner() {
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("fontFile");
            br = new BufferedReader(new InputStreamReader(fis));
            String linie;
            while ((linie = br.readLine()) != null) {
                result.append(linie);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String FontState = result.toString();
        ChangFontStyle(FontState);

    }


    public void ChangFontStyle(String FontState)
    {
        if(FontState.equals("Bold"))
        {
            Button btn1 = (Button) findViewById(R.id.ipInfo_button_homeActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(btn1.getTypeface(), Typeface.BOLD);

        }
        else if(FontState.equals("Italic"))
        {
            Button btn1 = (Button) findViewById(R.id.ipInfo_button_homeActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(btn1.getTypeface(), Typeface.ITALIC);

        }
        else
        {

            Button btn1 = (Button) findViewById(R.id.ipInfo_button_homeActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(Typeface.DEFAULT);
        }


    }


    //------------------------------------------------------------------------------------------------------------------------------



//--------------------------------------------------------------------------------------------------------------------------------
    // VERIFICARE OPTIUNE SELECTATA IN SPINNER-UL PT LIMBA SI MODIFICARILE CORESPUNZATOARE IN ACTIVITATEA PT MENIU
    //--------------------------------------------------------------------------------------------------------------------------

    public void readLanguageItemSelectedinSpinner()
    {
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("languageFile");
            br = new BufferedReader(new InputStreamReader(fis));
            String linie;
            while ((linie = br.readLine())!=null)
            {
                result.append(linie);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String LanguageState = result.toString();
        ChangeLanguage(LanguageState);

    }


    public void ChangeLanguage(String LanguageState)
    {
        if(LanguageState.equals("Romana"))
        {
            Button btn1 = (Button) findViewById(R.id.ipInfo_button_homeActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setText("Ia IP Info");

        }
    }


//---------------------------------------------------------------------------------------------------------------------------------



    //---------------------------------------------------------------------------------------------------------------------------
    //          VERIFICARE OPTIUNE SELECTATA IN SPINNER-UL PT BACKGROUND SI MODIFICARILE CORESPUNZATOARE IN ACTIVITATEA PT MENIU
    //-----------------------------------------------------------------------------------------------------------------------------

    public void readBackgroundItemsSelectedInSpinner()
    {
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("backgroundFile");
            br = new BufferedReader(new InputStreamReader(fis));
            String linie;
            while ((linie = br.readLine())!=null)
            {
                result.append(linie);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String BackgroundState = result.toString();
        ChangBackground(BackgroundState);

    }


    public void ChangBackground(String BackgroundState)
    {
        if(BackgroundState.equals("Green"))
        {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.homeActivity);
            layout.setBackgroundColor(Color.parseColor("#6ab16f"));


        }
    }



    //------------------------------------------------------------------------------------------------------------------------------







    public void getIpInfo(View view) {

        ipInserted = (EditText) findViewById(R.id.ip_editText_homeActivity);
        String ip = ipInserted.getText().toString();

        Intent intentIpInfo = new Intent(getApplicationContext(),ipInfoActivity.class);
        intentIpInfo.putExtra("ipInserted_homeActivity",ip);
        startActivity(intentIpInfo);
    }

    public void toAbout(View view) {

        Intent intent = new Intent(getApplicationContext(), aboutActivity.class);
        startActivity(intent);

    }

    public void exitClick(View view) {
        finish();
    }

    public void settingsClick(View view) {

        Intent intent = new Intent(getApplicationContext(),settingsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id == R.id.actionSettings_menu) {

            Intent intent = new Intent(getApplicationContext(), settingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.actionAbout_menu){

            Intent intent = new Intent(getApplicationContext(), aboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.actionExit_menu) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
