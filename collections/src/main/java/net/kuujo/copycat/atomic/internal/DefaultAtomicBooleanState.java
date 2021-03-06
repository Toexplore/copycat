/*
 * Copyright 2015 the original author or authors.
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
package net.kuujo.copycat.atomic.internal;

import net.kuujo.copycat.state.StateContext;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Default atomic boolean state implementation.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class DefaultAtomicBooleanState implements AtomicBooleanState {
  private AtomicBoolean value;

  @Override
  public void init(StateContext<AtomicBooleanState> context) {
    value = context.get("value");
    if (value == null) {
      value = new AtomicBoolean();
      context.put("value", value);
    }
  }

  @Override
  public boolean get() {
    return this.value.get();
  }

  @Override
  public void set(boolean value) {
    this.value.set(value);
  }

  @Override
  public boolean getAndSet(boolean value) {
    return this.value.getAndSet(value);
  }

  @Override
  public boolean compareAndSet(boolean expect, boolean update) {
    return this.value.compareAndSet(expect, update);
  }

}
