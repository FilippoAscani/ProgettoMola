package com.example.progettomola.Model.DAO;

import com.example.progettomola.Model.Entity.Sponsor;

import java.util.List;

public interface SponsorDAO {

    void addSponsor(Sponsor sponsor);
    void updateSponsor(Sponsor sponsor);
    void deleteSponsor(Sponsor sponsor);
    List<Sponsor> getSponsors();
    Sponsor getSponsor(int id);


}
