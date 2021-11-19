
package messengerserver.API;

import messengerserver.*;
import messengerserver.db.DbHandler;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/getMessages")
public class GetMessages {


    @GetMapping
    public GetMessagesResponse doTask(@RequestParam(name = "token") String user_token, @RequestParam(name = "chat_id") String chat_id) {
        try {
            DbHandler dbHandler = DbHandler.getInstance();
            User user = dbHandler.getUserByToken(user_token);
            if (user == null)
                return new GetMessagesResponse("token error", 409,new ArrayList<Message>());

            Chat chat = dbHandler.getChatById(chat_id);
            if (chat == null)
                return new GetMessagesResponse("chat id error", 409, new ArrayList<Message>());

            if (chat.participants.contains(user.login))
                return new GetMessagesResponse(Application.SUCCESS_STATUS, 200, chat.messages);

            return new GetMessagesResponse(Application.SUCCESS_STATUS, 200, new ArrayList<Message>());

        } catch (SQLException e) {
            e.printStackTrace();
            return new GetMessagesResponse(Application.FAILED_STATUS, 500, new ArrayList<Message>());
        }


    }


}









