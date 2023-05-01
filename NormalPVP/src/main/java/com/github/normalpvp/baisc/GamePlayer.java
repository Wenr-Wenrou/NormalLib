package com.github.normalpvp.baisc;

import org.bukkit.entity.Player;


/*
* 游戏玩家基类
*
*
* */
public class GamePlayer {
    private Player gamePlayer;
    private int killPlayer;
    private int score;

    public GamePlayer(Player player) {
        this.gamePlayer = player;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public int getKillPlayer() {
        return killPlayer;
    }

    public void setKillPlayer(int killPlayer) {
        this.killPlayer = killPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
