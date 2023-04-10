package evolution.fintech.sender;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Getter
@Setter
@Builder
public class SenderMessage implements GeneralSender {

    private Long chatId;
    private String text;
    private String parseMode;
    private boolean disableWebPagePreview;
    private ReplyKeyboard reply;
    private Integer replyMessageId;


    @Override
    public MessageType getType() {
        return MessageType.SEND_MESSAGE;
    }
}
