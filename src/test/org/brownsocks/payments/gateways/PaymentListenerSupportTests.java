package org.brownsocks.payments.gateways;

import org.brownsocks.payments.PaymentResult;
import org.brownsocks.payments.PaymentsListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PaymentListenerSupportTests extends TestCase {

	public PaymentListenerSupportTests() {
		super("test");
	}

	public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new PaymentListenerSupportTests());
        return suite;
    }
	
	public void test() throws Exception {
		
		DummyPaymentsListener testListener1 = new DummyPaymentsListener();
		DummyPaymentsListener testListener2 = new DummyPaymentsListener();
		DummyEventGenerator eventGenerator = new DummyEventGenerator();
		
		// send events with no listener
		eventGenerator.go();
		assertEquals(testListener1.getProcessingEventsReceived(), 0);
		assertEquals(testListener1.getReceivedEventsReceived(), 0);
		
		eventGenerator.addPaymentsListener(testListener1);
		assertEquals(testListener1.getProcessingEventsReceived(), 0);
		assertEquals(testListener1.getReceivedEventsReceived(), 0);
		
		// 1 listener
		eventGenerator.go();
		assertEquals(testListener1.getProcessingEventsReceived(), 1);
		assertEquals(testListener1.getReceivedEventsReceived(), 1);
		assertEquals(testListener2.getProcessingEventsReceived(), 0);
		assertEquals(testListener2.getReceivedEventsReceived(), 0);
		
		// 2 listeners
		eventGenerator.addPaymentsListener(testListener2);
		eventGenerator.go();
		
		assertEquals(testListener1.getProcessingEventsReceived(), 2);
		assertEquals(testListener1.getReceivedEventsReceived(), 2);
		assertEquals(testListener2.getProcessingEventsReceived(), 1);
		assertEquals(testListener2.getReceivedEventsReceived(), 1);
		
		// remove a listener
		eventGenerator.removePaymentsListener(testListener1);
		
		eventGenerator.go();
		assertEquals(testListener1.getProcessingEventsReceived(), 2);
		assertEquals(testListener1.getReceivedEventsReceived(), 2);
		assertEquals(testListener2.getProcessingEventsReceived(), 2);
		assertEquals(testListener2.getReceivedEventsReceived(), 2);
		
		// send events with a failing listener
		
		eventGenerator.addPaymentsListener(new FailingPaymentsListener());
		eventGenerator.go();
		
		assertEquals(testListener1.getProcessingEventsReceived(), 2);
		assertEquals(testListener1.getReceivedEventsReceived(), 2);
		assertEquals(testListener2.getProcessingEventsReceived(), 3);
		assertEquals(testListener2.getReceivedEventsReceived(), 3);
		
		eventGenerator.addPaymentsListener(testListener1);
		eventGenerator.go();
		
		assertEquals(testListener1.getProcessingEventsReceived(), 3);
		assertEquals(testListener1.getReceivedEventsReceived(), 3);
		assertEquals(testListener2.getProcessingEventsReceived(), 4);
		assertEquals(testListener2.getReceivedEventsReceived(), 4);
	}
	
	private static class DummyPaymentsListener implements PaymentsListener {
		private int processingEventsReceived = 0;
		private int receivedEventsReceived = 0;
		
		@Override
		public void paymentProcessing(PaymentResult result) {
			processingEventsReceived++;
		}
		@Override
		public void paymentReceived(PaymentResult result) {
			receivedEventsReceived++;
		}
		public int getProcessingEventsReceived() {
			return processingEventsReceived;
		}
		public int getReceivedEventsReceived() {
			return receivedEventsReceived;
		}
	}
	
	private static class FailingPaymentsListener implements PaymentsListener {
		@Override
		public void paymentReceived(PaymentResult result) {
			throw new OutOfMemoryError("Fake error");
		}
		
		@Override
		public void paymentProcessing(PaymentResult result) {
			throw new OutOfMemoryError("Fake error");
		}
	}
	
	private static class DummyEventGenerator extends PaymentsListenerSupport {
		public void go() {
			sendPaymentProcessingEvent(new PaymentResult());
			sendPaymentReceivedEvent(new PaymentResult());
		}
	}
	
	
}
