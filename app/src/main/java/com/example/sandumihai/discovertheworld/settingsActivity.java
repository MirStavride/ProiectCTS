package com.example.sandumihai.discovertheworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class settingsActivity extends AppCompatActivity {

    private Spinner fontSpiner;
    private Spinner languageSpiner;
    private Spinner backgroundSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);


        //metode prin care spinnerele sunt populate
        addItemsToChangeFontStyleSpinner();
        addItemsToLanguageSpinner();
        addItemsToBackgroundSpinner();

        addListenerToUnitTypeFontSpinner();
        addListenerToUnitTypeLanguageSpinner();
        addListenerToUnitTypeBackgroundSpinner();

//metode prin care se citesc optiunile selectate in spinner din fisiere
        readFontStyleItemSelectedInSpinner();
        readLanguageItemSelectedinSpinner();
        readBackgroundItemsSelectedInSpinner();
    }

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


    public void backToPreviousMenu(View view) {
        Intent goingBack = new Intent(this, homeActivity.class);
        startActivity(goingBack);
    }

    public void ChangBackground(String BackgroundState)
    {
        if(BackgroundState.equals("Green"))
        {
            LinearLayout layout = (LinearLayout) findViewById(R.id.settingsActivity);
            layout.setBackgroundColor(Color.parseColor("#6ab16f"));


        }
    }




    //------------------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------------------------------------------------------------------------------------

    //                              POPULARE SPINNER FONT SI RETINERE OPTIUNE SELECTATA
    //------------------------------------------------------------------------------------------------------------------------------

    public void addItemsToChangeFontStyleSpinner() {
        fontSpiner = (Spinner) findViewById(R.id.openChangeFontStyle_spinner_SettingsActivity);
        ArrayAdapter<CharSequence> fontStleSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.fontStyleOptions,
                android.R.layout.simple_spinner_item);
        fontStleSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSpiner.setAdapter(fontStleSpinnerAdapter);
    }


    public void addListenerToUnitTypeFontSpinner() {
        fontSpiner = (Spinner) findViewById(R.id.openChangeFontStyle_spinner_SettingsActivity);
        fontSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInFontSpinner = parent.getItemAtPosition(position).toString();
                //flag.setStateFont(itemSelectedInFontSpinner);
                BufferedWriter bw = null;
                try {
                    FileOutputStream fos = openFileOutput("fontFile", Context.MODE_PRIVATE);
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(itemSelectedInFontSpinner);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //---------------------------------------------------------------------------------------------------------------------------

    //                        CITIRE OPTIUNE SELECTATA IN SPINNER-ul FONT SI EXECUTARE MODIFICARE CERUTA
    //------------------------------------------------------------------------------------------------------------------------------

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

    public void ChangFontStyle(String FontState) {
        TextView bg = (TextView) findViewById(R.id.background_text_view_Settings);
        TextView font = (TextView) findViewById(R.id.fontStyle_textView_Settings);
        TextView language = (TextView) findViewById(R.id.language_textView_Settings);
        if (FontState.equals("Normal")) {
            bg.setTypeface(Typeface.DEFAULT);
            font.setTypeface(Typeface.DEFAULT);
            language.setTypeface(Typeface.DEFAULT);

        } else if (FontState.equals("Bold")) {
            bg.setTypeface(Typeface.DEFAULT_BOLD);
            font.setTypeface(Typeface.DEFAULT_BOLD);
            language.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            bg.setTypeface(null, Typeface.ITALIC);
            font.setTypeface(null, Typeface.ITALIC);
            language.setTypeface(null, Typeface.ITALIC);
        }
    }


//------------------------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------------------------------------------------------------------------------------

    //                              POPULARE SPINNER LANGUAGE SI RETINERE OPTIUNE SELECTATA
    //------------------------------------------------------------------------------------------------------------------------------

    public void addItemsToLanguageSpinner() {
        languageSpiner = (Spinner) findViewById(R.id.openChangeLanguage_spinner_SettingsActivity);
        ArrayAdapter<CharSequence> languageSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.languageOptions,
                android.R.layout.simple_spinner_item);
        languageSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpiner.setAdapter(languageSpinnerAdapter);
    }

    public void addListenerToUnitTypeLanguageSpinner() {
        languageSpiner = (Spinner) findViewById(R.id.openChangeLanguage_spinner_SettingsActivity);
        languageSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemSelectedInLanguageSpinner = parent.getItemAtPosition(position).toString();


                //FlagState flag = new FlagState();
                //flag.setStateLanguage(itemSelectedInLanguageSpinner);
                BufferedWriter bw = null;
                try {
                    FileOutputStream fos = openFileOutput("languageFile", Context.MODE_PRIVATE);
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(itemSelectedInLanguageSpinner);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO something here later

            }
        });
    }


    //---------------------------------------------------------------------------------------------------------------------------

    //                        CITIRE OPTIUNE SELECTATA IN SPINNER-ul LANGUAGE SI EXECUTARE MODIFICARE CERUTA
    //------------------------------------------------------------------------------------------------------------------------------

    public void readLanguageItemSelectedinSpinner() {
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("languageFile");
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
        String LanguageState = result.toString();
        ChangeLanguage(LanguageState);

    }

    public void ChangeLanguage(String LanguageState) {
        TextView bg = (TextView) findViewById(R.id.background_text_view_Settings);
        TextView font = (TextView) findViewById(R.id.fontStyle_textView_Settings);
        TextView language = (TextView) findViewById(R.id.language_textView_Settings);

        if (LanguageState.equals("Romana")) {
            bg.setText("Fundal");
            font.setText("Stil Font");
            language.setText("Limba");
        } else {
            bg.setText("Background");
            font.setText("Font Style");
            language.setText("Language");
        }
    }

//-----------------------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------------------------------------------------------------------------------------

    //                              POPULARE SPINNER BACKGROUND SI RETINERE OPTIUNE SELECTATA
    //------------------------------------------------------------------------------------------------------------------------------


    public void addItemsToBackgroundSpinner() {
        backgroundSpinner = (Spinner) findViewById(R.id.openChangeBackground_spinner_SettingsActivity);
        ArrayAdapter<CharSequence> backgroundSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.backgroundColors,
                android.R.layout.simple_spinner_item);
        backgroundSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundSpinner.setAdapter(backgroundSpinnerAdapter);
    }

    public void addListenerToUnitTypeBackgroundSpinner() {
        backgroundSpinner = (Spinner) findViewById(R.id.openChangeBackground_spinner_SettingsActivity);
        backgroundSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInLanguageSpinner = parent.getItemAtPosition(position).toString();


                BufferedWriter bw = null;
                try {
                    FileOutputStream fos = openFileOutput("backgroundFile", Context.MODE_PRIVATE);
                    bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(itemSelectedInLanguageSpinner);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO something here later

            }
        });
    }

    public void backToIpHome(View view)
    {
        Intent goingBack = new Intent(this, homeActivity.class);
        startActivity(goingBack);
    }
}