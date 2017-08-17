package pl.igafalkowska.service;

import pl.igafalkowska.database.Database;
import pl.igafalkowska.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {


    private static Map<Long, Message> messages = Database.getMessages();



    public MessageService() {
        messages.put(1l, new Message(1l, "Hello", "a"));
        messages.put(2l, new Message(2l, "Hello", "a"));
    }

    public List<Message> getMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        } else {
            messages.put(message.getId(), message);
            return message;
        }
    }

    public void deleteMessage(long id) {
        messages.remove(id);
    }

}
