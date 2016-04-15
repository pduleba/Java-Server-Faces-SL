package com.pgs.soft.workshop.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.pgs.soft.workshop.web.ViewController;

@FacesConverter(forClass = Date.class, value="dateConverter")
public class DateConverter implements Converter {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat(ViewController.DATE_FORMAT);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		try {
			return Objects.nonNull(value) ? FORMAT.parse(value) : null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		return value instanceof Date ? FORMAT.format((Date) value) : null;
	}

}
