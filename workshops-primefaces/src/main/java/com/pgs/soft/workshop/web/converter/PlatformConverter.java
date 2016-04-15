package com.pgs.soft.workshop.web.converter;

import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pgs.soft.workshop.backend.model.Platform;
import com.pgs.soft.workshop.backend.service.Service;
import com.pgs.soft.workshop.backend.service.ServiceImpl;

@FacesConverter(value="platformConverter", forClass=Platform.class)
public class PlatformConverter implements Converter {

	private final static Logger LOG = LoggerFactory.getLogger(PlatformConverter.class);
	
	private Service service = new ServiceImpl();
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent ui, String platform) {
		Platform result = null;
		
		try {
			if (Objects.nonNull(platform) && !platform.isEmpty()) {
				int selectedId = Integer.valueOf(platform).intValue();
				for (Platform p : service.getPlatforms()) {
					if (p.getId() == selectedId) {
						result = p;
						break;
					}
				}
			}
		} catch(Exception e) {
			LOG.error("Unable to convert", e);
		}
		
		return result;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent ui, Object platform) {
		return (platform instanceof Platform) ? Integer.toString(((Platform) platform).getId()) : null;
	}

}
