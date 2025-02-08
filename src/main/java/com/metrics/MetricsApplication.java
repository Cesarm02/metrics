package com.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		CompositeMeterRegistry compositeMeter = new CompositeMeterRegistry();
		
		Counter counter = compositeMeter.counter("Numero.empleados", "oficina", "Benito Juan");
		counter.increment();
		counter.increment(200);
		
		SimpleMeterRegistry registry = new SimpleMeterRegistry();
		SimpleMeterRegistry registry2 = new SimpleMeterRegistry();

		
		compositeMeter.add(registry);
		compositeMeter.add(registry2);
		counter.increment();
		counter.increment(200);
		
		System.out.printf("Nuemro empleados %f",  counter.count());
	}
}
