package DAO;

import beans.Membre;
import beans.Notification;

import java.util.Vector;

public interface NotificationDao {

    Vector<Object> getAll(String membre) ;
    Vector<Object> syncroNotification(String membre ,int pub);

}
