package io.github.joshy56;

import io.github.joshy56.response.Response;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * @author joshy56
 * @since 5/3/2024
 */
public interface Repository<K, V> {
    /**
     * Get the value for the requested key.
     *
     * @param key
     * @return A response that can contain the value associated with the key given.
     */
    @NotNull Response<V> get(@NotNull K key);

    /**
     * Get a set of all values associated with the given set of keys.
     *
     * @param keySet Set of keys.
     * @return A response that can contain the set of values.
     */
    @NotNull Response<Set<V>> getAllOfThem(@NotNull Set<K> keySet);

    /**
     * Get a set of all values stored.
     *
     * @return A set with all values stored.
     */
    @NotNull Response<Set<V>> getAll();

    /**
     * Store the given value.
     *
     * @param value Value to be stored.
     * @return A response with a return value void.
     */
    @NotNull Response<Void> set(@NotNull V value);

    /**
     * Store the given set of values.
     *
     * @param valueSet Set of values to be stored.
     * @return A response with return value void.
     */
    @NotNull Response<Void> setAll(@NotNull Set<V> valueSet);

    /**
     * Delete the value associated with the given key.
     *
     * @param key Key of the value to be deleted.
     * @return A response with return value void.
     */
    @NotNull Response<Void> delete(@NotNull K key);

    /**
     * Delete all the values associated with the given set of keys.
     *
     * @param keySet Set of keys.
     * @return A response with return value void.
     */
    @NotNull Response<Void> deleteAllOfThem(@NotNull Set<K> keySet);

    /**
     * Delete all values stored.
     *
     * @return A response with return value void.
     */
    @NotNull Response<Void> deleteAll();
}
