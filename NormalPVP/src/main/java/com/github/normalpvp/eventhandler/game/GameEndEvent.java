package com.github.normalpvp.eventhandler.game;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/*
*
* 游戏结束事件，细节后期实现
* */
public class GameEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }
}
