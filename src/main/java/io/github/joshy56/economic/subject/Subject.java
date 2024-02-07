package io.github.joshy56.economic.subject;

import io.github.joshy56.economic.response.Response;

import java.util.UUID;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface Subject {
    UUID identifer();
    Response<String> nickname();
    Response<String> nickname(String name);
}
