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
package net.kuujo.copycat.collections.internal.lock;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous lock proxy.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public interface AsyncLockProxy {

  /**
   * Acquires the lock.
   *
   * @param member The member locking the lock.
   * @param thread The thread locking the lock.
   * @return A completable future to be completed once the lock has been acquired.
   */
  CompletableFuture<Boolean> lock(String member, long thread);

  /**
   * Releases the lock.
   *
   * @param member The member unlocking the lock.
   * @param thread The thread unlocking the lock.
   * @return A completable future to be completed once the lock has been released.
   */
  CompletableFuture<Void> unlock(String member, long thread);

}
