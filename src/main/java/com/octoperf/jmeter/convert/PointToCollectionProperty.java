package com.octoperf.jmeter.convert;

import com.octoperf.jmeter.model.ThreadGroupPoint;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.apache.jmeter.testelement.property.LongProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.octoperf.jmeter.model.ThreadGroupPoint.THREADS_COUNT;
import static com.octoperf.jmeter.model.ThreadGroupPoint.TIME_IN_MS;

/**
 * Converts a ThreadGroupPoint into a CollectionProperty
 *
 * @author Gérald Pereira
 */
final class PointToCollectionProperty implements Function<ThreadGroupPoint, CollectionProperty> {

  public CollectionProperty apply(final ThreadGroupPoint point) {
    final LongProperty timeInMs = new LongProperty(TIME_IN_MS, point.getTimeInMs());
    final LongProperty threadsCount = new LongProperty(THREADS_COUNT, point.getThreadsCount());
    final List<LongProperty> properties = new ArrayList<>();
    properties.add(timeInMs);
    properties.add(threadsCount);
    return new CollectionProperty(point.toString(), properties);
  }

}
