package com.company.PC_market.projection;

import com.company.PC_market.entity.Contact;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Contact.class)
public interface ContactProjection {
    Integer getId();
    String getPhone_number();
    String getEmail();
    String getTelegram_url();
}
