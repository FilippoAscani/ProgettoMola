package com.example.progettomola;

import java.util.List;

public interface SponsorDAO {

    void addSponsor(Sponsor sponsor);
    void updateSponsor(Sponsor sponsor);
    void deleteSponsor(Sponsor sponsor);
    List<Sponsor> getSponsors();
    Sponsor getSponsor(int id);


}
