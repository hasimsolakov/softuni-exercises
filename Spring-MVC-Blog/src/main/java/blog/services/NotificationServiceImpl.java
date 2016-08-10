package blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static blog.services.NotificationServiceImpl.NotificationMessageType.ERROR;
import static blog.services.NotificationServiceImpl.NotificationMessageType.INFO;

@Service
public class NotificationServiceImpl implements NotificationService {

    public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessage";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void addInfoMessage(String msg) {
        this.addNotificationMessage(INFO, msg);
    }

    @Override
    public void addErrorMessage(String msg) {
        this.addNotificationMessage(ERROR, msg);
    }

    private void addNotificationMessage(NotificationMessageType type, String msg){
        List<NotificationMessage> notifyMessages = (List<NotificationMessage>) httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
        if (notifyMessages == null){
            notifyMessages = new ArrayList<>();
        }

        notifyMessages.add(new NotificationMessage(type, msg));
        httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyMessages);

    }

    public enum NotificationMessageType{
        INFO,
        ERROR
    }

    public class NotificationMessage{
        NotificationMessageType type;
        String text;

        public NotificationMessage(NotificationMessageType type, String text){
            this.type = type;
            this.text = text;
        }

        public NotificationMessageType getType() {
            return type;
        }

        public String getText() {
            return text;
        }
    }
}
