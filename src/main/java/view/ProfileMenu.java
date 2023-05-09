package view;

import controller.ProfileController;
import model.User;
import view.Commands.*;
import view.Messages.ProfileMenuMessage;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu {
    public static void run(Scanner scanner) throws IOException {
        String command;
        Matcher matcher;
        while (true) {
            command = scanner.nextLine();
            if ((matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_USERNAME_CHANGE)) != null) {
                changingUsername(matcher.group("username").replaceAll("\"", ""));
            } else if ((matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_NICKNAME_CHANGE)) != null) {
                changingNickname(matcher.group("nickname").replaceAll("\"", ""));
            } else if ((matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_PASSWORD_CHANGE)) != null) {
                changingPassword(command, scanner);
            } else if ((matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_EMAIL_CHANGE)) != null) {
                changingEmail(matcher.group("email").replaceAll("\"", ""));
            } else if ((matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_SLOGAN_CHANGE)) != null) {
                changeSlogan(command);
            } else if (command.matches("\\s*profile\\s+display\\s+highscore\\s*")) {
                System.out.println(ProfileController.showHighScore());
            } else if (command.matches("\\s*profile\\s+display\\s+rank\\s*")) {
                System.out.println(ProfileController.showRank());
            } else if (command.matches("\\s*profile\\s+display\\s+slogan\\s*")) {
                System.out.println(ProfileController.showSlogan());
            } else if (command.matches("profile display")) {
                System.out.println(ProfileController.showDisplay());
            } else if (command.matches("\\s*profile\\s+remove\\s+slogan")) {
                System.out.println(ProfileController.removeSlogan());
            }else if(command.matches("\\s*exit\\s*")){
                System.out.println("exit");
                return;
            }
            //TODO : exit has bug
            else {
                System.out.println("invalid command!");
            }
        }

    }

    private static void changeSlogan(String command) throws IOException {
        String result = null;
        Matcher matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_SLOGAN_CHANGE);
        if (matcher != null) result = matcher.group("slogan").replaceAll("\"", "");
        ProfileController.changeSlogan(result);
        System.out.println("done!");


    }

    private static void changingEmail(String newEmail) throws IOException {
        ProfileMenuMessage message = ProfileController.changeEmail(newEmail);
        switch (message) {
            case SUCCESS:
                System.out.println("email changed!");
                return;
            case INVALID_FORM_EMAIL:
                System.out.println("your form of email is invalid!");
                return;
        }
    }

    private static void changingUsername(String username) throws IOException {
        ProfileMenuMessage message = ProfileController.changeUsername(username);
        switch (message) {
            case INVALID_FORM_USERNAME:
                System.out.println("invalid form of username");
                return;
            case SUCCESS:
                System.out.println("username changed successfully");
                return;
        }
    }

    private static void changingNickname(String nickname) throws IOException {
        ProfileMenuMessage message = ProfileController.changeNickname(nickname);
        System.out.println("nickname changed successfully");
    }

    private static void changingPassword(String command, Scanner scanner) throws IOException {
        Matcher matcher;
        String oldPassword;
        String newPassword;
        matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_GET_OLD_PASSWORD);
        if (matcher != null) oldPassword = matcher.group("old");
        else {
            System.out.println("Please do this correctly");
            return;
        }
        matcher = ProfileMenuCommands.getMatcher(command, ProfileMenuCommands.PROFILE_GET_NEW_PASSWORD);
        if (matcher != null) newPassword = matcher.group("new");
        else {
            System.out.println("Please do this correctly");
            return;
        }
        System.out.println(newPassword + "    " + oldPassword);
        ProfileMenuMessage message = ProfileController.changingPasswordErrorHandelling(oldPassword, newPassword);
        switch (message) {
            case INCORRECT_PASSWORD:
                System.out.println("Current password is incorrect!");
                return;
            case WEAK_PASSWORD_FOR_LOWERCASE:
                System.out.println("your new password must have lovercase chars");
                return;
            case WEAK_PASSWORD_FOR_UPPERCASE:
                System.out.println("your new password must have uppercase chars");
                return;
            case SIMILAR_PASSWORD:
                System.out.println("Please enter a new password!");
                return;
            case SUCCESS:
                System.out.println("please enter your new password again!");
                String answer = scanner.nextLine();
                while (!answer.equals(newPassword)) {
                    System.out.println("Please enter your new password again!");
                    answer = scanner.nextLine();
                }
                ProfileController.changePassword(answer);
                System.out.println("Password changed successfully");
                return;

        }

    }
}
