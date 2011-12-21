/*
 * Created on Jan 14, 2011
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
package org.fest.assertions.internal;

import static org.fest.assertions.test.TestData.someInfo;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import org.fest.assertions.core.AssertionInfo;

/**
 * Tests for <code>{@link Doubles#assertIsNotNan(AssertionInfo, Double)}</code>.
 * 
 * @author Yvonne Wang
 * @author Joel Costigliola
 */
public class Doubles_assertIsNotNaN_Test {

  private Doubles doubles;

  @Before
  public void setUp() {
    doubles = new Doubles();
  }

  @Test
  public void should_succeed_since_actual_is_not_equal_to_NaN() {
    doubles.assertIsNotNaN(someInfo(), 6d);
  }

  @Test
  public void should_fail_since_actual_is_not_equal_to_NaN() {
    try {
      doubles.assertIsNotNaN(someInfo(), 6d);
    } catch (AssertionError e) {
      assertEquals(e.getMessage(), "<6.0> should not be equal to:<NaN>");
    }
  }
}