package com.barrowts.nw.logback;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;

import com.sap.tc.logging.Location;

public class NWLogAppender<E> extends AppenderBase<E> {
	
	private Layout<E> layout;
	
	@Override
	protected void append(E eventObject) {
		String msg = layout.doLayout(eventObject);
		Location location = getLocation(eventObject);
		performLogging(location, eventObject, msg);
	}

	public Layout<E> getLayout() {
		return layout;
	}

	public void setLayout(Layout<E> layout) {
		this.layout = layout;
	}
	
	private Location getLocation(E eventObject) {
		if (eventObject instanceof ILoggingEvent) {
			ILoggingEvent le = (ILoggingEvent)eventObject;
			return Location.getLocation(le.getLoggerName());
		}
		return Location.getLocation("root");
	}

	private void performLogging(Location location, E eventObject, String msg) {
		if (eventObject instanceof ILoggingEvent) {
			Level level = ((ILoggingEvent)eventObject).getLevel();
			switch (level.toInt()) {
			case Level.DEBUG_INT:
				location.debugT(msg);
				break;
			case Level.INFO_INT:
				location.infoT(msg);
				break;
			case Level.WARN_INT:
				location.warningT(msg);
				break;
			case Level.ERROR_INT:
				location.errorT(msg);
				break;
			default:
				location.infoT(msg);		
			}
		}
		else {
			// What should it do here?
		}
	}
}
