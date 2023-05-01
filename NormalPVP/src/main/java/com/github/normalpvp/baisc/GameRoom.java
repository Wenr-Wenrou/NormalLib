package com.github.normalpvp.baisc;


/*
*
* 游戏房间基类
*
*
* */
public class GameRoom {
    private int roomId;
    private int roomMaxPlayer;
    private int startGameMember;
    private int starCountdown;

    public GameRoom(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomMaxPlayer() {
        return roomMaxPlayer;
    }

    public void setRoomMaxPlayer(int roomMaxPlayer) {
        this.roomMaxPlayer = roomMaxPlayer;
    }

    public int getStartGameMember() {
        return startGameMember;
    }

    public void setStartGameMember(int startGameMember) {
        this.startGameMember = startGameMember;
    }

    public int getStarCountdown() {
        return starCountdown;
    }

    public void setStarCountdown(int starCountdown) {
        this.starCountdown = starCountdown;
    }
}
