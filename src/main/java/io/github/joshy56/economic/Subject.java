package io.github.joshy56.economic;

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
