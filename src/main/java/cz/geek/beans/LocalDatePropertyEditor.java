package cz.geek.beans;

import java.beans.PropertyEditorSupport;

import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

public class LocalDatePropertyEditor extends PropertyEditorSupport {
	
	private DateTimeFormatter fmt;
	
	public LocalDatePropertyEditor(String format) {
		this.fmt = DateTimeFormat.forPattern(format);
	}

	@Override
	public String getAsText() {
		return getValue() == null ? null : fmt.print((ReadablePartial) getValue());
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(StringUtils.hasText(text) ? fmt.parseDateTime(text).toLocalDate() : null);
	}
}
