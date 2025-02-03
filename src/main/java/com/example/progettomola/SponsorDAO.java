package com.example.progettomola;

import java.util.List;

public interface SponsorDAO {

    void AddASponsor(Sponsor sponsor);
    void UpdateArtist(Sponsor sponsor);
    void DeleteArtist(Sponsor sponsor);
    List<Sponsor> GetAllSponsors();
    Sponsor GetSponsor(int id);


}
