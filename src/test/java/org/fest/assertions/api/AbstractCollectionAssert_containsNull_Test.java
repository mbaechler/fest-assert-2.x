/*
 * Created on Sep 30, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.api;

import static java.util.Collections.emptyList;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.*;

import org.junit.*;

import org.fest.assertions.internal.Iterables;

/**
 * Tests for <code>{@link AbstractIterableAssert#containsNull()}</code>.
 *
 * @author Joel Costigliola
 */
public class AbstractCollectionAssert_containsNull_Test {

  private Iterables collections;
  private ConcreteCollectionAssert assertions;

  @Before public void setUp() {
    collections = mock(Iterables.class);
    assertions = new ConcreteCollectionAssert(emptyList());
    assertions.iterables = collections;
  }

  @Test public void should_verify_that_actual_contains_null() {
    assertions.containsNull();
    verify(collections).assertContainsNull(assertions.info, assertions.actual);
  }

  @Test public void should_return_this() {
    ConcreteCollectionAssert returned = assertions.containsNull();
    assertSame(assertions, returned);
  }
}
