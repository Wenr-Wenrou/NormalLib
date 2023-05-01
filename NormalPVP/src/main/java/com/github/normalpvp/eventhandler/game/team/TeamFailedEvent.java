package com.github.normalpvp.eventhandler.game.team;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
/*
* 队伍回合失败事件，细节后期实现
*
* */
public class TeamFailedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }
}
