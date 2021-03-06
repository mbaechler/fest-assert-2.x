/*
 * Created on Dec 24, 2010
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

import static org.fest.assertions.error.ShouldBeCloseTo.shouldBeCloseTo;
import static org.fest.assertions.test.ErrorMessages.dateToCompareActualWithIsNull;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.assertions.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.*;

import org.fest.assertions.core.AssertionInfo;

/**
 * Tests for <code>{@link Dates#assertIsCloseTo(AssertionInfo, Date, Date, long)}</code>.
 *
 * @author Joel Costigliola
 */
public class Dates_assertIsCloseTo_Test extends AbstractDatesTest {

  private Date other;
  private int delta;

  @Override
  @Before
  public void setUp() {
    super.setUp();
    actual = parseDatetime("2011-01-01T03:15:05");
    delta = 100;
    other = new Date(actual.getTime() + delta + 1);
  }

  @Test
  public void should_fail_if_actual_is_not_close_to_given_date_by_less_than_given_delta() {
    AssertionInfo info = someInfo();
    try {
      dates.assertIsCloseTo(info, actual, other, delta);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeCloseTo(actual, other, delta, 101));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_throw_error_if_given_date_is_null() {
    thrown.expectNullPointerException(dateToCompareActualWithIsNull());
    dates.assertIsCloseTo(someInfo(), actual, null, 10);
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    dates.assertIsCloseTo(someInfo(), null, parseDate("2010-01-01"), 10);
  }

  @Test
  public void should_pass_if_actual_is_close_to_given_date_by_less_than_given_delta() {
    dates.assertIsCloseTo(someInfo(), actual, parseDatetime("2011-01-01T03:15:05"), delta);
  }

}
