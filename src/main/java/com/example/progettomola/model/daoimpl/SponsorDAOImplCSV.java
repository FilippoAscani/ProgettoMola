package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.SponsorDAO;
import com.example.progettomola.model.entity.Sponsor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAOImplCSV implements SponsorDAO {


    private static final String FILE = "sponsor.csv";

    @Override
    public void addSponsor(Sponsor sponsor) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( FILE, true));
            bw.write(sponsor.getId() + "," +sponsor.getUsername() + "," + sponsor.getPassword() );
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiungere sponsor", e);
        }


    }

    @Override
    public Sponsor getSponsor(int id) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    if (Integer.parseInt(colonne[0]) == id) {
                        return new Sponsor(id, colonne[1], colonne[2]);

                    }

                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare sponsor", e);
        }
        return null;
    }

    @Override
    public List<Sponsor> getSponsors() {

        List<Sponsor> sponsors = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] colonne = line.split(",");
                    sponsors.add(new Sponsor(Integer.parseInt(colonne[0]), colonne[1], colonne[2]));

                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile visualizzare sponsors", e);
        }
        return sponsors;

    }

    @Override
    public void deleteSponsor(Sponsor sponsor) {
        List<Sponsor> sponsors = getSponsors();
        try {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Sponsor s : sponsors) {
                    if (s.getId() != sponsor.getId()) {
                        bw.write(s.getId() + "," + s.getUsername() + "," + s.getPassword());
                        bw.newLine();
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile eliminare sponsor", e);
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        List<Sponsor> sponsors = getSponsors();
        try {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE, true))) {
                for (Sponsor s : sponsors) {
                    if (s.getId() == sponsor.getId()) {
                        br.write(sponsor.getId() + "," + sponsor.getUsername() + "," + sponsor.getPassword());
                    } else {
                        br.write(s.getId() + "," + s.getUsername() + "," + s.getPassword());
                    }
                    br.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile aggiornare sponsor", e);
        }

    }
}
