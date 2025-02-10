package com.example.progettomola.model.daoimpl;

import com.example.progettomola.model.dao.SponsorDAO;
import com.example.progettomola.model.entity.Sponsor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAOImplCSV implements SponsorDAO {

    @Override
    public void addSponsor(Sponsor sponsor) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "sponsor.csv", true));
            bw.write(sponsor.getId() + "," +sponsor.getUsername() + "," + sponsor.getPassword() );
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Sponsor getSponsor(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("sponsor.csv"));
            String line;
            while((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                if(Integer.parseInt(colonne[0]) == id){
                    return new Sponsor(id, colonne[1], colonne[2]);

                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Sponsor> getSponsors() {

        List<Sponsor> sponsors = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("sponsor.csv"));
            String line;
            while ((line = br.readLine()) != null){
                String[] colonne = line.split(",");
                sponsors.add(new Sponsor(Integer.parseInt(colonne[0]), colonne[1], colonne[2]));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sponsors;

    }

    @Override
    public void deleteSponsor(Sponsor sponsor) {
        List<Sponsor> sponsors = getSponsors();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("sponsor.csv", true));
            for (Sponsor s : sponsors) {
                if(s.getId() != sponsor.getId()){
                    bw.write(s.getId() + "," +s.getUsername() + "," + s.getPassword());
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        List<Sponsor> sponsors = getSponsors();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("sponsor.csv", true));
            for (Sponsor s : sponsors) {
                if(s.getId() == sponsor.getId()){
                    br.write(sponsor.getId() + "," +sponsor.getUsername() + "," + sponsor.getPassword());
                }
                else{
                    br.write(s.getId() + "," +s.getUsername() + "," + s.getPassword());
                }
                br.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
