package io.github.joshy56.subject;

import io.github.joshy56.response.Response;

import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface SubjectRepository {

    /**
     *
     * @param identifier
     * @return
     */
    Response<Subject> get(UUID identifier);

    /**
     *
     * @param identifier
     * @param needed
     * @return
     */
    Response<TransactionalSubject> get(UUID identifier, SubjectAttributes... needed);

    /**
     *
     * @param identifiers
     * @return
     */
    Response<Set<Subject>> getThey(Set<UUID> identifiers);

    /**
     *
     * @param identifiers
     * @param needed
     * @return
     */
    Response<Set<TransactionalSubject>> getThey(Set<UUID> identifiers, SubjectAttributes... needed);

    /**
     *
     * @return
     */
    Response<Set<Subject>> getAll();

    /**
     *
     * @param needed
     * @return
     */
    Response<Set<TransactionalSubject>> getAll(SubjectAttributes... needed);

    /**
     *
     * @param identifier
     * @return
     */
    Response<Boolean> delete(UUID identifier);

    /**
     *
     * @param identifiers
     * @return
     */
    Response<Boolean> deleteThey(Set<UUID> identifiers);

    /**
     *
     * @return
     */
    Response<Boolean> deleteAll();

    /**
     *
     * @param subject
     * @return
     */
    Response<Boolean> set(Subject subject);

    /**
     *
     * @param subjects
     * @return
     */
    Response<Boolean> setAll(Set<Subject> subjects);
}
