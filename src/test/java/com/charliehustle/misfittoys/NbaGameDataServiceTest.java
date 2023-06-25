package com.charliehustle.misfittoys;

import com.charliehustle.dao.GameDataRepository;
import com.charliehustle.models.GameData;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class NbaGameDataServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    GameDataRepository gameDataRepository;

    @InjectMocks
    public GameDataService gameDataService = new GameDataService();

    @Test
    public void testFindByEspnGameId(){
        GameData gameData = new GameData();
        Mockito.when(gameDataRepository.findByEspnGameId("23345")).thenReturn(gameData);

        gameDataService.findByEspnGameId("23345");
        Mockito.verify(gameDataRepository).findByEspnGameId("23345");
    }

    @Test
    public void testSaveGameDataInfo(){
        GameData gameData = new GameData();
        Mockito.when(gameDataRepository.saveAndFlush(gameData)).thenReturn(gameData);

        gameDataService.saveGameDataInfo(gameData);
        Mockito.verify(gameDataRepository).saveAndFlush(gameData);
    }

}
