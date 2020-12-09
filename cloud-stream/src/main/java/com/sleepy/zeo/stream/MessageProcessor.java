package com.sleepy.zeo.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageProcessor {

    String MESSAGE_OUTPUT = "message_output";
    String MESSAGE_INPUT = "message_input";
    String LOG_OUTPUT = "log_output";
    String LOG_INPUT = "log_input";
    String USER_OUTPUT = "user_output";
    String USER_INPUT = "user_input";

    @Output(MESSAGE_OUTPUT)
    MessageChannel messageOutput();

    @Input(MESSAGE_INPUT)
    SubscribableChannel messageInput();

    @Output(LOG_OUTPUT)
    MessageChannel logOutput();

    @Input(LOG_INPUT)
    SubscribableChannel logInput();

    @Output(USER_OUTPUT)
    MessageChannel userOutput();

    @Input(USER_INPUT)
    SubscribableChannel userInput();
}
