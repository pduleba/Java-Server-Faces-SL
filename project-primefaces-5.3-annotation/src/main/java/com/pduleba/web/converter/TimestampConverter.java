package com.pduleba.web.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Timestamp.class, value="TimestampConverter")
public class TimestampConverter implements Converter {

	private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		try {
			return Objects.nonNull(value) ? new Timestamp(TIMESTAMP_FORMAT.parse(value).getTime()) : null;
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		return value instanceof Timestamp ? TIMESTAMP_FORMAT.format((Timestamp) value) : null;
	}

}
