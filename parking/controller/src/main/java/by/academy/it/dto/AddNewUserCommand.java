package by.academy.it.dto;

import lombok.Data;

@Data
public class AddNewUserCommand {

    private String name;
    private String secondName;
    private String command;
    private String login;
    private String password;
}
