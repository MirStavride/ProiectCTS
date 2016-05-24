package com.example.sandumihai.discovertheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Simi on 05.01.2016.
 */
public class CountryInfo extends Activity
{
    //cheile prin care referim informatiile transmise catre activitatea CountryInfo
    public final static String TitleKey = "CountryName";
    public final static String InformationKey = "CountryInformation";

    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String country = intent.getStringExtra(TitleKey);
        //String des = intent.getStringExtra(InformationKey);
        setContentView(R.layout.activity_country_info);

        mydb  = new DataBaseHelper(this);



        //ca urmare a informatiilor transmise, se cauta in baza de date informatiile referitoare
        // la tara ceruta, se seteaza titlul corespunzator tarii si se afiseaza steagul corespunzator tarii
        //--------------------------------------MODIFICARI IN FUNCTIR DE TARA CERUTA --------------------------------------------
        TextView countryTitle = (TextView)findViewById(R.id.title_text_view_country_info);
        countryTitle.setText(country);


        String descriere = mydb.searchCountry(country);

        TextView inf = (TextView)findViewById(R.id.information_about_contry_text_view_country_info);
        inf.setText(descriere);

        String nume = countryTitle.getText().toString();
        ImageView icon = (ImageView) findViewById(R.id.flag_icon_country_info);
        if (nume.equals(" United States"))
        {
            icon.setImageResource(R.drawable.united_states_flag_icon);

        }
        else if (nume.equals(" Albania"))
        {
            icon.setImageResource(R.drawable.albania_flag_icon);

        }
        else if (nume.equals(" An Marino"))
        {
            icon.setImageResource(R.drawable.an_marino_flag_icon);

        }
        else if (nume.equals(" Andorra"))
        {
            icon.setImageResource(R.drawable.andorra_flag_icon);

        }
        else if (nume.equals(" Armenia"))
        {
            icon.setImageResource(R.drawable.armenia_flag_icon);

        }
        else if (nume.equals(" Austria"))
        {
            icon.setImageResource(R.drawable.austria_flag_icon);

        }
        else if (nume.equals(" Azerbaijan"))
        {
            icon.setImageResource(R.drawable.azerbaijan_flag_icon);

        }
        else if (nume.equals(" Belarus"))
        {
            icon.setImageResource(R.drawable.belarus_flag_icon);

        }
        else if (nume.equals(" Belgium"))
        {
            icon.setImageResource(R.drawable.belgium_flag_icon);

        }
        else if (nume.equals(" Bosnian"))
        {
            icon.setImageResource(R.drawable.bosnian_flag_icon);

        }
        else if (nume.equals(" Bulgaria"))
        {
            icon.setImageResource(R.drawable.bulgaria_flag_icon);

        }
        else if (nume.equals(" Croatian"))
        {
            icon.setImageResource(R.drawable.croatian_flag_icon);

        }
        else if (nume.equals(" Cyprus"))
        {
            icon.setImageResource(R.drawable.cyprus_flag_icon);

        }
        else if (nume.equals(" Czech"))
        {
            icon.setImageResource(R.drawable.czech_republic_flag_icon);

        }
        else if (nume.equals(" Estonia"))
        {
            icon.setImageResource(R.drawable.estonia_flag_icon);

        }
        else if (nume.equals(" France"))
        {
            icon.setImageResource(R.drawable.france_flag_icon);

        }
        else if (nume.equals(" Georgia"))
        {
            icon.setImageResource(R.drawable.georgia_flag_icon);

        }
        else if (nume.equals(" Germany"))
        {
            icon.setImageResource(R.drawable.germany_flag_icon);

        }
        else if (nume.equals(" Greece"))
        {
            icon.setImageResource(R.drawable.greece_flag_icon);

        }
        else if (nume.equals(" Hungary"))
        {
            icon.setImageResource(R.drawable.hungary_flag_icon);

        }
        else if (nume.equals(" Iceland"))
        {
            icon.setImageResource(R.drawable.iceland_flag_icon);

        }
        else if (nume.equals(" Ireland"))
        {
            icon.setImageResource(R.drawable.ireland_flag_icon);

        }
        else if (nume.equals(" Kosovo"))
        {
            icon.setImageResource(R.drawable.kosovo_flag_icon);

        }
        else if (nume.equals(" Latvia"))
        {
            icon.setImageResource(R.drawable.latvia_flag_icon);

        }
        else if (nume.equals(" Liechtenstein"))
        {
            icon.setImageResource(R.drawable.liechtenstein_flag_icon);

        }
        else if (nume.equals(" Lithuania"))
        {
            icon.setImageResource(R.drawable.lithuania_flag_icon);

        }
        else if (nume.equals(" Luxembourg"))
        {
            icon.setImageResource(R.drawable.luxembourg_flag_icon);

        }
        else if (nume.equals(" Macedonia"))
        {
            icon.setImageResource(R.drawable.macedonia_flag_icon);

        }
        else if (nume.equals(" Malta"))
        {
            icon.setImageResource(R.drawable.malta_flag_icon);

        }
        else if (nume.equals(" Moldova"))
        {
            icon.setImageResource(R.drawable.moldova_flag_icon);

        }
        else if (nume.equals(" Monaco"))
        {
            icon.setImageResource(R.drawable.monaco_flag_icon);

        }
        else if (nume.equals(" Montenegro"))
        {
            icon.setImageResource(R.drawable.montenegro_flag_icon);

        }
        else if (nume.equals(" Luxembourg"))
        {
            icon.setImageResource(R.drawable.luxembourg_flag_icon);

        }
        else if (nume.equals(" Netherlands"))
        {
            icon.setImageResource(R.drawable.netherlands_flag_icon);

        }
        else if (nume.equals(" Norway"))
        {
            icon.setImageResource(R.drawable.norway_flag_icon);

        }
        else if (nume.equals(" Poland"))
        {
            icon.setImageResource(R.drawable.poland_flag_icon);

        }
        else if (nume.equals(" Portugal"))
        {
            icon.setImageResource(R.drawable.portugal_flag_icon);

        }
        else if (nume.equals(" Romania"))
        {
            icon.setImageResource(R.drawable.romania_flag_icon);

        }
        else if (nume.equals(" Russia"))
        {
            icon.setImageResource(R.drawable.russia_flag_icon);

        }
        else if (nume.equals(" Serbia"))
        {
            icon.setImageResource(R.drawable.serbia_flag_icon);

        }
        else if (nume.equals(" Slovakia"))
        {
            icon.setImageResource(R.drawable.slovakia_flag_icon);

        }
        else if (nume.equals(" Slovenia"))
        {
            icon.setImageResource(R.drawable.slovenia_flag_icon);

        }
        else if (nume.equals(" Spain"))
        {
            icon.setImageResource(R.drawable.spain_flag_icon);

        }
        else if (nume.equals(" Sweden"))
        {
            icon.setImageResource(R.drawable.sweden_flag_icon);

        }
        else if (nume.equals(" Turkey"))
        {
            icon.setImageResource(R.drawable.turkey_flag_icon);

        }
        else if (nume.equals(" Switzerland"))
        {
            icon.setImageResource(R.drawable.switzerland_flag_icon);

        }
        else if (nume.equals(" Ukraine"))
        {
            icon.setImageResource(R.drawable.ukraine_flag_icon);

        }
        else if (nume.equals(" United Kingdom"))
        {
            icon.setImageResource(R.drawable.united_kingdom_flag_icon);

        }
        else icon.setImageResource(R.drawable.vatican_city_flag_icon);
    }



    public void backToIpInfoActivity(View view)
    {
       finish();
    }
}
