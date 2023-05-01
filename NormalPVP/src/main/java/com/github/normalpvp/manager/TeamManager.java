package com.github.normalpvp.manager;

import com.github.normalpvp.baisc.GameTeam;

import java.util.HashMap;
import java.util.Map;
/*
* 队伍管理器
* */
public class TeamManager {
    private Map<Integer, GameTeam> teams = new HashMap<>();

    public void addTeam(int id, GameTeam team) {
        teams.put(id, team);
    }

    public void removeTeam(int id) {
        teams.remove(id);
    }

    public GameTeam searchTeamById(int id) {
        return teams.get(id);
    }

    public Map<Integer, GameTeam> getTeams() {
        return teams;
    }
}
