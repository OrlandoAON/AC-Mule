package com.mulesoft.training;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class SortFlight extends AbstractTransformer{

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		List<Flight> flights = (List<Flight>) src;
		
		Collections.sort(flights);
//		
//		Collections.sort(flights, new Comparator<Flight>() {
//
//			@Override
//			public int compare(Flight o1, Flight o2) {
//				return o1.getPrice() > o2.getPrice() ? 1 : 0;
//			}
//		});
		
		return flights;
	}
	
}
