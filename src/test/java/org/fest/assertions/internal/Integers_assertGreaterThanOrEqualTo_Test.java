/*
 * Created on Oct 20, 2010
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
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldBeGreaterOrEqual.shouldBeGreaterOrEqual;
import static org.fest.assertions.test.ExpectedException.none;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.assertions.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.mockito.Mockito.*;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.test.ExpectedException;
import org.junit.*;

/**
 * Tests for <code>{@link Integers#assertGreaterThanOrEqualTo(AssertionInfo, Integer, int)}</code>.
 *
 * @author Alex Ruiz
 */
public class Integers_assertGreaterThanOrEqualTo_Test {

  @Rule public ExpectedException thrown = none();

  private Failures failures;
  private Integers integers;

  @Before public void setUp() {
    failures = spy(new Failures());
    integers = new Integers();
    integers.failures = failures;
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    integers.assertGreaterThanOrEqualTo(someInfo(), null, 8);
  }

  @Test public void should_pass_if_actual_is_greater_than_other() {
    integers.assertGreaterThanOrEqualTo(someInfo(), 8, 6);
  }

  @Test public void should_pass_if_actual_is_equal_to_other() {
    integers.assertGreaterThanOrEqualTo(someInfo(), 6, 6);
  }

  @Test public void should_fail_if_actual_is_less_than_other() {
    AssertionInfo info = someInfo();
    try {
      integers.assertGreaterThanOrEqualTo(info, 6, 8);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeGreaterOrEqual(6, 8));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
}
