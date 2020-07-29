package recruitingtool.error;

import recruitingtool.exception.BusinessException;

public class UserNotFoundError extends RestError {
    private String messageKey;
    private String[] arguments;

    private UserNotFoundError() {
    }

    public UserNotFoundError(String messageKey) {
        this.messageKey = messageKey;
    }

    public UserNotFoundError(String messageKey, String... arguments) {
        this.messageKey = messageKey;
        this.arguments = arguments;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String[] getArguments() {
        return arguments;
    }

    @Override
    public BusinessException getException() {
        return new BusinessException(messageKey, arguments);
    }
}
