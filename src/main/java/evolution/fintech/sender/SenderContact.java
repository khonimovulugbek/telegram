package evolution.fintech.sender;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Getter
@Setter
@Builder
public class SenderContact implements GeneralSender{
    private Long chatId;
    private ReplyKeyboard reply;
    private Integer replyMessageId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Override
    public MessageType getType() {
        return MessageType.SEND_CONTACT;
    }
}
