package com.example.sandumihai.discovertheworld;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandumihai.discovertheworld.about.aboutActivity;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ipInfoActivity extends AppCompatActivity {
    String countryTitle;

    String ipInserted;
    String countryCode=null;
    TextView ipInfo;
    TextView countryInfo;

    DataBaseHelper mydb;
    TextView countryName;
    //definim o cheie pe care o folosim ca sa transmitem informatia in urmatoarea activitate
    public final static String TitleKey = "CountryName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_info);

        //verifica ce element din spinner a fost selectat
        //-------------------------------------------METODE DE VERIFICARE OPTIUNI SELECTATE IN SPINNER------------------------------
        readFontStyleItemSelectedInSpinner();
        readLanguageItemSelectedinSpinner();
        readBackgroundItemsSelectedInSpinner();

       // mydb  = new DataBaseHelper(this);

        Intent homeActivity = getIntent();
        ipInserted = homeActivity.getExtras().getString("ipInserted_homeActivity");

        ipInfo = (TextView) findViewById(R.id.ipInfo_textView_ipInfoActivity);
        ipInfo.setText("The ip you are locating is : "+ipInserted);

        getIpInfo workerIp = new getIpInfo();

        if((ipInserted != null ) && (dotsInIp(ipInserted) == 3) ){

            Toast.makeText(getApplicationContext(), R.string.gettingData_ipInfoActivity,Toast.LENGTH_SHORT).show();
            workerIp.execute();
        } else {

            Toast.makeText(getApplicationContext(), R.string.ipNotCorrect_ipInfoActivity,Toast.LENGTH_LONG).show();
        }
    }

    //FONT STYLE CHANGES
    //--------------------------------------------------------------------------------------------------------------------------
    //     VERIFICARE OPTIUNE SELECTATA IN SPINNER-UL PT FONT SI MODIFICARILE CORESPUNZATOARE IN ACTIVITATEA PT MENIU
    //--------------------------------------------------------------------------------------------------------------------------

    public void readFontStyleItemSelectedInSpinner()
    {
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("fontFile");
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
        String FontState = result.toString();
        ChangFontStyle(FontState);

    }

    public void ChangFontStyle(String FontState)
    {
        if(FontState.equals("Bold"))
        {
            Button btn1 = (Button) findViewById(R.id.info_country_button_IpInfo_Activity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(btn1.getTypeface(), Typeface.BOLD);
            Button btn2 = (Button) findViewById(R.id.searchIP_button_ipInfoActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn2.setTypeface(btn1.getTypeface(), Typeface.BOLD);

            TextView ip = (TextView)findViewById(R.id.ipInfo_textView_ipInfoActivity);
            ip.setTypeface(ip.getTypeface(), Typeface.BOLD);

            TextView country = (TextView)findViewById(R.id.countryInfo_textView_ipInfoActivity);
            country.setTypeface(ip.getTypeface(), Typeface.BOLD);

        }
        else if(FontState.equals("Italic"))
        {
            Button btn1 = (Button) findViewById(R.id.info_country_button_IpInfo_Activity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(btn1.getTypeface(), Typeface.ITALIC);
            Button btn2 = (Button) findViewById(R.id.searchIP_button_ipInfoActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn2.setTypeface(btn1.getTypeface(), Typeface.ITALIC);


            TextView ip = (TextView)findViewById(R.id.ipInfo_textView_ipInfoActivity);
            ip.setTypeface(ip.getTypeface(),Typeface.ITALIC);


            TextView country = (TextView)findViewById(R.id.countryInfo_textView_ipInfoActivity);
            country.setTypeface(ip.getTypeface(),Typeface.ITALIC);

        }
        else
        {

            Button btn1 = (Button) findViewById(R.id.info_country_button_IpInfo_Activity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setTypeface(Typeface.DEFAULT);
            Button btn2 = (Button) findViewById(R.id.searchIP_button_ipInfoActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn2.setTypeface(Typeface.DEFAULT);


            TextView ip = (TextView)findViewById(R.id.ipInfo_textView_ipInfoActivity);
            ip.setTypeface(Typeface.DEFAULT.DEFAULT);


            TextView country = (TextView)findViewById(R.id.countryInfo_textView_ipInfoActivity);
            country.setTypeface(Typeface.DEFAULT);
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
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String LanguageState = result.toString();
        ChangeLanguage(LanguageState);

    }


    public void ChangeLanguage(String LanguageState)
    {
        if(LanguageState.equals("Romana"))
        {
            Button btn1 = (Button) findViewById(R.id.info_country_button_IpInfo_Activity);
            //require to import Typeface class
            //set the button font, text style bold
            btn1.setText("Info Tara");

            TextView ip = (TextView)findViewById(R.id.ipInfo_textView_ipInfoActivity);
            ip.setText("IP pe care vrei sa-l localizezi este");

            TextView country = (TextView)findViewById(R.id.countryInfo_textView_ipInfoActivity);
            country.setText("Tara este");




            Button btn2 = (Button) findViewById(R.id.searchIP_button_ipInfoActivity);
            //require to import Typeface class
            //set the button font, text style bold
            btn2.setText("Cauta IP");

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
            LinearLayout layout = (LinearLayout) findViewById(R.id.ipInfoActivity);
            layout.setBackgroundColor(Color.parseColor("#6ab16f"));


        }
    }



    //------------------------------------------------------------------------------------------------------------------------------










    private int dotsInIp(String ipInserted) {

        int count=0;
        for(int i=0;i<ipInserted.length();i++)
            if(ipInserted.charAt(i) == '.')
                count++;
        return count;

    }

    public void backToHome(View view) {

        finish();
    }

    public void openInfoCountryActivity(View view)
    {

            //retinem numele tarii intr-o variabila String
            //countryName = (TextView)findViewById(R.id.test);
            String name = countryCode.toString();

            if(name != null) {
                //String descriere = mydb.searchCountry(name);
                Intent in = new Intent(this, CountryInfo.class);
                in.putExtra("CountryName", name);
                // in.putExtra("CountryInformation", descriere);
                startActivity(in);
            }   else {
                Toast.makeText(getApplicationContext(), R.string.insertValidIp_ipInfoActivity,Toast.LENGTH_LONG).show();
            }
    }

    public void toGoogleMaps(View view) {

        Intent intent = new Intent(getApplicationContext(), googleMapsActivity.class);
        startActivity(intent);
    }


    class getIpInfo extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPostExecute(Void aVoid) {

            countryInfo.append(countryCode);

        }

        @Override
        protected Void doInBackground(Void... params) {

            String jsonString=null;
            countryInfo = (TextView) findViewById(R.id.countryInfo_textView_ipInfoActivity);

            try {

                URL url = new URL("http://freegeoip.net/json/"+ipInserted);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line =null;

                while((line = bufferedReader.readLine()) != null) {
                    sb.append(line+"\n");
                }

                jsonString = sb.toString();
                JSONObject json = new JSONObject(jsonString);
                countryCode =" "+ json.getString("country_name");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
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
