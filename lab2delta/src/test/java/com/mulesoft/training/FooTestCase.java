package com.mulesoft.training;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class FooTestCase extends FunctionalTestCase {
	
	@Test
	public void testDeltaResponse() throws Exception {
		 MuleClient client = muleContext.getClient(); 
		   Map<String, Object> headers = new HashMap<String, Object>();
		   headers.put("http.method","GET");
		   MuleMessage response = 
				client.send("http://localhost:8081/delta","",headers,10000);
		   String mystr = response.getPayloadAsString();
		   
		   Assert.assertEquals("<?xml version='1.0' encoding='UTF-8'?><ns2:findFlightResponse xmlns:ns2=\"http://training.mulesoft.com/\"><return><airlineName>Delta</airlineName><code>A1B2C3</code><departureDate>2015/03/20</departureDate><destination>SFO</destination><emptySeats>40</emptySeats><origin>MUA</origin><planeType>Boing 737</planeType><price>400.0</price></return><return><airlineName>Delta</airlineName><code>A1BTT4</code><departureDate>2015/02/12</departureDate><destination>SFO</destination><emptySeats>30</emptySeats><origin>MUA</origin><planeType>Boing 777</planeType><price>593.0</price></return><return><airlineName>Delta</airlineName><code>A14244</code><departureDate>2015/02/12</departureDate><destination>SFO</destination><emptySeats>10</emptySeats><origin>MUA</origin><planeType>Boing 787</planeType><price>294.0</price></return></ns2:findFlightResponse>", mystr);
	}
	
	@Test
	public void testUnitedResponse() throws Exception {
		 MuleClient client = muleContext.getClient(); 
		   Map<String, Object> headers = new HashMap<String, Object>();
		   headers.put("http.method","GET");
		   MuleMessage response = 
				client.send("http://localhost:8081/united","",headers,10000);
		   String mystr = response.getPayloadAsString();
		   
		   Assert.assertEquals("[{\"airlineName\":\"United\",\"price\":400,\"departureDate\":\"2015/03/20\",\"planeType\":\"Boing 737\",\"origin\":\"MUA\"," +
		   		"\"emptySeats\":0,\"code\":\"ER38sd\",\"destination\":\"SFO\"},{\"airlineName\":\"United\",\"price\":945,\"departureDate\":\"2015/09/11\"," +
		   		"\"planeType\":\"Boeing 757\",\"origin\":\"MUA\",\"emptySeats\":54,\"code\":\"ER39rk\",\"destination\":\"SFO\"},{\"airlineName\":\"United\"," +
		   		"\"price\":954,\"departureDate\":\"2015/02/12\",\"planeType\":\"Boing 777\",\"origin\":\"MUA\",\"emptySeats\":23,\"code\":\"ER39rj\"," +
		   		"\"destination\":\"SFO\"}]", mystr);
	}		   
	
	@Override
	protected String[] getConfigFiles() {
	    return new String[]{"lab3.xml", "lab3.1.xml", "lab2delta.xml"};
	}
	
}
