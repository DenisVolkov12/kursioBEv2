package ru.kursio.application.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * This are the Global Constants, the idea is to do Standardization of values and be able to use them across
 * the development. Be sure that variables and values can be re-usable everywhere in the application.
 * Created by: HUBERT ALFARO on April 28th 2019
 */
public interface Constants {
    //ENDPOINTS
    String VERSION_ONE = "/v1";
    String LOGIN_ROOT_PATH = VERSION_ONE+"/login";
    String REGISTER_ROOT_PATH = VERSION_ONE+"/register";
    String USER_ROOT_PATH = VERSION_ONE+"/user";
    String RENAT_ROOT_PATH = VERSION_ONE+"/renat";

    //SUB-ENDPOINTS
    String CHECK_USERNAME = "/isUsernameAvailable";
    String CHECK_EMAIL = "/isEmailAvailable";
    String LOGIN_FACEBOOK = "/facebook";
    String COLOR_QUIZ = "/colorQuiz";

    //ROLES
    String STUDENT_ROLE = "STUDENT";
    String TEACHER_ROLE = "TEACHER";

    //SYMBOLS AND CHARACTERS
    String WHITE_SPACE = " ";


    //ERROR CODES FOR DEV
    String MSG_INVALID_PARAM = "Invalid param(s) sent";
    String MSG_EMPTY_USERNAME = "Empty param: userName was not sent";
    String MSG_EMPTY_EMAIL = "Empty param: email was not sent";
    String MSG_RENAT_QUESTIONARY_NOT_FOUND = "No questions found";

    //ERROR CODES FOR USER
    String MSG_BAD_OR_EMPTY_JSON = "Bad or empty object sent";
    String MSG_INCORRECT_USERNAME = "Incorrect Username";
    String MSG_INCORRECT_PASSWORD = "Incorrect Password";
    String MSG_USERNAME_ALREADY_EXISTS = "Username already exists, please choose other";
    String MSG_EMAIL_ALREADY_EXISTS = "Email already exists, please choose other";
    String MSG_USERNAME_NOT_FOUND = "Username not found";
    String MSG_ERROR_SAVING_USER = "Error saving User";
    String MSG_USER_NOT_FOUND = "User not found";
    String MSG_QUESTION_NOT_FOUND = "Question not found";

    //ERROR MAP
    Map<String, Integer> ERRORS_MAP = new HashMap<String, Integer>()
    {
        {
            put(MSG_BAD_OR_EMPTY_JSON, 1);
            put(MSG_INCORRECT_USERNAME, 2);
            put(MSG_INCORRECT_PASSWORD, 3);
            put(MSG_USERNAME_ALREADY_EXISTS, 4);
            put(MSG_USERNAME_NOT_FOUND, 5);
            put(MSG_ERROR_SAVING_USER, 6);
            put(MSG_USER_NOT_FOUND, 7);
            put(MSG_EMAIL_ALREADY_EXISTS, 8);
            put(MSG_EMPTY_USERNAME, 1000000);
            put(MSG_QUESTION_NOT_FOUND, 1000001);

        }
    };


}
