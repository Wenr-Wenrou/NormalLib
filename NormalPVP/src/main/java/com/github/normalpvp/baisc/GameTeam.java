package com.github.normalpvp.baisc;

import java.util.ArrayList;
import java.util.List;

/*
* 游戏队伍基类
*
* */
public class GameTeam {
    private List<GamePlayer> teamPlayerList;
    private int teamScore;
    private int teamKill;
    private int maxTeamMember;
    private String teamName;
    private int gameVictoryCount;
    private boolean friendlyDamage;

    public GameTeam(int teamScore, int teamKill, int maxTeamMember, String teamName, int gameVictoryCount, boolean friendlyDamage) {
        this.teamPlayerList = new ArrayList<>();
        this.teamScore = teamScore;
        this.teamKill = teamKill;
        this.maxTeamMember = maxTeamMember;
        this.teamName = teamName;
        this.gameVictoryCount = gameVictoryCount;
        this.friendlyDamage = friendlyDamage;
    }

    public void addPlayerToTeam(GamePlayer gamePlayer) {
        teamPlayerList.add(gamePlayer);
    }

    public void removePlayerFromTeam(GamePlayer gamePlayer) {
        teamPlayerList.remove(gamePlayer);
    }

    public List<GamePlayer> getTeamPlayerList() {
        return teamPlayerList;
    }

    public void setTeamPlayerList(List<GamePlayer> teamPlayerList) {
        this.teamPlayerList = teamPlayerList;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public int getTeamKill() {
        return teamKill;
    }

    public void setTeamKill(int teamKill) {
        this.teamKill = teamKill;
    }

    public int getMaxTeamMember() {
        return maxTeamMember;
    }

    public void setMaxTeamMember(int maxTeamMember) {
        this.maxTeamMember = maxTeamMember;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGameVictoryCount() {
        return gameVictoryCount;
    }

    public void setGameVictoryCount(int gameVictoryCount) {
        this.gameVictoryCount = gameVictoryCount;
    }

    public boolean isFriendlyDamage() {
        return friendlyDamage;
    }

    public void setFriendlyDamage(boolean friendlyDamage) {
        this.friendlyDamage = friendlyDamage;
    }
}
