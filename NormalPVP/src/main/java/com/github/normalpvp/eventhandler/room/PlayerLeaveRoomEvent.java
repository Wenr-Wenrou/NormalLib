package com.github.normalpvp.eventhandler.room;

import com.github.normalpvp.baisc.GamePlayer;
import com.github.normalpvp.baisc.GameRoom;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/*
* 玩家离开房间事件
*
* */
public class PlayerLeaveRoomEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }

    private GamePlayer gamePlayer;
    private GameRoom leavedRoom;

    public PlayerLeaveRoomEvent(GameRoom leavedRoom, GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        this.leavedRoom = leavedRoom;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public GameRoom getLeavedRoom() {
        return leavedRoom;
    }

    public void setLeavedRoom(GameRoom leavedRoom) {
        this.leavedRoom = leavedRoom;
    }
}
