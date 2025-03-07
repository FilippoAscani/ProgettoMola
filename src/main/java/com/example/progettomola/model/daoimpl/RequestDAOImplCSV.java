package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.RequestDAO;
import com.example.progettomola.model.entity.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImplCSV implements RequestDAO {

    private static final String FILE = "request.csv";

    @Override
    public void addRequest(Request request) {
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( FILE, true));
            bw.write(request.getId() + "," + request.getNome() + "," + request.getCapienza() + "," + request.getTipo());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiungere richiesta", e);
        }
    }

    @Override
    public void updateRequest(Request request) {
        List<Request> requests = getRequests();
        try {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Request r : requests) {
                    if (r.getId() == request.getId()) {
                        br.write(request.getId() + "," + request.getNome() + "," + request.getCapienza() + "," + request.getTipo());
                    } else {
                        br.write(r.getId() + "," + r.getNome() + "," + r.getCapienza() + "," + request.getTipo());
                    }
                    br.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiornare richiesta", e);
        }
    }

    @Override
    public void deleteRequest(Request request) {
        List<Request> requests = getRequests();
        try {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Request r : requests) {
                    if (r.getId() != request.getId()) {
                        bw.write(r.getId() + "," + r.getNome() + "," + r.getCapienza() + "," + request.getTipo());
                        bw.newLine();
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile eliminare richiesta", e);
        }
    }

    @Override
    public List<Request> getRequests() {
        List<Request> requests = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    requests.add(new Request(Integer.parseInt(colonne[0]), colonne[1], Integer.parseInt(colonne[2]), colonne[3]));

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare richieste", e);
        }
        return requests;
    }

    @Override
    public Request getRequest(int id) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    if (Integer.parseInt(colonne[0]) == id) {
                        return new Request(id, colonne[1], Integer.parseInt(colonne[2]), colonne[3]);
                    }

                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare richiesta", e);
        }
        return null;
    }
}
