package com.charliehustle.dao;


import com.charliehustle.models.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepository extends JpaRepository<GameData, Long> {
    public GameData findByEspnGameId(String espnGameId);
}
