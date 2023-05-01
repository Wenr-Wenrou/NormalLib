package com.github.normalpvp.baisc;
import com.sun.istack.internal.Nullable;
import org.bukkit.entity.Player;

import java.util.*;

/*
* 聊天频带类，使用上一版源码
*
* */
public class ChatChanel
{
    private static HashMap<String,ChatChanel> chanels = new HashMap<>();
    public static void removeChanel(String id){chanels.remove(id);}
    public static HashMap<String, ChatChanel> getChanels() {return chanels;}

    private final String chanel;
    private int maxChat = 50;
    public class Chat
    {
        private final String from;
        private final String uuid = UUID.randomUUID().toString();
        private final Date date = new Date();
        private String text;
        public Chat(String from, String text) {this.from = from;this.text = text;}

        public String getFrom() {return from;}
        public String getUuid() {return uuid;}
        public Date getDate() {return date;}
        public String getText() {return text;}
    }

    private List<Chat> chats = new ArrayList<>();

    protected ChatChanel(String chanel)
    {
        this.chanel = chanel;
    }

    @Nullable
    public Chat removeChat(String uuid)
    {
        for(Chat c : chats)
            if(c.getUuid().equals(uuid))
            {
                chats.remove(c);
                return c;
            }
        return null;
    }

    @Nullable
    public Chat removeChatFromText(String text) {
        for(Chat c : chats)
            if(c.getText().equals(text))
            {
                chats.remove(c);
                return c;
            }
        return null;
    }

    public List<Chat> removeChatFromFrom(String from)
    {
        List<Chat> l = new ArrayList<>();
        for(Chat c : chats)
            if(c.getFrom().equals(from))
                l.add(c);
        return l;
    }

    public Chat newChat(Player from , String text) {
        return newChat(from.getPlayer(),text);
    }
    public Chat newChat(String from , String text) {
        if(chats.size()>=maxChat)chats.remove(0);

        Chat c = new Chat(from,text);chats.add(c);
        return c;
    }

    public static ChatChanel create(String id)
    {
        ChatChanel c = new ChatChanel(id);
        chanels.put(id,c);
        return c;
    }

    public List<Chat> getChats() {
        return chats;
    }
    public String getChanel() {return chanel;}
    public int getMaxChat() {return maxChat;}
    public ChatChanel setMaxChat(int maxChat) {this.maxChat = maxChat;return this;}
}
