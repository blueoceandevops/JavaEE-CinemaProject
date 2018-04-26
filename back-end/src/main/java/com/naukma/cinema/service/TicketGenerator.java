package com.naukma.cinema.service;

import com.naukma.cinema.domain.Ticket;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;

import static org.apache.commons.lang.StringUtils.leftPad;

@Component
public class TicketGenerator {

    private final TemplateEngine templateEngine;

    public TicketGenerator(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String createTicket(Ticket ticket) throws Exception {
        Context context = new Context();
        context.setVariable("ticket", ticket);
        context.setVariable("barcode", createBarcode(ticket.getId()));
        return templateEngine.process("ticket", context);
    }

    private String createBarcode(Integer ticketId) throws Exception {
        String id = leftPad(ticketId.toString(), 12, "0");
        DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        Configuration configuration = builder.build("classpath:/templates/barcode-config.xml");
        BarcodeGenerator generator = BarcodeUtil.getInstance().createBarcodeGenerator(configuration);
        BitmapCanvasProvider provider = new BitmapCanvasProvider(
                300, BufferedImage.TYPE_BYTE_GRAY, true, 0);
        generator.generateBarcode(provider, id);
        provider.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(provider.getBufferedImage(), "png", outputStream);
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
