package com.github.normalpvp.eventhandler.room;

import com.github.normalpvp.baisc.GamePlayer;
import com.github.normalpvp.baisc.GameRoom;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/*
* 玩家加入房间事件
*
* */
public class PlayerJoinRoomEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }

    private GamePlayer gamePlayer;
    private GameRoom joinedRoom;

    public PlayerJoinRoomEvent(GameRoom joinedRoom, GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        this.joinedRoom = joinedRoom;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public GameRoom getJoinedRoom() {
        return joinedRoom;
    }

    public void setJoinedRoom(GameRoom joinedRoom) {
        this.joinedRoom = joinedRoom;
    }
}
