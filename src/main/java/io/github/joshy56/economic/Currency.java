package io.github.joshy56.economic;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface Currency {
    String name();
    Response<String> displayName();
    Response<String> displayName(String displayName);
    Response<String> displayNamePlural();
    Response<String> displayNamePlural(String displayNamePlural);
    Response<String> abbreviation();
    Response<String> abbreviation(String abbreviation);
    Response<Character> symbol();
    Response<Character> symbol(char symbol);
}
