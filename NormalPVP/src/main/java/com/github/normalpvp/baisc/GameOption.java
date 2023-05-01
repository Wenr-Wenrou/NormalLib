package com.github.normalpvp.baisc;

import com.github.normalpvp.type.GameMode;


/*
* 游戏设置基类
*
*
* */

public class GameOption {
    private GameMode gameMode;
    private GameMap map;
    private int maxCombatTime;


    public GameOption(GameMode gameMode, GameMap map, int maxCombatTime) {
        this.gameMode = gameMode;
        this.map = map;
        this.maxCombatTime = maxCombatTime;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public int getMaxCombatTime() {
        return maxCombatTime;
    }

    public void setMaxCombatTime(int maxCombatTime) {
        this.maxCombatTime = maxCombatTime;
    }
}
