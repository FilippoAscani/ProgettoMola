package com.example.progettomola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SponsorDAOImplCSV implements SponsorDAO {
    @Override
    public void AddASponsor(Sponsor sponsor) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter( "sponsor.csv", true));
            bw.write(sponsor.getUsername() + "," + sponsor.getId());
            bw.newLine();
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void UpdateArtist(Sponsor sponsor) {

    }

    @Override
    public void DeleteArtist(Sponsor sponsor) {

    }

    @Override
    public List<Sponsor> GetAllSponsors() {
        return List.of();
    }

    @Override
    public Sponsor GetSponsor(int id) {
        return null;
    }
}
