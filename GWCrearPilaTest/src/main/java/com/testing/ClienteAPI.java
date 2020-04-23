package com.testing;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class ClienteAPI {

    public static void main (String[] args) throws IOException {

        requestShuffle();


    }

    private static void requestShuffle () throws IOException {

        //Defino la URL que voy a consumir, sin pasarle el nro de decks
        String endpointShuffle = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=";

        //Pregunto el nro de Decks que se desean usar y lo guardo en una variable
        System.out.println("Ingrese el numero de Decks que desea usar:");
        Scanner scanner = new Scanner(System.in);
        int numberOfDecks = scanner.nextInt();
        scanner.close();

        //Le concateno a la URL base, el nro de Decks ingresado
        endpointShuffle = endpointShuffle + numberOfDecks;

        //Guardo mi URL completa con parametro incluido en la variable url
        String url = endpointShuffle;

        System.out.println("La URL que vas a consumir es:\n" + url);

        HttpClientBuilder hcBuilder = HttpClients.custom();
        HttpClient client = hcBuilder.build() ;

        HttpGet requestShuffle = new HttpGet(url);

        //Setting header parameters
        requestShuffle.addHeader("Content-Type", "application/json");
        requestShuffle.addHeader("Accept", "application/json");

        //Executing the call
        HttpResponse response = client.execute(requestShuffle);
        System.out.println("\nEnviando 'Get' a " + url);
        System.out.println("HTTP Response: " +  response.getStatusLine().getStatusCode());

        //Reading the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();

        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }
}
