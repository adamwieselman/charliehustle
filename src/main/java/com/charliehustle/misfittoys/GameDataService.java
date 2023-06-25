package com.charliehustle.misfittoys;

import com.charliehustle.dao.GameDataRepository;
import com.charliehustle.models.GameData;
import org.springframework.beans.factory.annotation.Autowired;

public class GameDataService {
    @Autowired
    GameDataRepository gameDataRepository;

    public GameData findByEspnGameId(String espnId) {
        return gameDataRepository.findByEspnGameId(espnId);
    }

    public GameData saveGameDataInfo(GameData gameDataObject) {
        return gameDataRepository.saveAndFlush(gameDataObject);
    }
}
