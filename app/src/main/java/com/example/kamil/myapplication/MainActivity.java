package com.example.kamil.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b = (Button) findViewById(R.id.button1);
        final TextView bot_output = (TextView) findViewById(R.id.editText3);
        final TextView wiadmosc_input = (TextView) findViewById(R.id.editText);
        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert wiadmosc_input != null;
                CharSequence input_text = wiadmosc_input.getText();
                Wiadomosc wiadomosc = new Wiadomosc(input_text.toString());
                assert bot_output != null;
                bot_output.setText(wiadomosc.pobierzOdpowiedz());
            }
        });
    }
}

class Wiadomosc {
    private String wiadomosc;
    private String[] powitania;
    private String[] pogoda;
    private String[] imie;
    private String[] wiek;
    private ArrayList<String> pogoda_odpowiedzi = new ArrayList<String>() {{
        add("Jutro będzie słonecznie");
        add("Jutro będzie padał deszcz");
        add("Jutro będzie pochmurno");
    }};
    private ArrayList<String> powitania_odpowiedzi = new ArrayList<String>() {{
        add("Jak się masz?");
        add("Miło cię widzieć");
        add("Co u ciebie?");
    }};
    private ArrayList<String> imie_odpowiedzi = new ArrayList<String>() {{
        add("Mam na imię Robort.");
        add("A ty jak masz na imię?");
    }};
    private ArrayList<String> wiek_odpowiedzi = new ArrayList<String>() {{
        add("Mam 2 lata.");
        add("A ty ile masz lat?");
    }};

    Wiadomosc(String msg) {
        powitania = new String[]{"cześć", "witaj", "hej"};
        pogoda = new String[]{"pogoda", "deszcz", "słońce", "słonecznie", "deszczowo", "padać",
                "padał"};
        imie = new String[]{"imie", "imię", "nazywasz", "zwiesz"};
        wiek = new String[]{"lat", "wiek"};
        this.wiadomosc = msg.toLowerCase();
    }

    String pobierzOdpowiedz() {
        Random random = new Random();
        for (String slowo : this.wiadomosc.split("[?,.! ]")) {
            if (Arrays.asList(powitania).contains(slowo)) {
                return powitania_odpowiedzi.get(random.nextInt(powitania_odpowiedzi.size()));
            } else if (Arrays.asList(pogoda).contains(slowo)) {
                return pogoda_odpowiedzi.get(random.nextInt(pogoda_odpowiedzi.size()));
            } else if (Arrays.asList(imie).contains(slowo)) {
                return imie_odpowiedzi.get(random.nextInt(imie_odpowiedzi.size()));
            } else if (Arrays.asList(wiek).contains(slowo)) {
                return wiek_odpowiedzi.get(random.nextInt(wiek_odpowiedzi.size()));
            }
        }
        return null;
    }
}
