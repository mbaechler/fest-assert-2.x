/*
 * Created on Oct 18, 2010
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
package org.fest.assertions.error;

import org.fest.util.*;

/**
 * Creates an error message indicating that an assertion that verifies a group of elements does not contain a given set
 * of values failed. A group of elements can be a collection, an array or a {@code String}.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
// TODO FEST-64 test
public class ShouldNotContain extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldNotContain}</code>.
   * @param actual the actual value in the failed assertion.
   * @param expected values expected not to be contained in {@code actual}.
   * @param found the values in {@code expected} found in {@code actual}.
   * @param comparisonStrategy the {@link ComparisonStrategy} used to evaluate assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldNotContain(Object actual, Object expected, Object notFound,
      ComparisonStrategy comparisonStrategy) {
    return new ShouldNotContain(actual, expected, notFound, comparisonStrategy);
  }

  /**
   * Creates a new </code>{@link ShouldNotContain}</code>.
   * @param actual the actual value in the failed assertion.
   * @param expected values expected not to be contained in {@code actual}.
   * @param found the values in {@code expected} found in {@code actual}.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldNotContain(Object actual, Object expected, Object notFound) {
    return new ShouldNotContain(actual, expected, notFound, StandardComparisonStrategy.instance());
  }
  
  private ShouldNotContain(Object actual, Object expected, Object notFound, ComparisonStrategy comparisonStrategy) {
    super("expecting:<%s> not to contain:<%s> but found:<%s>%s", actual, expected, notFound, comparisonStrategy);
  }

}
