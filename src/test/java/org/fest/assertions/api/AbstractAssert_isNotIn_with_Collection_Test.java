/*
 * Created on Feb 5, 2011
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
 * Copyright @2011 the original author or authors.
 */
package org.fest.assertions.api;

import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;

import org.fest.assertions.internal.Objects;

/**
 * Tests for <code>{@link AbstractAssert#isNotIn(Collection)}</code>.
 *
 * @author Yvonne Wang
 * @author Joel Costigliola
 */
public class AbstractAssert_isNotIn_with_Collection_Test {

  private static Collection<Object> values;

  private Objects objects;
  private ConcreteAssert assertions;

  @BeforeClass public static void setUpOnce() {
    values = new ArrayList<Object>();
    values.add("Yoda");
    values.add("Luke");
  }

  @Before public void setUp() {
    objects = mock(Objects.class);
    assertions = new ConcreteAssert("Yoda");
    assertions.objects = objects;
  }

  @Test public void should_verify_that_actual_is_in_Collection() {
    assertions.isNotIn(values);
    verify(objects).assertIsNotIn(assertions.info, assertions.actual, values);
  }

  @Test public void should_verify_that_actual_is_in_vararg() {
    assertions.isNotIn("Yoda", "Luke");
    verify(objects).assertIsNotIn(assertions.info, assertions.actual, new Object[] {"Yoda", "Luke"});
  }

  @Test public void should_return_this() {
    ConcreteAssert returned = assertions.isNotIn(values);
    assertSame(assertions, returned);
  }
}
