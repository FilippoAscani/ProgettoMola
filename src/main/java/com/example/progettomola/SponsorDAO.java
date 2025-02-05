package com.example.progettomola;

import java.util.List;

public interface SponsorDAO {

    void AddSponsor(Sponsor sponsor);
    void UpdateSponsor(Sponsor sponsor);
    void DeleteSponsor(Sponsor sponsor);
    List<Sponsor> GetAllSponsors();
    Sponsor GetSponsor(int id);


}
