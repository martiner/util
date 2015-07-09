package cz.geek.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorsMatchers {
	
	private static boolean hasErrorCode(List<? extends ObjectError> errors, String code) {
		for (ObjectError i : errors)
			if (i.getCode().equals(code))
				return true;
		return false;
	}
	
	public static boolean hasFieldErrorCode(Errors errors, String code) {
		return hasErrorCode(errors.getFieldErrors(), code);
	}

	public static boolean hasGlobalErrorCode(Errors errors, String code) {
		return hasErrorCode(errors.getGlobalErrors(), code);
	}
	
	public static boolean hasErrorCode(Errors errors, String code) {
		return hasFieldErrorCode(errors, code) || hasGlobalErrorCode(errors, code);
	}

	@Factory
	public static Matcher<Errors> hasFieldError(String field, String code) {
		return new FieldMatcher(field, code);
	}

	private static class FieldMatcher extends TypeSafeMatcher<Errors> {

		private final String field;
		private final String code;

		private FieldMatcher(String field, String code) {
			this.field = field;
			this.code = code;
		}

		@Override
		public boolean matchesSafely(Errors errors) {
			for (FieldError i: errors.getFieldErrors())
				if (i.getCode().equals(code) && i.getField().equals(field))
					return true;
			return false;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("Error field='" + field + "' code='" + code + "'");
		}

		@Override
		protected void describeMismatchSafely(Errors errors, Description description) {
			final List<String> values = new ArrayList<String>(errors.getFieldErrorCount());
			for (FieldError i: errors.getFieldErrors()) {
				values.add("field='" + i.getField() + "' code='" + i.getCode() + "'");
			}
			description.appendText(values.toString());
		}
	}
}