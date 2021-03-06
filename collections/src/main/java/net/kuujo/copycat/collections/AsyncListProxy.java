/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.collections;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous list proxy.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public interface AsyncListProxy<T> extends AsyncCollectionProxy<T> {

  /**
   * Gets a entry at a specific index in the list.
   *
   * @param index The index of the entry to get.
   * @return A completable future to be completed with the result once complete.
   */
  CompletableFuture<T> get(int index);

  /**
   * Sets an index in the list.
   *
   * @param index The index to set.
   * @param value The entry to set.
   * @return A completable future to be completed with the result once complete.
   */
  CompletableFuture<T> set(int index, T value);

  /**
   * Adds a value at an index in the list.
   *
   * @param index The index at which to add the value.
   * @param value The value to add.
   * @return A completable future to be completed with the result once complete.
   */
  CompletableFuture<Void> add(int index, T value);

  /**
   * Adds a collection of values at an index in the list.
   *
   * @param index The index at which to add the values.
   * @param values The values to add.
   * @return A completable future to be completed with the result once complete.
   */
  CompletableFuture<Boolean> addAll(int index, Collection<? extends T> values);

  /**
   * Removes an index in the list.
   *
   * @param index The index to remove.
   * @return A completable future to be completed with the result once complete.
   */
  CompletableFuture<T> remove(int index);

}
