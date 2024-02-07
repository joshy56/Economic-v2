package io.github.joshy56.subject;

import io.github.joshy56.response.Response;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author joshy56
 * @since 3/2/2024
 */
public interface SubjectRepository {
    Response<Subject> get(UUID identifier);
    Response<TransactionalSubject> get(UUID identifier, SubjectAttributes... needed);
    Response<List<Subject>> getThey(Set<UUID> identifiers);
    Response<List<TransactionalSubject>> getThey(Set<UUID> identifiers, SubjectAttributes... needed);
    Response<List<Subject>> getAll();
    Response<List<TransactionalSubject>> getAll(SubjectAttributes... needed);
    Response<Boolean> delete(UUID identifier);
    Response<Boolean> deleteThey(Set<UUID> identifiers);
    Response<Boolean> deleteAll();
    Response<Boolean> set(Subject subject);
    Response<Boolean> setAll(Set<Subject> subjects);
}
