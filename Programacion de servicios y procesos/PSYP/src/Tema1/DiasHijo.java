package Tema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DiasHijo {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fechaIngresada = br.readLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaUsuario = LocalDate.parse(fechaIngresada, formatter);
            LocalDate fechaActual = LocalDate.now();


            long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaUsuario);

 
            if (diasRestantes < 0) {
                diasRestantes = 0;
            }


            System.out.println(diasRestantes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
