/*
 * Created on Oct 17, 2010
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

import static org.fest.assertions.util.ArrayWrapperList.wrap;

import java.util.*;

/**
 * Creates an error message indicating that an assertion that verifies a group of elements is sorted failed.<br>
 * A group of elements can be a collection or an array.
 * 
 * @author Joel Costigliola
 */
public class ShouldBeSorted extends BasicErrorMessageFactory {
  // TODO FEST-64

  /**
   * Creates a new <code>{@link ShouldBeSorted}</code>.
   * @param i the index of elements whose not naturally ordered with the next.
   * @param group the actual group in the failed assertion (either collection or an array).
   * @return an instance of {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeSorted(int i, Object group) {
    List<?> groupAsList = groupAsList(group);
    return new ShouldBeSorted(
        "group is not sorted because element %s:<%s> is not less or equal than element %s:<%s>, group was:<%s>", i,
        groupAsList.get(i), i + 1, groupAsList.get(i + 1), groupAsList);
  }

  public static ErrorMessageFactory shouldBeSortedAccordingToGivenComparator(int i, Object group,
      Comparator<?> comparator) {
    List<?> arrayWrapper = groupAsList(group);
    return new ShouldBeSorted(
        "group is not sorted according to %s comparator because element %s:<%s> is not less or equal than element %s:<%s>, group was:<%s>",
        comparator, i, arrayWrapper.get(i), i + 1, arrayWrapper.get(i + 1), arrayWrapper);
  }

  public static ErrorMessageFactory shouldHaveMutuallyComparableElements(Object actual) {
    return new ShouldBeSorted("some elements are not mutually comparable in group:<%s>", actual);
  }

  public static ErrorMessageFactory shouldHaveComparableElementsAccordingToGivenComparator(Object actual,
      Comparator<?> comparator) {
    return new ShouldBeSorted("some elements are not mutually comparable according to %s comparator in group:<%s>",
        comparator, actual);
  }

  private ShouldBeSorted(String format, Object... arguments) {
    super(format, arguments);
  }

  /**
   * Convert the given group (which is either an array or a Collection) to a List.
   * @param group the group to convert
   * @return the corresponding List
   * @throws IllegalArgumentException if group can't be converted to a List
   */
  @SuppressWarnings("unchecked")
  private static List<?> groupAsList(Object group) {
    if (group.getClass().isArray()) {
      return wrap(group);
    } else if (group instanceof Collection<?>) {
      List<Object> asList = new ArrayList<Object>();
      asList.addAll(((Collection<Object>) group));
      return asList;
    }
    throw new IllegalArgumentException("Parameter should be an array or a collection but was " + group);
  }

}
