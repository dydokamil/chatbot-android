package com.example.kamil.myapplication;

import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b = (Button) findViewById(R.id.button1);
        final TextView bot_output = (TextView) findViewById(R.id.editText3);
        final TextView wiadmosc_input = (TextView) findViewById(R.id.editText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input_text = wiadmosc_input.getText();
                Wiadomosc wiadomosc = new Wiadomosc(input_text.toString());
                bot_output.setText(wiadomosc.pobierzOdpowiedz());
            }
        });
    }
}

class Wiadomosc {
    private String wiadomosc;
    private String[] powitania;
    private String[] pogoda;
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

    Wiadomosc(String msg) {
        powitania = new String[]{"cześć", "witaj", "hej"};
        pogoda = new String[]{"pogoda", "deszcz", "słońce", "słonecznie", "deszczowo", "padać",
                "padał"};
        this.wiadomosc = msg.toLowerCase();
    }

    String pobierzOdpowiedz() {
        if (Arrays.asList(powitania).contains(this.wiadomosc)) {
            Random random = new Random();
            return powitania_odpowiedzi.get(random.nextInt(powitania_odpowiedzi.size()));
        } else if (Arrays.asList(pogoda).contains(this.wiadomosc)) {
            Random random = new Random();
            return pogoda_odpowiedzi.get(random.nextInt(pogoda_odpowiedzi.size()));
        }
        return null;
    }
}
