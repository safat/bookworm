package net.therap.domain;

import net.therap.domain.enums.NotificationType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14 4:27 PM
 */

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sender_id")
    private User sender;

    @Column(name = "receiver_id")
    private User receiver;

    @Column(name = "type")
    private NotificationType type;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @Column(name = "is_seen")
    private boolean isSeen;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }
}