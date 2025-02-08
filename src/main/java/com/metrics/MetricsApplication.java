package com.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsApplication {
	public static void main(String[] args) {
		MeterRegistry register = new SimpleMeterRegistry();
		
		Counter counter = register.counter("Numero.empleados", "oficina", "Benito Juan");
		counter.increment();
		counter.increment(200);
		
		System.out.printf("Nuemro empleados %f",  counter.count());
	}
}
