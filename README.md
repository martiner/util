# Geek.cz Java utils

[![Build Status](https://travis-ci.org/martiner/util.png?branch=master)](https://travis-ci.org/martiner/util)

```xml
<dependency>
	<groupId>cz.geek</groupId>
	<artifactId>geek-util</artifactId>
	<version>VERSION</version>
</dependency>
```

## Examples

### Spring Validation Hamcrest Matchers

```java
class MyValidator implements Validator { ... }

MyBean bean = new MyBean();
Errors errs = new BeanPropertyBindingResult(bean, "foo");
new MyValidator().validate(bean, errs);

assertThat(errs, hasFieldError("myfield", "notnull"));
```
