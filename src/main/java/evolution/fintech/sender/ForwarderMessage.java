package evolution.fintech.sender;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 10.12.2022
 * Time : 8:25 AM
 */

@Getter
@Setter
@Builder
public class ForwarderMessage implements GeneralSender {
    private Long chatId;
    private Long fromChatId;
    private List<Integer> messagesId;

    @Override
    public MessageType getType() {
        return MessageType.FORWARD_MESSAGE;
    }
}