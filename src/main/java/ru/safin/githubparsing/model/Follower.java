package ru.safin.githubparsing.model;

import org.springframework.stereotype.Component;

@Component
public class Follower {
    private String login;
    private String avatar_url;
    private String html_url;

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
