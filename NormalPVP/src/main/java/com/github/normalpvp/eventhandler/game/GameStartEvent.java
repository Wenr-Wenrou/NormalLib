package com.github.normalpvp.eventhandler.game;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/*
*
* 游戏开始事件，细节后期实现
* */
public class GameStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }

}
